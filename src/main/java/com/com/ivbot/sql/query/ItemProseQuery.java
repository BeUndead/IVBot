package com.com.ivbot.sql.query;

import java.util.List;

import static com.com.ivbot.sql.schema.Tables.ITEMS;
import static com.com.ivbot.sql.schema.Tables.ITEM_CATEGORY_PROSE;
import static com.com.ivbot.sql.schema.Tables.ITEM_PROSE;

/**
 * Handles queries relating to the {@code ITEM_PROSE} table.
 */
public class ItemProseQuery extends Query {

    /**
     * Retrieves the {@code SHORT_EFFECT} for the {@code Item} specified by the given {@code itemId}.
     *
     * @param itemId The {@code ItemId} of the {@code Item} to retrieve the {@code SHORT_EFFECT} of.
     *
     * @return The {@code SHORT_EFFECT} for the {@code Item} specified by the given {@code itemId}.
     *
     * @throws ItemIdNotFoundException If {@code itemId} does <i>not</i> exist in the database.
     */
    public static String getItemDescriptionFromItemId(Integer itemId) throws ItemIdNotFoundException {

        List<String> results = context.select().from(ITEM_PROSE).where(ITEM_PROSE.ITEM_ID.equal(itemId))
                                      .fetch(ITEM_PROSE.SHORT_EFFECT, String.class);

        if (results.isEmpty()) {
            throw new ItemIdNotFoundException(itemId);
        }

        String itemProse = results.get(0);
        itemProse = itemProse.replaceAll("\\[([^\\]]+)\\]\\{[^\\}]+\\}", "$1");
        itemProse = itemProse.replaceAll("\\[\\]\\{(?:item|type|ability|mechanic)\\:([^\\}]+)\\}", "$1");
        return itemProse;
    }

    /**
     * Retrieves the {@code ItemCategoryName} from the specified {@code ItemId}.
     *
     * @param itemId The {@code ItemId} of which to retrieve the {@code ItemCategoryName}.
     *
     * @return The {@code ItemCategoryName} of the {@code Item} specified by the given {@code ItemId}.
     *
     * @throws ItemIdNotFoundException If the {@code itemId} does <i>not</i> exist in the database.
     */
    public static String getItemCategoryNameFromItemId(Integer itemId) throws ItemIdNotFoundException {

        List<String> results = context.select().from(ITEM_CATEGORY_PROSE.join(ITEMS)
                                                                        .on(ITEM_CATEGORY_PROSE.ITEM_CATEGORY_ID
                                                                                    .equal(ITEMS.CATEGORY_ID)))
                                      .where(ITEMS.ID.equal(itemId)).fetch(ITEM_CATEGORY_PROSE.NAME, String.class);

        if (results.isEmpty()) {
            throw new ItemIdNotFoundException(itemId);
        }

        return results.get(0);
    }

}
