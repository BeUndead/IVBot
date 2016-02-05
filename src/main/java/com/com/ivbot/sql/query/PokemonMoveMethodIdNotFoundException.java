package com.com.ivbot.sql.query;

/**
 * Indicates that the given {@code pokemonMoveMethodId} was not found in the database.
 */
public class PokemonMoveMethodIdNotFoundException extends NotFoundException {

    /**
     * Constructor; generates a {@code Throwable} with an informative message as to why the {@code Exception} was
     * thrown.
     *
     * @param pokemonMoveMethodId The {@code pokemonMoveMethodId} which was not found.
     */
    public PokemonMoveMethodIdNotFoundException(Integer pokemonMoveMethodId) {
        super(String.format("PokemonMoveMethodId %d not found", pokemonMoveMethodId));
    }

}
