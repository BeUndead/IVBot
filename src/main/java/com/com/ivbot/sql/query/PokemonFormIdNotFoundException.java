package com.com.ivbot.sql.query;

/**
 * Indicates that a given {@code PokemonFormId} could not be found.
 */
public class PokemonFormIdNotFoundException extends NotFoundException {

    /**
     * Constructor; generates a {@code Throwable} to indicate that the specified {@code pokemonFormId} could not be
     * found.
     *
     * @param pokemonFormId The {@code PokemonFormId} which could not be found.
     */
    public PokemonFormIdNotFoundException(Integer pokemonFormId) {
        super(String.format("The PokemonFormId: %d was not found", pokemonFormId));
    }

}
