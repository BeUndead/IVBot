package com.com.ivbot.compute;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests that the {@code Stat} computation works as expected.
 */
public class StatComputationTest {

    /**
     * Tests that the correct {@code Stat} values are computed for a given {@code Pokemon} and set of parameters.
     *
     * @throws Exception
     */
    @Test
    public void testStatComputation() throws Exception {

        int[] baseStats = new int[] {165, 75, 80, 40, 45, 65}; // alomomola
        int natureId = 18; // lax
        int level = 71;
        int[] ivs = new int[] {6, 30, 14, 0, 9, 23};
        int[] evs = new int[] {86, 4, 23, 14, 100, 175};

        int[] computedStats = StatsComputation.getStatsFromVariables(baseStats, natureId, level, ivs, evs);

        assertEquals("Computed stats of Unexpected length", 6, computedStats.length);

        int[] expectedStats = new int[] {334, 133, 145, 63, 83, 144};

        for (int statId = 0; statId < 6; statId++) {
            assertEquals(String.format("Stat for " +
                                       "StatId %d was" +
                                       " not as " +
                                       "expected", statId), expectedStats[statId], computedStats[statId]);
        }
    }

    /**
     * Tests that the correct {@code Stat}s are computed for the <i>special case</i> of {@code Shedinja}, where the
     * {@code BaseStat} for {@code HP} is {@code 1}.
     *
     * @throws Exception
     */
    @Test
    public void testHPIsComputedCorrectlyForShedinja() throws Exception {

        int[] baseStats = new int[] {1, 90, 45, 30, 30, 40}; // shedinja
        int natureId = 16; // jolly
        int level = 100;
        int[] ivs = new int[] {31, 31, 31, 31, 31, 31};
        int[] evs = new int[] {252, 6, 0, 0, 0, 252};

        int[] computedStats = StatsComputation.getStatsFromVariables(baseStats, natureId, level, ivs, evs);

        assertEquals("Computed stats of unexpected length", 6, computedStats.length);

        int[] expectedStats = new int[] {1, 217, 126, 86, 96, 196};

        for (int statId = 0; statId < 6; statId++) {
            assertEquals(String.format("Stat for StatId %d was not as expected", statId),
                         expectedStats[statId], computedStats[statId]);
        }
    }

}
