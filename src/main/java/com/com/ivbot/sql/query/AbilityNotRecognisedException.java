package com.com.ivbot.sql.query;

/**
 * Indicates that the {@code Abilities} was not recognised in the given query.
 */
public class AbilityNotRecognisedException extends NotRecognisedException {

    /**
     * Constructor; generates a {@link Throwable} informing that the {@code Ability} was not recognised.
     *
     * @param input The query in which the {@code Ability} was not recognised.
     */
    public AbilityNotRecognisedException(String input) {
        super(String.format("Ability not recognised in input: %s", input));
    }

}
