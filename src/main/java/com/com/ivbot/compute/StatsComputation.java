package com.com.ivbot.compute;

/**
 * Handles the computation of {@code Stats} given the required parameters.
 */
public class StatsComputation extends StatComputation {

    /**
     * Computers the {@code Stat}s of a {@code Pokemon} with the given parameters.
     *
     * @param baseStats The {@code BaseStat}s of the {@code Pokemon}.
     * @param natureId  The {@code NatureId} (as specified in {@code pokedb.sqlite}) of the {@code Pokemon}.
     * @param level     The {@code Level} of the {@code Pokemon}.
     * @param ivs       The {@code IV}s of the {@code Pokemon}.
     * @param evs       The {@code EV}s of the {@code Pokemon}.
     *
     * @return An {@code Array} of the {@code Stat}s of the {@code Pokemon} with the specified parameters.
     */
    public static int[] getStatsFromVariables(int[] baseStats, int natureId, int level, int[] ivs, int[] evs) {

        int[] stats = new int[6];
        for (int statId = 0; statId < 6; statId++) {
            stats[statId] = getStatFromVariables(statId, baseStats[statId], natureId, level, ivs[statId], evs[statId]);
        }

        return stats;
    }

}
