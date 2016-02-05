package com.com.ivbot.sql.query;

import static com.com.ivbot.sql.schema.Tables.ALIASES;
import static com.com.ivbot.sql.schema.Tables.POKEMON_SPECIES_NAMES;

/**
 * Handles queries relating to the {@link com.com.ivbot.sql.schema.tables.PokemonSpecies} table.
 */
public class PokemonSpeciesQuery extends Query {

    /**
     * Retrieves the {@code PokemonSpeciesId} of the Pokemon specified in {@code input} (if one can be found).
     * <p>
     * If there are multiple matching {@code PokemonSpeciesNamesRecord}s, it returns the one with the longest {@code
     * NAME}.
     *
     * @param input The {@code String} in which the {@code PokemonSpeciesName} should be found.
     *
     * @return The {@code PokemonSpeciesId} of the pokemon specified in {@code input}.
     *
     * @throws PokemonSpeciesNotRecognisedException If there is no recognised {@code PokemonSpeciesName} found in {@code
     *                                              input}.
     */
    public static Integer getPokemonSpeciesIdFromQuery(String input) throws PokemonSpeciesNotRecognisedException {

        try {
            return findIdFromQuery(input, POKEMON_SPECIES_NAMES.POKEMON_SPECIES_ID, POKEMON_SPECIES_NAMES.NAME,
                                   POKEMON_SPECIES_NAMES);
        } catch (NotRecognisedException nre) {
            try {
                return findIdFromQuery(input, ALIASES.POKEMON_ID, ALIASES.NAME, ALIASES);
            } catch (NotRecognisedException nre2) {
                throw new PokemonSpeciesNotRecognisedException(input);
            }
        }
    }

    /**
     * Retrieves the {@code PokemonSpeciesName} of the Pokemon species specified by the given {@code pokemonSpeciesId}.
     *
     * @param pokemonSpeciesId The {@code PokemonSpeciesId} of the Pokemon whos {@code PokemonSpeciesName} is to be
     *                         retrieved.
     *
     * @return The {@code PokemonSpeciesName} of the Pokemon species specified by the given {@code pokemonSpeciesId}.
     *
     * @throws PokemonSpeciesIdNotFoundException If the provided {@code PokemonSpeciesId} was not found.
     */
    public static String getPokemonSpeciesNameFromPokemonSpeciesId(Integer pokemonSpeciesId)
            throws PokemonSpeciesIdNotFoundException {

        try {
            return findNameFromId(pokemonSpeciesId, POKEMON_SPECIES_NAMES.POKEMON_SPECIES_ID,
                                  POKEMON_SPECIES_NAMES.NAME, POKEMON_SPECIES_NAMES);
        } catch (NotFoundException nfe) {
            throw new PokemonSpeciesIdNotFoundException(pokemonSpeciesId);
        }
    }

}
