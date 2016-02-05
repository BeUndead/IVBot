package com.com.ivbot.sql.query;

import java.util.List;

import static com.com.ivbot.sql.schema.Tables.MOVE_FLAVOR_TEXT;

/**
 * Handles queries to the {@code MOVE_FLAVOR_TEXT} table.
 */
public class MoveProseQuery extends Query {

    /**
     * Retrieves the {@code FlavorText} for the {@code Move} specified by the given {@code moveId}.
     *
     * @param moveId The {@code MoveId} of the {@code Move} of which to retrieve the {@code FlavorText}.
     *
     * @return The {@code FlavorText} for the {@code Move} specified by the given {@code moveId}.
     *
     * @throws MoveIdNotFoundException If the {@code MoveId} is <i>not</i> found in the database.
     */
    public static String getMoveProseFromMoveId(Integer moveId) throws MoveIdNotFoundException {

        List<String> results = context.select().from(MOVE_FLAVOR_TEXT).where(MOVE_FLAVOR_TEXT.MOVE_ID.equal(moveId))
                                      .fetch(MOVE_FLAVOR_TEXT.FLAVOR_TEXT, String.class);

        if (results.isEmpty()) {
            throw new MoveIdNotFoundException(moveId);
        }

        String flavorText = results.get(0);
        flavorText = flavorText.replaceAll("\\[([^\\]]+)\\]", "$1");
        flavorText = flavorText.replaceAll("\\{([^\\}]+)\\}", "");
        flavorText = flavorText.replaceAll("\\s", " ");
        flavorText = String.format("\"%s\"", flavorText);
        return flavorText;
    }

}
