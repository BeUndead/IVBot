package com.com.ivbot.sql.query;

import java.util.List;

import static com.com.ivbot.sql.schema.Tables.POKEMON;
import static com.com.ivbot.sql.schema.Tables.POKEMON_FORMS;

/**
 * Handles queries involving the {@code Pokemon} table.
 */
public class PokemonQuery extends Query {

    /**
     * Retrieves a {@code List} of the possible {@code PokemonId}s for a given {@code PokemonSpeciesId}.
     *
     * @param pokemonSpeciesId The {@code PokemonSpeciesId} of which to fetch the {@code List} of possible {@code
     *                         PokemonId}s.
     *
     * @return The {@code List} of possible {@code PokemonId}s for the specified {@code PokemonSpeciesId}.
     *
     * @throws PokemonSpeciesIdNotFoundException If there are no {@code PokemonId}s associated with the given {@code
     *                                           pokemonSpeciesId}.
     */
    public static List<Integer> getPokemonIdsFromPokemonSpeciesId(Integer pokemonSpeciesId)
            throws PokemonSpeciesIdNotFoundException {

        List<Integer> results = context.select().from(POKEMON).where(POKEMON.SPECIES_ID.equal(pokemonSpeciesId))
                                       .fetch(POKEMON.ID, Integer.class);

        if (results.isEmpty()) {
            throw new PokemonSpeciesIdNotFoundException(pokemonSpeciesId);
        }

        return results;
    }

    /**
     * Retrieves the {@code PokemonId} of the {@code PokemonForm} specified by the given {@code PokemonFormId}.
     *
     * @param pokemonFormId The {@code PokemonFormId} of the {@code PokemonForm} of which to retrieve the corresponding
     *                      {@code PokemonId}.
     *
     * @return The {@code PokemonId} of the {@code PokemonForm} specified by the given {@code PokemonFormId}.
     *
     * @throws PokemonFormIdNotFoundException If the given {@code PokemonFormId} cannot be found in the database.
     */
    public Integer getPokemonIdFromPokemonFormId(Integer pokemonFormId) throws PokemonFormIdNotFoundException {

        Integer result = context.select().from(POKEMON_FORMS).where(POKEMON_FORMS.ID.equal(pokemonFormId))
                                .fetchOne(POKEMON_FORMS.POKEMON_ID, Integer.class);

        if (result != null) {
            return result;
        }

        throw new PokemonFormIdNotFoundException(pokemonFormId);
    }

}
