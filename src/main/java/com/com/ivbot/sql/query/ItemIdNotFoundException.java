package com.com.ivbot.sql.query;

/**
 * Indicates that the given {@code ItemId} was not found.
 */
public class ItemIdNotFoundException extends NotFoundException {

    /**
     * Constructor; creates a {@link Throwable} with an informative description as to why the {@code Exception} was
     * {@code thrown}.
     *
     * @param itemId The {@code ItemId} which was not found.
     */
    public ItemIdNotFoundException(Integer itemId) {
        super(String.format("ItemId: %d was not found", itemId));
    }

}
