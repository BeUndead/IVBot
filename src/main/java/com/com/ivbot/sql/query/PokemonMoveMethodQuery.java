package com.com.ivbot.sql.query;

import com.com.ivbot.sql.schema.tables.records.PokemonMoveMethodProseRecord;
import org.jooq.Result;

import static com.com.ivbot.sql.schema.Tables.POKEMON_MOVE_METHOD_PROSE;

/**
 * Handles queries to the {@code PokemonMoveMethodProse} table.
 */
public class PokemonMoveMethodQuery extends Query {

    /**
     * Gets the {@code Name} for the {@code PokemonMoveMethod} associated with the given {@code moveMethodId}.
     *
     * @param moveMethodId The {@code PokemonMoveMethodId} of the {@code PokemonMoveMethod} to retrieve the {@code Name}
     *                     of.
     *
     * @return The {@code Name} of the {@code PokemonMoveMethod} associated with the given {@code moveMethodId}.
     *
     * @throws PokemonMoveMethodIdNotFoundException If the {@code moveMethodId} cannot be found in the database.
     */
    public static String getPokemonMoveMethodNameFromPokemonMoveMethodId(Integer moveMethodId)
            throws PokemonMoveMethodIdNotFoundException {

        Result<PokemonMoveMethodProseRecord> results = context.selectFrom(POKEMON_MOVE_METHOD_PROSE)
                                                              .where(POKEMON_MOVE_METHOD_PROSE.POKEMON_MOVE_METHOD_ID
                                                                             .equal(moveMethodId)).fetch();

        if (results.isEmpty()) {
            throw new PokemonMoveMethodIdNotFoundException(moveMethodId);
        }

        return results.get(0).getName();
    }

}
