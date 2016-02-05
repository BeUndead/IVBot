package com.com.ivbot.sql.query;

/**
 * Indicates that the {@code PokemonForm} was not recognised in the given {@code String}.
 */
public class PokemonFormNotRecognisedException extends NotRecognisedException {

    /**
     * Constructor; generates a {@link Throwable} with an informative message as to why the {@code Exception} was
     * thrown.
     *
     * @param input The {@code String} in which the {@code PokemonForm} was not recognised.
     */
    public PokemonFormNotRecognisedException(String input) {
        super(String.format("PokemonForm not recognised in %s", input));
    }

}
