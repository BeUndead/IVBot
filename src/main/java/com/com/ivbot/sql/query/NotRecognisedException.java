package com.com.ivbot.sql.query;

/**
 * Indicates that the requested entity was not recognised in the {@code input} query.
 */
public class NotRecognisedException extends Exception {

    /**
     * Constructor; generates a {@link Throwable} with an informative {@code String}.
     *
     * @param input The informative {@code String}.
     */
    public NotRecognisedException(String input) {
        super(input);
    }

}
