package com.com.ivbot.sql.query;

import org.jooq.Record2;
import org.jooq.Result;

import static com.com.ivbot.sql.schema.tables.PokemonStats.POKEMON_STATS;

/**
 * Handles the extraction of {@code BaseStats} from the {@code PokemonStats} table.
 */
public class BaseStatsQuery extends Query {

    /**
     * Retrieves an {@code int[]} of the {@code BaseStats} of the {@code Pokemon} associated with {@code pokemonId}.
     *
     * @param pokemonId The {@code PokemonId} of the {@code Pokemon} of which to retrieve the {@code BaseStats} of.
     *
     * @return An {@code int[]} of the {@code BaseStats} of the {@code Pokemon} associated with {@code pokemonId}.
     *
     * @throws PokemonIdNotFoundException If the {@code pokemonId} cannot be found in the {@code PokemonStats} table.
     */
    public static int[] getBaseStatsFromPokemonId(Integer pokemonId) throws PokemonIdNotFoundException {

        Result<Record2<Integer, Integer>> results =
                context.select(POKEMON_STATS.STAT_ID, POKEMON_STATS.BASE_STAT).from(POKEMON_STATS)
                       .where(POKEMON_STATS.POKEMON_ID.equal(pokemonId)).fetch();

        if (!results.isEmpty()) {
            int[] baseStats = new int[6];
            for (Record2<Integer, Integer> record : results) {
                baseStats[record.value1() - 1] = record.value2();
            }
            return baseStats;
        }

        throw new PokemonIdNotFoundException(pokemonId);
    }

}
