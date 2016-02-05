package com.com.ivbot.sql.query;

import java.util.ArrayList;
import java.util.List;

import static com.com.ivbot.sql.schema.Tables.POKEMON_FORMS;
import static com.com.ivbot.sql.schema.Tables.POKEMON_FORM_NAMES;

/**
 * Handles queries to the {@link com.com.ivbot.sql.schema.Tables#POKEMON_FORMS} table.
 */
public class PokemonFormsQuery extends Query {

    /**
     * Retrieves the {@code PokemonId} for the {@code PokemonForm} specified by the given {@code pokemonFormId}.
     *
     * @param pokemonFormId The {@code PokemonFormId} of the {@code PokemonForm} for which to retrieve the {@code
     *                      PokemonId}.
     *
     * @return The {@code PokemonId} associated with the given {@code pokemonFormId}.
     *
     * @throws PokemonFormIdNotFoundException If the {@code pokemonFormId} had no entry in the {@code POKEMON_FORMS}
     *                                        table.
     */
    public static Integer getPokemonIdFromPokemonFormId(Integer pokemonFormId) throws PokemonFormIdNotFoundException {

        Integer result = context.select().from(POKEMON_FORMS).where(POKEMON_FORMS.ID.equal(pokemonFormId))
                                .fetchOne(POKEMON_FORMS.POKEMON_ID, Integer.class);

        if (result != null) {
            return result;
        }

        throw new PokemonFormIdNotFoundException(pokemonFormId);
    }

    /**
     * Retrieves the {@code PokemonFormId} of the {@code Pokemon} specified in the given {@code String}.
     *
     * @param input The {@code String} in which to locate the {@code PokemonForm}.
     *
     * @return The {@code PokemonFormId} of the {@code Pokemon} specified in {@code input}.
     *
     * @throws PokemonFormNotRecognisedException If the {@code PokemonForm} cannot be identified from the given {@code
     *                                           input}.
     */
    public static Integer getPokemonFormIdFromQuery(String input) throws PokemonFormNotRecognisedException {

        try {
            Integer pokemonSpeciesId = PokemonSpeciesQuery.getPokemonSpeciesIdFromQuery(input);
            Integer[] pokemonFormIds = getPokemonFormIdsFromPokemonSpeciesId(pokemonSpeciesId);
            String[] pokemonFormNames = getPokemonFormNamesFromPokemonFormIds(pokemonFormIds);

            int longestMatchLength = -1;
            int longestMatchIndex = 0;
            findLongestMatch:
            for (int form = 0; form < pokemonFormNames.length; form++) {
                if (longestMatchLength < pokemonFormNames[form].length() &&
                    input.contains(pokemonFormNames[form].toLowerCase())) {
                    longestMatchLength = pokemonFormNames[form].length();
                    longestMatchIndex = form;
                }
            }

            return pokemonFormIds[longestMatchIndex];
        } catch (PokemonSpeciesNotRecognisedException |
                PokemonSpeciesIdNotFoundException |
                PokemonFormIdNotFoundException e) {

            throw new PokemonFormNotRecognisedException(input);
        }
    }

    /**
     * Retrieves a {@code List} of all the possible {@code PokemonFormIds} for Pokemon of the specified {@code
     * PokemonSpeciesId}.
     *
     * @param pokemonSpeciesId The {@code PokemonSpeciesId} of which to retrieve the {@code PokemonFormId}s for all
     *                         possible {@code PokemonForms}.
     *
     * @return An {@code Array} of all the possible {@code PokemonFormIds} for Pokemon of the specified {@code
     * PokemonSpeciesId}.
     *
     * @throws PokemonSpeciesIdNotFoundException If there are no {@code PokemonFormIds} associated with the specified
     *                                           {@code PokemonSpeciesId}.
     */
    public static Integer[] getPokemonFormIdsFromPokemonSpeciesId(Integer pokemonSpeciesId)
            throws PokemonSpeciesIdNotFoundException {

        List<Integer> pokemonIds = PokemonQuery.getPokemonIdsFromPokemonSpeciesId(pokemonSpeciesId);

        List<Integer> results = context.select().from(POKEMON_FORMS).where(POKEMON_FORMS.POKEMON_ID.in(pokemonIds))
                                       .fetch(POKEMON_FORMS.ID, Integer.class);

        if (results.isEmpty()) {
            throw new PokemonSpeciesIdNotFoundException(pokemonSpeciesId);
        }

        return results.toArray(new Integer[results.size()]);
    }

    /**
     * Retrieves a {@code List<String>} of the given {@code PokemonFormName}s of the {@code PokemonForm}s specified by
     * the given {@code pokemonFormId}s {@code List}.
     *
     * @param pokemonFormIds The {@code List} of {@code PokemonFormId}s of which to retrieve the {@code
     *                       PokemonFormName}s.
     *
     * @return The {@code List} of {@code PokemonFormName}s of the {@code PokemonForm}s specified by the given {@code
     * PokemonFormId}s {@code List}.
     *
     * @throws PokemonFormIdNotFoundException If <i>any</i> of the given {@code PokemonFormId}s cannot be found in the
     *                                        {@code PokemonFormName}s table.
     */
    public static String[] getPokemonFormNamesFromPokemonFormIds(Integer[] pokemonFormIds)
            throws PokemonFormIdNotFoundException {

        List<String> results = new ArrayList<>(pokemonFormIds.length);

        for (Integer pokemonFormId : pokemonFormIds) {
            results.add(getPokemonFormNameFromPokemonFormId(pokemonFormId));
        }
        if (results.isEmpty()) {
            throw new PokemonFormIdNotFoundException(pokemonFormIds[0]);
        }

        return results.toArray(new String[results.size()]);
    }

    /**
     * Retrieves the {@code PokemonFormName} for the {@code PokemonForm} specified by the given {@code pokemonFormId}.
     *
     * @param pokemonFormId The {@code PokemonFormId} of which to retrieve the {@code PokemonFormName}.
     *
     * @return The {@code PokemonFormName} of the {@code PokemonForm} specified by the given {@code PokemonFormId}.
     *
     * @throws PokemonFormIdNotFoundException If the {@code pokemonFormId} has no entries in the {@code PokemonForms}
     *                                        table.
     */
    public static String getPokemonFormNameFromPokemonFormId(Integer pokemonFormId)
            throws PokemonFormIdNotFoundException {

        String result =
                context.select().from(POKEMON_FORM_NAMES).where(POKEMON_FORM_NAMES.POKEMON_FORM_ID.equal(pokemonFormId))
                       .fetchOne(POKEMON_FORM_NAMES.FORM_NAME, String.class);

        if (result != null) {
            return result;
        }
        if (pokemonFormId > 0 && pokemonFormId <= 721) {
            return "";
        }

        throw new PokemonFormIdNotFoundException(pokemonFormId);
    }

    /**
     * Retrieves the full {@code PokemonName} of the {@code Pokemon} specified by the given {@code PokemonFormId}.
     *
     * @param pokemonFormId The {@code PokemonFormId} of the {@code Pokemon} of which to retrieve the full {@code
     *                      PokemonName}.
     *
     * @return The full {@code PokemonName} of the {@code Pokemon} specified by the given {@code PokemonFormId}.
     *
     * @throws PokemonFormIdNotFoundException If the {@code PokemonFormId} is not found in the database.
     */
    public static String getPokemonNameFromPokemonFormId(Integer pokemonFormId) throws PokemonFormIdNotFoundException {

        String result =
                context.select().from(POKEMON_FORM_NAMES).where(POKEMON_FORM_NAMES.POKEMON_FORM_ID.equal(pokemonFormId))
                       .fetchOne(POKEMON_FORM_NAMES.POKEMON_NAME, String.class);

        if (result != null) {
            return result;
        }
        if (pokemonFormId > 0 && pokemonFormId <= 721) {
            try {
                return PokemonSpeciesQuery.getPokemonSpeciesNameFromPokemonSpeciesId(pokemonFormId);
            } catch (PokemonSpeciesIdNotFoundException psinfe) {
                throw new PokemonFormIdNotFoundException(pokemonFormId);
            }
        }

        throw new PokemonFormIdNotFoundException(pokemonFormId);
    }

}
