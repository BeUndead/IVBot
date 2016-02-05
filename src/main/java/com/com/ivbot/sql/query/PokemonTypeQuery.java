package com.com.ivbot.sql.query;

import org.jooq.Record2;
import org.jooq.Result;

import static com.com.ivbot.sql.schema.Tables.POKEMON_TYPES;

/**
 * Handles queries to the {@code PokemonTypes} table.
 */
public class PokemonTypeQuery extends Query {

    /**
     * Retrieves a {@code List} of the {@code TypeName}s of the {@code Pokemon} specified by the given {@code
     * PokemonId}.
     *
     * @param pokemonId The {@code PokemonId} of the {@code Pokemon} of which to retrieve the corresponding {@code
     *                  TypeName}s.
     *
     * @return A {@code List} of the {@code TypeName}s of the {@code Pokemon} specified by the given {@code PokemonId}.
     *
     * @throws PokemonIdNotFoundException If the given {@code PokemonId} was not in {@code pokedb.sqlite}.
     */
    public static String[] getTypeNamesFromPokemonId(Integer pokemonId) throws PokemonIdNotFoundException {

        Integer[] typeIds = getTypeIdsFromPokemonId(pokemonId);

        try {
            return TypeQuery.getTypeNamesFromTypeIds(typeIds);
        } catch (TypeIdNotFoundException e) {
            // Reaching this point implies that there is an internal data base issue.  There exists a PokemonId for
            // which there is no given entry in PokemonTypes.  This should be reviewed.
            throw new UnexpectedDataBaseException(e);
        }
    }

    /**
     * Retrieves a {@code List} of the {@code TypeId}s of the {@code Pokemon} specified by the given {@code pokemonId}.
     *
     * @param pokemonId The {@code PokemonId} of the {@code Pokemon} of which to retrieve the {@code TypeId}s.
     *
     * @return A {@code List} of the {@code TypeIds} of the {@code Pokemon} specified by the given {@code pokemonId}.
     *
     * @throws PokemonIdNotFoundException If the {@code PokemonId} is not in the database.
     */
    public static Integer[] getTypeIdsFromPokemonId(Integer pokemonId) throws PokemonIdNotFoundException {

        Result<Record2<Integer, Integer>> results =
                context.select(POKEMON_TYPES.SLOT, POKEMON_TYPES.TYPE_ID).from(POKEMON_TYPES)
                       .where(POKEMON_TYPES.POKEMON_ID.equal(pokemonId)).fetch();

        if (results.isEmpty()) {
            throw new PokemonIdNotFoundException(pokemonId);
        }

        Integer[] typeIds = new Integer[] {Integer.valueOf(0), Integer.valueOf(0)};

        for (Record2<Integer, Integer> record : results) {
            typeIds[record.value1() - 1] = record.value2();
        }

        return typeIds;
    }

}
