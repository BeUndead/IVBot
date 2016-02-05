package com.com.ivbot.sql.query;

import static com.com.ivbot.sql.schema.Tables.ITEM_NAMES;

/**
 * Handles queries relating to the {@link com.com.ivbot.sql.schema.tables.Items} table.
 */
public class ItemQuery extends Query {

    /**
     * Retrieves the {@code ItemId} of the Item in {@code input} (if one can be found).
     *
     * @param input The {@code String} in which the {@code ItemName} should be found.
     *
     * @return The {@code ItemId} of the Item found in {@code input}.
     *
     * @throws ItemNotRecognisedException If there is no recognised {@code ItemName} found in {@code input}.
     */
    public static Integer getItemIdFromQuery(String input) throws ItemNotRecognisedException {

        try {
            return findIdFromQuery(input, ITEM_NAMES.ITEM_ID, ITEM_NAMES.NAME, ITEM_NAMES);
        } catch (NotRecognisedException nre) {
            throw new ItemNotRecognisedException(input);
        }
    }

    /**
     * Retrieves the {@code ItemName} of the Item specified by the given {@code itemId}.
     *
     * @param itemId The {@code itemId} of the Item whos {@code ItemName} is to be retrieved.
     *
     * @return The {@code ItemName} of the Item specified by the given {@code itemId}.
     *
     * @throws ItemIdNotFoundException If the provided {@code itemId} was not found.
     */
    public static String getItemNameFromItemId(Integer itemId) throws ItemIdNotFoundException {

        try {
            return findNameFromId(itemId, ITEM_NAMES.ITEM_ID, ITEM_NAMES.NAME, ITEM_NAMES);
        } catch (NotFoundException nfe) {
            throw new ItemIdNotFoundException(itemId);
        }
    }

}
