package com.com.ivbot.sql.query;

/**
 * Indicates that the {@code Type} was not recognised in the given query.
 */
public class TypeNotRecognisedException extends NotRecognisedException {

    /**
     * Constructor; generates a {@link Throwable} informing that the {@code Type} was not recognised.
     *
     * @param input The query in which the {@code Type} was not recognised.
     */
    public TypeNotRecognisedException(String input) {
        super(String.format("Type not recognised in input: %s", input));
    }

}
