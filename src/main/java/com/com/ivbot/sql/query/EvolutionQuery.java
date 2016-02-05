package com.com.ivbot.sql.query;

import java.util.ArrayList;
import java.util.List;

import static com.com.ivbot.sql.schema.Tables.POKEMON_SPECIES;

/**
 * Handles queries relating to {@code Pokemon} {@code Evolution}s.  Since there <i>isn't</i> actually a {@code Table}
 * directly relating to this, this class is slightly manufactured...  However, it <i>does</i> return information
 * regarding {@code Pokemon} {@code Evolution}s...  So there's that.
 */
public class EvolutionQuery extends Query {

    /**
     * Retrieves a {@code List} of the {@code PokemonSpeciesId}s of the prevolutions for the {@code PokemonSpecies}
     * specified by the given {@code pokemonSpeciesId}.  This {@code List} <i>may or may not</i> be empty.
     *
     * @param pokemonSpeciesId The {@code PokemonSpeciesId} of the {@code PokemonSpecies} for which to retrieve the
     *                         {@code List} of {@code PokemonSpeciesId}s for its prevolution(s).
     *
     * @return A {@code List} of the {@code PokemonSpeciesId}s of the {@code PokemonSpecies} which prevolve from the
     * given {@code PokemonSpeciesId}.
     *
     * @throws PokemonSpeciesIdNotFoundException If the given {@code PokemonSpeciesId} does not exist in the database.
     */
    public static List<Integer> getEvolutionSpeciesIdsFromPokemonSpeciesIds(Integer pokemonSpeciesId)
            throws PokemonSpeciesIdNotFoundException {

        // This is here to verify if the pokemonSpeciesId is in the table or not quickly.
        PokemonSpeciesQuery.getPokemonSpeciesNameFromPokemonSpeciesId(pokemonSpeciesId);

        List<Integer> evolutions = new ArrayList<>();

        List<Integer> results = context.select().from(POKEMON_SPECIES)
                                       .where(POKEMON_SPECIES.EVOLVES_FROM_SPECIES_ID.equal(pokemonSpeciesId))
                                       .fetch(POKEMON_SPECIES.ID, Integer.class);

        evolutions.addAll(results);

        List<Integer> furtherResults =
                context.select().from(POKEMON_SPECIES).where(POKEMON_SPECIES.EVOLVES_FROM_SPECIES_ID.in(evolutions))
                       .fetch(POKEMON_SPECIES.ID, Integer.class);

        evolutions.addAll(furtherResults);

        return evolutions;
    }

    /**
     * Retrieves a {@code List} of the {@code PokemonSpeciesId}s of the evolutions for the {@code PokemonSpecies}
     * specified by the given {@code pokemonSpeciesId}.  This {@code List} <i>may or may not</i> be empty.
     *
     * @param pokemonSpeciesId The {@code PokemonSpeciesId} of the {@code PokemonSpecies} for which to retrieve the
     *                         {@code List} of {@code PokemonSpeciesId}s for its evolution(s).
     *
     * @return A {@code List} of the {@code PokemonSpeciesId}s of the {@code PokemonSpecies} which evolve from the given
     * {@code PokemonSpeciesId}.
     *
     * @throws PokemonSpeciesIdNotFoundException If the given {@code PokemonSpeciesId} does not exist in the database.
     */
    public static List<Integer> getPrevolutionSpeciesIdsFromPokemonSpeciesIds(Integer pokemonSpeciesId)
            throws PokemonSpeciesIdNotFoundException {

        PokemonSpeciesQuery.getPokemonSpeciesNameFromPokemonSpeciesId(pokemonSpeciesId);

        List<Integer> prevolutions = new ArrayList<>();

        Integer prevolution1 = context.select().from(POKEMON_SPECIES).where(POKEMON_SPECIES.ID.equal(pokemonSpeciesId))
                                      .fetchOne(POKEMON_SPECIES.EVOLVES_FROM_SPECIES_ID, Integer.class);

        if (prevolution1 == null) {
            return prevolutions;
        }

        prevolutions.add(prevolution1);

        Integer prevolution2 = context.select().from(POKEMON_SPECIES).where(POKEMON_SPECIES.ID.equal(prevolution1))
                                      .fetchOne(POKEMON_SPECIES.EVOLVES_FROM_SPECIES_ID, Integer.class);

        if (prevolution2 == null) {
            return prevolutions;
        }

        prevolutions.add(prevolution2);
        return prevolutions;
    }

}
