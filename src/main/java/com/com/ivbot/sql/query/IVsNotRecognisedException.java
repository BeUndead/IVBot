package com.com.ivbot.sql.query;

/**
 * Indicates that {@code IVs} were not found in the specified {@code String}
 */
public class IVsNotRecognisedException extends NotRecognisedException {

    /**
     * Constructor; creates a {@link Throwable} with an informative message as to why the {@code Exception} was thrown.
     *
     * @param input The {@code String} in which the {@code IVs} could not be found.
     */
    public IVsNotRecognisedException(String input) {
        super(String.format("IVs were not recognised in %s", input));
    }

}
