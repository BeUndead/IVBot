package com.com.ivbot.sql.query;

import com.com.ivbot.sql.schema.tables.records.MovesRecord;
import org.jooq.Result;

import static com.com.ivbot.sql.schema.Tables.MOVES;

/**
 * Handles queries to the {@code MoveMeta} table.
 */
public class MoveMetaQuery extends Query {

    /**
     * Retrieves the {@code MoveMetaRecord} for the requested {@code Move} specified by the given {@code moveId}.
     *
     * @param moveId The {@code MoveId} of the {@code Move} of which to retrieve the {@code MoveMetaRecord}.
     *
     * @return The {@code MoveMetaRecord} for the requested {@code Move}.
     *
     * @throws MoveIdNotFoundException If the {@code moveId} given does <i>not</i> exist in the database.
     */
    public static MovesRecord getMoveMetaRecordFromMoveId(Integer moveId) throws MoveIdNotFoundException {

        Result<MovesRecord> results = context.selectFrom(MOVES).where(MOVES.ID.equal(moveId)).fetch();

        if (results.isEmpty()) {
            throw new MoveIdNotFoundException(moveId);
        }

        return results.get(0);
    }

}
