package com.com.ivbot.sql.query;

import static com.com.ivbot.sql.schema.Tables.MOVE_NAMES;

/**
 * Handles queries relating to the {@link com.com.ivbot.sql.schema.tables.Moves} table.
 */
public class MoveQuery extends Query {

    /**
     * Retrieves the {@code MoveId} of the Move in {@code input} (if one can be found).
     *
     * @param input The {@code String} in which the {@code MoveName} should be found.
     *
     * @return The {@code MoveId} of the Move found in {@code input}.
     *
     * @throws MoveNotRecognisedException If there is no recognised {@code MoveName} found in {@code input}.
     */
    public static Integer getMoveIdFromQuery(String input) throws MoveNotRecognisedException {

        try {
            return findIdFromQuery(input, MOVE_NAMES.MOVE_ID, MOVE_NAMES.NAME, MOVE_NAMES);
        } catch (NotRecognisedException nre) {
            throw new MoveNotRecognisedException(input);
        }
    }

    /**
     * Retrieves the {@code MoveName} of the Move specified by the given {@code moveId}.
     *
     * @param moveId The {@code MoveId} of the Move whose {@code MoveName} is to be retrieved.
     *
     * @return The {@code MoveName} of the Ability specified by the given {@code moveId}.
     *
     * @throws MoveIdNotFoundException If the provided {@code abilityId} was not found.
     */
    public static String getMoveNameFromMoveId(Integer moveId) throws MoveIdNotFoundException {

        try {
            return findNameFromId(moveId, MOVE_NAMES.MOVE_ID, MOVE_NAMES.NAME, MOVE_NAMES);
        } catch (NotFoundException nfe) {
            throw new MoveIdNotFoundException(moveId);
        }
    }

}
