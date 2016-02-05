package com.com.ivbot.sql.query;

/**
 * Indicates that a {@code NatureName} was not found in the specified input.
 */
public class NatureNameNotRecognisedException extends NotRecognisedException {

    /**
     * Constructor; creates a {@link Throwable} with an informative description as to why the {@code Exception} was
     * generated.
     *
     * @param input The {@link String} in which the {@code NatureName} was not located.
     */
    public NatureNameNotRecognisedException(String input) {
        super(String.format("No nature was found in %s", input));
    }

}
