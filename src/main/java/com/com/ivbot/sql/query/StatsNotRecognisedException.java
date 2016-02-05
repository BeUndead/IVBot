package com.com.ivbot.sql.query;

/**
 * Indicates that {@code Stats} were not recognised in the given {@code String}.
 */
public class StatsNotRecognisedException extends NotRecognisedException {

    /**
     * Constructor; generates a {@link Throwable} with an informative message as to why the {@code Exception} was
     * thrown.
     *
     * @param input The {@code String} in which the {@code Stats} were <i>expected</i> to be found.
     */
    public StatsNotRecognisedException(String input) {
        super(String.format("Stats were not found in %s", input));
    }

}
