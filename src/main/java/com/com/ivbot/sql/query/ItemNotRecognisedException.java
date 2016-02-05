package com.com.ivbot.sql.query;

/**
 * Indicates that the {@code Item} was not recognised in the given query.
 */
public class ItemNotRecognisedException extends NotRecognisedException {

    /**
     * Constructor; generates a {@link Throwable} informing that the {@code Item} was not recognised.
     *
     * @param input The query in which the {@code Item} was not recognised.
     */
    public ItemNotRecognisedException(String input) {
        super(String.format("Item not recognised in input: %s", input));
    }

}
