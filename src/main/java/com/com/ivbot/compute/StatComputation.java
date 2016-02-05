package com.com.ivbot.compute;

import com.com.ivbot.sql.query.NatureIdNotFoundException;
import com.com.ivbot.sql.query.NatureQuery;

/**
 * Handles the computation of {@code Stat}s from the provided parameters.
 */
class StatComputation {

    /**
     * The {@code StatId} of the {@code HP} {@code Stat}.
     */
    private static final int HP = 0;

    /**
     * A hint to the <i>decreased</i> {@code Stat} in the {@code Array} retrieved from the {@code NatureQuery}.
     */
    private static final int DECREASED = 0;
    /**
     * A hint to the <i>increased</i> {@code Stat} in the {@code Array} retrieved from the {@code NatureQuery}.
     */
    private static final int INCREASED = 1;

    /**
     * Computes the value of a {@code Stat} with the given parameters.
     *
     * @param statId   The {@code StatId} of the {@code Stat} of which this computation is for.
     * @param baseStat The {@code BaseStat} for the specified {@code Stat}.
     * @param natureId The {@code NatureId} (as specified in {@code pokedb.sqlite}) for the {@code Nature} of the {@code
     *                 Pokemon} to which the computed {@code Stat} belongs.
     * @param level    The {@code Level} of the {@code Pokemon} to which the computed {@code Stat} belongs.
     * @param iv       The {@code IV} of the {@code Stat} specified by {@code StatId} of the {@code Pokemon} to which
     *                 the computed {@code Stat} belongs.
     * @param ev       The {@code EV} of the {@code Stat} specified by {@code StatId} of the {@code Pokemon} to which
     *                 the computed {@code Stat} belongs.
     *
     * @return The value of the {@code Stat} specified by {@code StatId} with the given parameters.
     */
    protected static int getStatFromVariables(int statId, int baseStat, int natureId, int level, int iv, int ev) {

        if (statId == HP) {
            return getHPStatFromVariables(baseStat, natureId, level, iv, ev);
        } else {
            return getOtherStatFromVariables(statId, baseStat, natureId, level, iv, ev);
        }
    }

    /**
     * Computes the value of the {@code HP} {@code Stat} with the given parameters.
     *
     * @param baseStat The {@code BaseStat} for the specified {@code Stat}.
     * @param natureId The {@code NatureId} (as specified in {@code pokedb.sqlite}) for the {@code Nature} of the {@code
     *                 Pokemon} to which the computed {@code Stat} belongs.
     * @param level    The {@code Level} of the {@code Pokemon} to which the computed {@code Stat} belongs.
     * @param iv       The {@code IV} of the {@code Stat} specified by {@code StatId} of the {@code Pokemon} to which
     *                 the computed {@code Stat} belongs.
     * @param ev       The {@code EV} of the {@code Stat} specified by {@code StatId} of the {@code Pokemon} to which
     *                 the computed {@code Stat} belongs.
     *
     * @return The value of the {@code Stat} specified by {@code StatId} with the given parameters.
     */
    private static int getHPStatFromVariables(int baseStat, int natureId, int level, int iv, int ev) {

        if (baseStat == 1) { // handle Shedinja separately
            return 1;
        }
        int stat = (2 * baseStat) + iv + (ev / 4);
        return ((stat * level) / 100) + level + 10;
    }

    /**
     * Computes the value of any <i>non-</i>{@code HP} {@code Stat} with the given parameters.
     *
     * @param statId   The {@code StatId} of the {@code Stat} of which this computation is for.
     * @param baseStat The {@code BaseStat} for the specified {@code Stat}.
     * @param natureId The {@code NatureId} (as specified in {@code pokedb.sqlite}) for the {@code Nature} of the {@code
     *                 Pokemon} to which the computed {@code Stat} belongs.
     * @param level    The {@code Level} of the {@code Pokemon} to which the computed {@code Stat} belongs.
     * @param iv       The {@code IV} of the {@code Stat} specified by {@code StatId} of the {@code Pokemon} to which
     *                 the computed {@code Stat} belongs.
     * @param ev       The {@code EV} of the {@code Stat} specified by {@code StatId} of the {@code Pokemon} to which
     *                 the computed {@code Stat} belongs.
     *
     * @return The value of the {@code Stat} specified by {@code StatId} with the given parameters.
     */
    private static int getOtherStatFromVariables(int statId, int baseStat, int natureId, int level, int iv, int ev) {

        int[] natureModifiers = new int[2];

        try {
            natureModifiers = NatureQuery.getNatureModifiersFromNatureId(natureId);
        } catch (NatureIdNotFoundException ninfe) {
            natureModifiers = new int[] {1, 1}; // default to a neutral Nature (Bashful)
        }

        int stat = (2 * baseStat) + iv + (ev / 4);
        stat = ((stat * level) / 100) + 5;

        // Check that both DECREASED and INCREASED stats are not the same (as per neutral Natures).
        if (natureModifiers[DECREASED] != natureModifiers[INCREASED]) {
            if (natureModifiers[DECREASED] == statId) {
                stat *= .9;
            } else if (natureModifiers[INCREASED] == statId) {
                stat *= 1.1;
            }
        }

        return stat;
    }

}
