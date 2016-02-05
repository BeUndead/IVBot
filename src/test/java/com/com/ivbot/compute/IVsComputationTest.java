package com.com.ivbot.compute;

import com.com.nfor.NFor;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests the {@link IVsComputation} class.
 */
public class IVsComputationTest {

    /**
     * Tests that the {@code IVsComputation.getIVRangesFromVariables()} method correctly contains the appropriate
     * <i>actual</i> {@code IV}.
     *
     * @throws Exception
     */
    @Test
    public void testGetIVRangesFromVariables() throws Exception {

        int[] actualIVs = new int[] {17, 13, 4, 10, 25, 15};

        int[] statValues = new int[] {92, 58, 51, 26, 41, 49};
        int[] baseStats = new int[] {70, 80, 50, 35, 35, 35}; // machop
        int natureId = 12; // impish
        int level = 31;
        int[] evs = new int[] {38, 2, 132, 3, 95, 240};

        int[][] ranges = IVsComputation.getIVRangesFromVariables(statValues, baseStats, natureId, level, evs);

        for (int statId = 0; statId < 6; statId++) {
            assertTrue(String.format("Actual IV for StatId %d was out of range", statId),
                       (ranges[statId][0] <= actualIVs[statId] && actualIVs[statId] <= ranges[statId][1]));
        }
    }

    /**
     * Tests that the {@code IVsComputation.getPossibleIVsFromVariablesWithHiddenPowerType()} method correctly computes
     * the possible {@code IV}s.
     *
     * @throws Exception
     */
    @Test
    public void testGetPossibleIVsFromVariablesWithHiddenPowerType() throws Exception {

        int[] actualIVs = new int[] {16, 31, 8, 29, 28, 8};

        int[] stats = new int[] {135, 111, 45, 52, 67, 89};
        int[] baseStats = new int[] {60, 85, 40, 30, 45, 68}; // drilbur
        int natureId = 10; // Hasty
        int level = 53;
        int[] evs = new int[] {0, 0, 0, 0, 0, 0};

        int hiddenPowerType = 6; // rock

        List<Integer>[] possibleIVs = IVsComputation
                .getPossibleIVsFromVariablesWithHiddenPowerType(stats, baseStats, natureId, level, evs,
                                                                hiddenPowerType);

        for (int statId = 0; statId < 6; statId++) {
            List<Integer> possibleIVsForStat = possibleIVs[statId];

            assertTrue(String.format("Actual IV for " +
                                     "StatId %d was " +
                                     "not in "        +
                                     "results", statId),
                       possibleIVsForStat.contains(Integer.valueOf(actualIVs[statId])));
        }
    }

    /**
     * Checks that <i>all</i> of the calculated {@code IVs} returned result in the expected {@code Stats}.
     *
     * @throws Exception
     */
    @Test
    public void testThatComputedIVsAllResultInCorrectStat() throws Exception {
        // int[] actualIVs = new int[] {9, 23, 22, 3, 30, 11};

        int[] baseStats = new int[] {100, 77, 77, 128, 128, 90}; // Meloetta Pirouette
        int natureId = 9; // Gentle
        int level = 45;
        int[] evs = new int[] {10, 171, 83, 53, 3, 190};

        int[] stats = new int[] {149, 103, 83, 127, 146, 112};

        int[][] ranges = IVsComputation.getIVRangesFromVariables(stats, baseStats, natureId, level, evs);

        NFor<Integer> ivsNFor = ComputationUtilities.getNForFromIvRanges(ranges);
        for (Integer[] ivsBoxed : ivsNFor) {
            int[] ivs = ComputationUtilities.convertToPrimitive(ivsBoxed);
            int[] calculatedStats = StatsComputation.getStatsFromVariables(baseStats, natureId, level, ivs, evs);
            for (int statId = 0; statId < 6; statId++) {
                assertEquals(String.format("The stat for " +
                                           "statId %d was " +
                                           "not as " +
                                           "expected", statId), stats[statId], calculatedStats[statId]);
            }
        }
    }

}
