package com.com.ivbot.sql.query;

/**
 * Indicates that {@code EVs} were not found in the specified {@code String}
 */
public class EVsNotRecognisedException extends NotRecognisedException {

    /**
     * Constructor; creates a {@link Throwable} with an informative message as to why the {@code Exception} was thrown.
     *
     * @param input The {@code String} in which the {@code EVs} could not be found.
     */
    public EVsNotRecognisedException(String input) {
        super(String.format("EVs were not recognised in %s", input));
    }

}
