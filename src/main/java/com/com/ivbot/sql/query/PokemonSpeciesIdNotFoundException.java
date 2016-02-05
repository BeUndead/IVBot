package com.com.ivbot.sql.query;

/**
 * Indicates that the given {@code PokemonSpeciesId} was not found.
 */
public class PokemonSpeciesIdNotFoundException extends NotFoundException {

    /**
     * Constructor; creates a {@link Throwable} with an informative description as to why the {@code Exception} was
     * {@code thrown}.
     *
     * @param pokemonSpeciesId The {@code PokemonSpeciesId} which was not found.
     */
    public PokemonSpeciesIdNotFoundException(Integer pokemonSpeciesId) {
        super(String.format("PokemonSpeciesId: %d was not found", pokemonSpeciesId));
    }

}
