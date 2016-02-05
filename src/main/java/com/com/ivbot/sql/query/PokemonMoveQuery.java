package com.com.ivbot.sql.query;

import org.jooq.Record3;
import org.jooq.Result;

import static com.com.ivbot.sql.schema.Tables.POKEMON_MOVES;
import static com.com.ivbot.sql.schema.Tables.POKEMON_MOVE_METHODS;
import static com.com.ivbot.sql.schema.Tables.VERSION_GROUPS;

/**
 * Handles queries relating to the {@code PokemonMoves} table.
 */
public class PokemonMoveQuery extends Query {

    /**
     * Returns the <i>optimal</i> {@code Record} from the database for how the {@code Pokemon} specified by {@code
     * pokemonId} learns the {@code Move} specified by {@code moveId}.
     * <p>
     * <ul> <li>{@code #value1()} gives the {@code PokemonMoveMethodId};</li> <li>{@code #value2()} gives the {@code
     * VersionGroupId};</li> <li>{@code #value3()} gives the {@code Level}.</li> </ul>
     *
     * @param pokemonId The {@code PokemonId} of the {@code Pokemon} being queried.
     * @param moveId    The {@code MoveId} of the {@code Move} being queried.
     *
     * @return A {@code Record3<Integer, Integer, Integer>} representing the values specified in this documentation.
     *
     * @throws EntryNotFoundException If the {@code Pokemon} specified by {@code pokemonId} does <i>not</i> (according
     *                                to the database) learn the {@code Move} specified by {@code moveId}.
     */
    public static Record3<Integer, Integer, Integer> getOptimalRecord(Integer pokemonId, Integer moveId)
            throws EntryNotFoundException {

        Result<Record3<Integer, Integer, Integer>> results =
                context.select(POKEMON_MOVES.POKEMON_MOVE_METHOD_ID, POKEMON_MOVES.VERSION_GROUP_ID,
                               POKEMON_MOVES.LEVEL).from(POKEMON_MOVES.join(POKEMON_MOVE_METHODS)
                                                                      .on(POKEMON_MOVES.POKEMON_MOVE_METHOD_ID
                                                                                  .equal(POKEMON_MOVE_METHODS.ID))
                                                                      .join(VERSION_GROUPS)
                                                                      .on(POKEMON_MOVES.VERSION_GROUP_ID
                                                                                  .equal(VERSION_GROUPS.ID)))
                       .where(POKEMON_MOVES.POKEMON_ID.equal(pokemonId).and(POKEMON_MOVES.MOVE_ID.equal(moveId)))
                       .orderBy(VERSION_GROUPS.PREFERENCE_ORDER.asc(), POKEMON_MOVE_METHODS.PREFERENCE_ORDER.asc())
                       .fetch();

        if (results.isEmpty()) {
            throw new EntryNotFoundException(
                    String.format("There was no pokemon_moves entry for pokemon_id = %d and move_id = %d", pokemonId,
                                  moveId));
        }

        return results.get(0);
    }

}
