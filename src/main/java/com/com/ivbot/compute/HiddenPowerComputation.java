package com.com.ivbot.compute;

import com.com.nfor.NFor;

/**
 * Handles computations related to {@code HiddenPower}s.
 */
public class HiddenPowerComputation extends HiddenPowerUtilities {

    /**
     * Computes the {@code TypeId} (as defined in the {@code pokedb.sqlite} database) of the {@code HiddenPower} that a
     * {@code Pokemon} with the presented {@code IV}s would possess.
     *
     * @param ivs The {@code IV}s of the {@code Pokemon} for which to compute the {@code HiddenPower} {@code Type}.
     *
     * @return The {@code TypeId} (as defined in the {@code pokedb.sqlite} database) of the {@code HiddenPower} that a
     * {@code Pokemon} with the presented {@code IV}s would possess.
     */
    public static Integer getTypeIdOfHiddenPowerFromIvs(int[] ivs) {

        int hiddenPowerType = 0;

        int multiplier = 1;
        for (int statId = 0; statId < 6; statId++) {
            hiddenPowerType += multiplier * hiddenPowerTypeBit(ivs[STAT_ORDER[statId]]);
            multiplier <<= 1;
        }
        hiddenPowerType = (hiddenPowerType * 15) / 63;

        return Integer.valueOf(DATABASE_TYPE_ID_FROM_HIDDEN_POWER_TYPE[hiddenPowerType]);
    }

    /**
     * Computes the {@code Power} of the {@code HiddenPower} that a {@code Pokemon} with the presented {@code IV}s would
     * possess prior to {@code Generation 6}.
     *
     * @param ivs The {@code IV}s of the {@code Pokemon} for which to compute the {@code HiddenPower} {@code Power}.
     *
     * @return The {@code Power} of the {@code HiddenPower} that a {@code Pokemon} with the presented {@code IV}s would
     * possess prior to {@code Generation 6}.
     */
    public static int getPreGenVIPowerOfHiddenPowerFromIvs(int[] ivs) {

        int hiddenPowerPower = 0;

        int multiplier = 1;
        for (int statId = 0; statId < 6; statId++) {
            hiddenPowerPower += multiplier * hiddenPowerPowerBit(ivs[STAT_ORDER[statId]]);
            multiplier <<= 1;
        }
        hiddenPowerPower = ((hiddenPowerPower * 40) / 63) + 30;
        return hiddenPowerPower;
    }

    /**
     * <i>Computes</i> the {@code Power} of the {@code HiddenPower} that a {@code Pokemon} with the presented {@code
     * IV}s would possess in {@code Generation 6}.
     *
     * @param ivs The {@code IV}s of the {@code Pokemon} for which to compute the {@code HiddenPower} {@code Power}.
     *
     * @return The {@code Power} of the {@code HiddenPower} that a {@code Pokemon} with the presented {@code IV}s would
     * possess in {@code Generation 6}.  In all honesty, this returns {@code 60}, as the {@code Generation 6} {@code
     * HiddenPower} {@code Power} was set to said constant.
     */
    public static int getGenVIPowerOfHiddenPowerFromIvs(int[] ivs) {

        return 60;
    }

    public static NFor<Integer> getHiddenPowerLoopNfor() {
        return NFor.of(Integer.class).from(30, 30, 30, 30, 30, 30).to(32, 32, 32, 32, 32, 32);
    }

}
