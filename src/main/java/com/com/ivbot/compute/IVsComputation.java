package com.com.ivbot.compute;

import com.com.nfor.NFor;

import java.util.*;

/**
 * Handles computation of the <i>possible</i> {@code IV}s of a {@code Pokemon} with the given specifications.
 */
public class IVsComputation {

    /**
     * Used for {@code range}s, indicates that the array element of this index is the <i>minimum</i> possible {@code IV}
     * for that {@code range}.
     */
    private static final int MINIMUM = 0;
    /**
     * Used for {@code range}s, indicates that the array element of this index is the <i>maximum</i> possible {@code IV}
     * for that {@code range}.
     */
    private static final int MAXIMUM = 1;

    /**
     * Computes all possible {@code IV}s for the {@code Pokemon} of the given specifications.
     *
     * @param givenStatValues   The {@code Stat} <i>values</i> of the {@code Pokemon} in question.
     * @param baseStats         The {@code BaseStat}s of the {@code Pokemon} in question.
     * @param natureId          The {@code NatureId} of the {@code Nature} of the {@code Pokemon} (as specified by
     *                          {@code pokedb.sqlite} in question.
     * @param level             The {@code Level} of the {@code Pokemon} in question.
     * @param evs               The {@code EV}s of the {@code Pokemon} in question.
     * @param hiddenPowerTypeId The {@code TypeId} (as specified by {@code pokedb.sqlite}) of the {@code HiddenPower} of
     *                          the {@code Pokemon} for which to compute the possible {@code IV}s.
     *
     * @return All possible {@code IV}s for the {@code Pokemon} of the given specifications.
     *
     * @throws ImpossibleStatsException    If the {@code Stat}s given give no possible {@code IV} combinations.
     * @throws ComputationAbortedException If the computation was aborted due to internal settings.
     */
    public static List<Integer>[] getPossibleIVsFromVariablesWithHiddenPowerType(int[] givenStatValues, int[] baseStats,
                                                                                 int natureId, int level, int[] evs,
                                                                                 int hiddenPowerTypeId)
            throws ComputationAbortedException {

        // Stored as a Set initially, so that duplicates are automatically removed.
        Set<Integer>[] possibleIvs = new Set[6];
        for (int statId = 0; statId < 6; statId++) {
            possibleIvs[statId] = new HashSet<>();
        }

        int[][] ivRanges = getIVRangesFromVariables(givenStatValues, baseStats, natureId, level, evs);

        if (getNumberOfIterations(ivRanges) > 5000) {
            throw new ComputationAbortedException("The IV ranges were not specific enough");
        }
        NFor<Integer> ivsNfor = ComputationUtilities.getNForFromIvRanges(ivRanges);
        for (Integer[] ivsBoxed : ivsNfor) {
            int[] ivs = ComputationUtilities.convertToPrimitive(ivsBoxed);
            if (HiddenPowerComputation.getTypeIdOfHiddenPowerFromIvs(ivs) == hiddenPowerTypeId) {
                for (int statId = 0; statId < 6; statId++) {
                    possibleIvs[statId].add(ivs[statId]);
                }
            }
        }

        // Convert to a List so that ordering can be easily achieved.
        List<Integer>[] possibleIvsAsLists = new ArrayList[6];
        for (int statId = 0; statId < 6; statId++) {

            possibleIvsAsLists[statId] = new ArrayList<>(possibleIvs[statId].size());
            possibleIvsAsLists[statId].addAll(possibleIvs[statId]);
            possibleIvsAsLists[statId].sort(Comparator.naturalOrder());
        }

        return possibleIvsAsLists;
    }

    public static List<Integer>[] getPossibleIVsFromVariablesWithHiddenPowerTypeNew(int[] givenStatValues,
                                                                                    int[] baseStats,
                                                                                    int natureId,
                                                                                    int level,
                                                                                    int[] evs,
                                                                                    int hiddenPowerTypeId)
            throws ComputationAbortedException {

        if (hiddenPowerTypeId == HiddenPowerComputation.NORMAL ||
            hiddenPowerTypeId == HiddenPowerComputation.FAIRY) {

            List<Integer>[] empty = new List[6];
            for (int statId = 0; statId < 6; statId++) {
                empty[statId] = Collections.<Integer>emptyList();
            }
            return empty;
        }

        Set<Integer>[] possibleIVs = new Set[6];
        for (int statId = 0; statId < 6; statId++) {
            possibleIVs[statId] = new HashSet<>();
        }

        int[][] ivRanges = getIVRangesFromVariables(givenStatValues, baseStats, natureId, level, evs);

        HiddenPowerComputation.getHiddenPowerLoopNfor();

        // TODO - neaten IV computation for Hidden Powers...
        return null;
    }

    /**
     * Computes the possible {@code IV} {@code ranges} for all {@code Stat}s with the given parameters.
     * <p>
     * WARNING - this gives a {@code 0}-length array for the value of any {@code Stat} which is <i>not</i> possible for
     * <i>any</i> {@code IV}(s).
     *
     * @param givenStatValues The {@code Stat} <i>values</i> of the {@code Pokemon} in question.
     * @param baseStats       The {@code BaseStat}s of the {@code Pokemon} in question.
     * @param natureId        The {@code NatureId} of the {@code Nature} of the {@code Pokemon} (as specified by {@code
     *                        pokedb.sqlite} in question.
     * @param level           The {@code Level} of the {@code Pokemon} in question.
     * @param evs             The {@code EV}s of the {@code Pokemon} in question.
     *
     * @return The {@code ranges} of <i>possible</i> {@code IV}s for the {@code Pokemon} in question with the specified
     * parameters.
     */
    public static int[][] getIVRangesFromVariables(int[] givenStatValues, int[] baseStats, int natureId, int level,
                                                   int[] evs) {

        int[][] ranges = new int[6][];
        for (int statId = 0; statId < 6; statId++) {
            try {
                ranges[statId] =
                        getIVRangeFromVariables(givenStatValues[statId], statId, baseStats[statId], natureId, level,
                                                evs[statId]);
            } catch (ImpossibleStatException ise) {
                ranges[statId] = new int[0];
            }
        }

        return ranges;
    }

    /**
     * Gets the number of iterations which would be required to iterate across all possible {@code IV} combinations
     * within the specified {@code ranges}.
     *
     * @param ranges The {@code ranges} of the {@code IV}s in question.
     *
     * @return The number of iterations which would be required to iterate across all possible {@code IV} combinations
     * within the specified {@code ranges}.
     */
    private static int getNumberOfIterations(int[][] ranges) {

        int numberOfIterations = 1;
        for (int[] range : ranges) {
            numberOfIterations *= (range[MAXIMUM] - range[MINIMUM]);
        }
        return numberOfIterations;
    }

    /**
     * Computes the {@code range} of possible {@code IV}s for the {@code Stat} of the given {@code StatId} with the
     * specified parameters.
     *
     * @param givenStatValue The {@code Stat} <i>value</i> of the {@code Stat} in question.
     * @param statId         The {@code StatId} of the {@code Stat} in question.
     * @param baseStat       The {@code BaseStat} of the {@code Stat} specified by the {@code StatId} of the {@code
     *                       Pokemon} for which to compute the possible {@code IV}s.
     * @param natureId       The {@code NatureId} of the {@code Nature} of the {@code Pokemon} for which to compute the
     *                       possible {@code IV}s.
     * @param level          The {@code Level} of the {@code Pokemon} for which to compute the possible {@code IV}s.
     * @param ev             The {@code EV} of the {@code Stat} specified by the {@code StatId} of the {@code Pokemon}
     *                       for which to compute the possible {@code IV}s.
     *
     * @return The {@code range} of {@code IV}s which would give the {@code givenStatValue} under the specified
     * parameters.
     *
     * @throws ImpossibleStatException If there is <i>no</i> such {@code IV}s which would give the specified {@code
     *                                 givenStatValue}.
     */
    private static int[] getIVRangeFromVariables(int givenStatValue, int statId, int baseStat, int natureId, int level,
                                                 int ev) throws ImpossibleStatException {

        int[] range = new int[] {-1, -1};
        for (int iv = 0; iv <= 31; iv++) {
            int statValue = StatComputation.getStatFromVariables(statId, baseStat, natureId, level, iv, ev);
            if (statValue == givenStatValue) {
                if (range[MINIMUM] < 0 || range[MINIMUM] > 31) {
                    range[MINIMUM] = iv;
                }
                range[MAXIMUM] = iv;
            } else if (statValue > givenStatValue) {
                break;
            }
        }

        if (range[MINIMUM] < 0 || range[MAXIMUM] < 0) {
            throw new ImpossibleStatException(givenStatValue);
        }

        return range;
    }
}
