package com.com.ivbot.sql.query;

import org.jooq.Record2;
import org.jooq.Result;

import static com.com.ivbot.sql.schema.Tables.POKEMON_ABILITIES;

/**
 * Handles queries to the {@code PokemonAbilities} table.
 */
public class PokemonAbilitiesQuery extends Query {

    /**
     * Retrieves the {@code AbilityName}s of the {@code Pokemon} specified by the given {@code PokemonId}.
     *
     * @param pokemonId The {@code PokemonId} of the {@code Pokemon} of which to retrieve the {@code AbilityName}s.
     *
     * @return A {@code List} of the {@code AbilityName}s of the {@code Pokemon} specified by the given {@code
     * PokemonId}.
     *
     * @throws PokemonIdNotFoundException If the given {@code PokemonId} is not in the database.
     */
    public static String[] getPokemonAbilityNamesFromPokemonId(Integer pokemonId) throws PokemonIdNotFoundException {

        Integer[] abilityIds = getPokemonAbilityIdsFromPokemonId(pokemonId);
        try {
            return AbilitiesQuery.getAbilityNamesFromAbilityIds(abilityIds);
        } catch (AbilityIdNotFoundException ainfe) {
            throw new UnexpectedDataBaseException(ainfe);
        }
    }

    /**
     * Retrieves the {@code AbilityId}s of the {@code Pokemon} specified by the given {@code PokemonId}.
     *
     * @param pokemonId The {@code PokemonId} of the {@code Pokemon} of which to retrieve the {@code AbilityId}s.
     *
     * @return An {@code Array} of the {@code AbilityId}s of the {@code Pokemon} specified by the given {@code
     * PokemonId}.
     *
     * @throws PokemonIdNotFoundException If the given {@code PokemonId} is not in the database.
     */
    public static Integer[] getPokemonAbilityIdsFromPokemonId(Integer pokemonId) throws PokemonIdNotFoundException {

        Result<Record2<Integer, Integer>> results =
                context.select(POKEMON_ABILITIES.SLOT, POKEMON_ABILITIES.ABILITY_ID).from(POKEMON_ABILITIES)
                       .where(POKEMON_ABILITIES.POKEMON_ID.equal(pokemonId)).fetch();

        if (results.isEmpty()) {
            throw new PokemonIdNotFoundException(pokemonId);
        }

        Integer[] abilityIds = new Integer[] {
                Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)};
        for (Record2<Integer, Integer> record : results) {
            abilityIds[record.value1() - 1] = record.value2();
        }

        return abilityIds;
    }

}
