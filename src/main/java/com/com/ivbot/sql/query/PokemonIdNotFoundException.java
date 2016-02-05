package com.com.ivbot.sql.query;

/**
 * Indicates that the requested {@code PokemonId} was not found in the {@code Pokemon} table.
 */
public class PokemonIdNotFoundException extends NotFoundException {

    /**
     * Constructor; generates a {@link Throwable} with an informative message as to why the {@code Exception} was
     * thrown.
     *
     * @param pokemonId The {@code PokemonId} which was not found.
     */
    public PokemonIdNotFoundException(Integer pokemonId) {
        super(String.format("PokemonId %d was not found", pokemonId));
    }

}
