package com.com.ivbot.sql.query;

/**
 * Indicates that a {@code Level} was not found within the given {@code String}.
 */
public class LevelNotRecognisedException extends NotRecognisedException {

    /**
     * Constructor; generates a {@link Throwable} with an informative message as to why the {@code Exception} was
     * thrown.
     *
     * @param input The {@code String} message explaining why the {@code Level} was not recognised.
     */
    public LevelNotRecognisedException(String input) {
        super(String.format("Level was not found in %s", input));
    }

}
