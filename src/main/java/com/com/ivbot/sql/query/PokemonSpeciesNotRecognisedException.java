package com.com.ivbot.sql.query;

/**
 * Indicates that the {@code PokemonSpecies} was not recognised in the given query.
 */
public class PokemonSpeciesNotRecognisedException extends NotRecognisedException {

    /**
     * Constructor; generates a {@link Throwable} informing that the {@code PokemonSpecies} was not recognised.
     *
     * @param input The query in which the {@code PokemonSpecies} was not recognised.
     */
    public PokemonSpeciesNotRecognisedException(String input) {
        super(String.format("Pokemon species not recognised in input: %s", input));
    }

}
