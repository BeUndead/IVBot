package com.com.ivbot.compute;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests that {@code HiddenPower} {@code Type} and {@code Power} are correctly computed from the given {@code IV}s.
 */
public class HiddenPowerComputationTest {

    /**
     * Tests that a simple {@code HiddenPower} {@code Type} (should be {@code Dark}) is correctly computed from the
     * given {@code IV}s.
     *
     * @throws Exception
     */
    @Test
    public void testHiddenPowerDarkTypeIdFromIVs() throws Exception {

        int[] ivs = new int[] {31, 31, 31, 31, 31, 31};
        Integer typeId = HiddenPowerComputation.getTypeIdOfHiddenPowerFromIvs(ivs);
        Integer darkTypeId = Integer.valueOf(17);

        assertEquals("The TypeId was not as expected", darkTypeId, typeId);
    }

    /**
     * Tests that a simple {@code HiddenPower} {@code Type} (should be {@code Fire}) is correctly computed from the
     * given {@code IV}s.
     *
     * @throws Exception
     */
    @Test
    public void testHiddenPowerFireTypeIdFromIVs() throws Exception {

        int[] ivs = new int[] {29, 23, 6, 12, 11, 24};
        Integer typeId = HiddenPowerComputation.getTypeIdOfHiddenPowerFromIvs(ivs);
        Integer fireTypeId = Integer.valueOf(10);

        assertEquals("The TypeId was not as expected", fireTypeId, typeId);
    }

    /**
     * Tests that the correct {@code Power} is computed from the given {@code IV}s in the case of max {@code IV}s.
     *
     * @throws Exception
     */
    @Test
    public void testPreGenVIHiddenPowerPowerForMaxIVsFromIVs() throws Exception {

        int[] ivs = new int[] {31, 31, 31, 31, 31, 31};
        int power = HiddenPowerComputation.getPreGenVIPowerOfHiddenPowerFromIvs(ivs);
        int expectedPower = 70;

        assertEquals("The Power was not as expected", expectedPower, power);
    }

    /**
     * Tests that the correct {@code Power} is computed from the given {@code IV}s in the case of random {@code IV}s.
     *
     * @throws Exception
     */
    @Test
    public void testPreGenVIHiddenPowerPowerForRandomIVsFromIVs() throws Exception {

        int[] ivs = new int[] {10, 25, 21, 4, 21, 3};
        int power = HiddenPowerComputation.getPreGenVIPowerOfHiddenPowerFromIvs(ivs);
        int expectedPower = 35;

        assertEquals("The Power was not as expected", expectedPower, power);
    }

    /**
     * Tests that the correct {@code Power} as per {@code Generation 6} is computed from the given {@code IV}s.
     *
     * @throws Exception
     */
    @Test
    public void testGenVIHiddenPowerPowerFromIVs() throws Exception {

        int[] ivs = new int[] {1, 2, 3, 4, 5, 6};
        int power = HiddenPowerComputation.getGenVIPowerOfHiddenPowerFromIvs(ivs);
        int expectedPower = 60;

        assertEquals("The Power was not as expected", expectedPower, power);
    }

}
