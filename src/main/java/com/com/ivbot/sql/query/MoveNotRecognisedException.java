package com.com.ivbot.sql.query;

/**
 * Indicates that the {@code Move} was not recognised in the given query.
 */
public class MoveNotRecognisedException extends NotRecognisedException {

    /**
     * Constructor; generates a {@link Throwable} informing that the {@code MoveName} was not recognised.
     *
     * @param input The query in which the {@code MoveName} was not recognised.
     */
    public MoveNotRecognisedException(String input) {
        super(String.format("Move not recognised in input: %s", input));
    }

}
