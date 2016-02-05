package com.com.ivbot.sql.query;

import org.jooq.Record1;
import org.jooq.Record2;

import static com.com.ivbot.sql.schema.Tables.NATURES;
import static com.com.ivbot.sql.schema.Tables.NATURE_NAMES;

/**
 * Handles queries relating to the {@link com.com.ivbot.sql.schema.tables.Natures} table.
 */
public class NatureQuery extends Query {

    /**
     * Retrieves the {@code NatureId} specified in the {@code query}.
     *
     * @param query The input {@code String} which contains the {@code NatureName} for which the desired {@code
     *              NatureID} is to be returned.
     *
     * @return The {@code NatureId} for the {@code Nature} specified in the {@code query}.
     *
     * @throws NatureNameNotRecognisedException If no valid {@code NatureName} is found in the given {@code query}.
     */
    public static Integer getNatureIdFromQuery(String query) throws NatureNameNotRecognisedException {

        try {
            return findIdFromQuery(query, NATURE_NAMES.NATURE_ID, NATURE_NAMES.NAME, NATURE_NAMES);
        } catch (NotRecognisedException nre) {
            throw new NatureNameNotRecognisedException(query);
        }
    }

    /**
     * Retrieves the {@code NatureName} for the {@code Nature} specified by the given {@code natureId}.
     *
     * @param natureId The {@code NatureId} for which to return the desired {@code NatureName}.
     *
     * @return The {@code NatureName} for the {@code Nature} specified by the given {@code NatureId}.
     *
     * @throws NatureIdNotFoundException If the {@code NatureId} is not found.
     */
    public static String getNatureNameFromNatureId(Integer natureId) throws NatureIdNotFoundException {

        try {
            return findNameFromId(natureId, NATURE_NAMES.NATURE_ID, NATURE_NAMES.NAME, NATURE_NAMES);
        } catch (NotFoundException nfe) {
            throw new NatureIdNotFoundException(natureId);
        }
    }

    /**
     * Retrieves an {@code Array} of the {@code Nature}'s modified stats, with {@code [0]} representing the
     * <i>decreased</i> stat and {@code [1]} the <i>increased</i> stat.
     *
     * @param natureId The {@code NatureId} of the {@code Nature} for which to retrieve the {@code Nature}'s modified
     *                 stats.
     *
     * @return An {@code Array} of the {@code Nature}'s modified stats.
     *
     * @throws NatureIdNotFoundException If the {@code NatureId} does not exist in the database.
     */
    public static int[] getNatureModifiersFromNatureId(int natureId) throws NatureIdNotFoundException {

        Record2<Integer, Integer> result =
                context.select(NATURES.DECREASED_STAT_ID, NATURES.INCREASED_STAT_ID).from(NATURES)
                       .where(NATURES.ID.equal(Integer.valueOf(natureId))).fetchOne();

        if (result == null) {
            throw new NatureIdNotFoundException(Integer.valueOf(natureId));
        }

        int[] natureModifiers = new int[2];

        natureModifiers[0] = result.value1() - 1; // decreased
        natureModifiers[1] = result.value2() - 1; // increased

        return natureModifiers;
    }

    /**
     * Gets the {@link String} {@code NatureName} of the {@code Nature} specified by the given {@code modifiers}.
     *
     * @param modifiers The {@code NatureModifiers} of the requested {@code Nature}.
     *
     * @return The {@code NatureName} of the {@code Nature} specified by the given {@code modifiers}.
     *
     * @throws NatureModifiersNotFoundException If the given {@code modifiers} could not be resolved to a {@code
     *                                          NatureName}.
     */
    public static String getNatureNameFromNatureModifiers(int[] modifiers) throws NatureModifiersNotFoundException {
        Record1<String> result = context.select(NATURE_NAMES.NAME)
                                        .from(NATURE_NAMES.join(NATURES).on(NATURE_NAMES.NATURE_ID.equal(NATURES.ID)))
                                        .where(NATURES.DECREASED_STAT_ID.equal(modifiers[0])
                                                                        .and(NATURES.INCREASED_STAT_ID
                                                                                     .equal(modifiers[1]))).fetchOne();

        if (result == null) {
            throw new NatureModifiersNotFoundException(modifiers);
        }

        return result.value1();
    }

}
