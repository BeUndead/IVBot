package com.com.ivbot.sql.query;

import com.com.ivbot.sql.schema.tables.records.TypeEfficacyRecord;
import org.jooq.Result;

import java.util.List;

import static com.com.ivbot.sql.schema.Tables.TYPE_EFFICACY;

/**
 * Queries for the {@code TypeEfficacy} of specified {@code Types} against other {@code Types}.
 */
public class TypeEfficacyQuery extends Query {

    /**
     * Fetches the {@code TypeEfficacyRecord} for <i>all</i> {@code Types} against the given {@code targetTypeId}.
     *
     * @param targetTypeId The {@code TypeId} of the target {@code Type}.
     *
     * @return A {@code List} of all {@code TypeEfficacyRecords} where the target {@code Type} is the given {@code
     * targetTypeId}.
     *
     * @throws TypeIdNotFoundException If the provided {@code targetTypeId} cannot be found in the database.
     */
    public static List<TypeEfficacyRecord> getTypeEfficaciesForTargetTypeId(Integer targetTypeId)
            throws TypeIdNotFoundException {

        Result<TypeEfficacyRecord> results =
                context.selectFrom(TYPE_EFFICACY).where(TYPE_EFFICACY.TARGET_TYPE_ID.equal(targetTypeId)).fetch();

        if (results.isEmpty()) {
            throw new TypeIdNotFoundException(targetTypeId);
        }

        return results;
    }

    /**
     * Fetches the {@code TypeEfficacyRecord} for <i>all</i> {@code Types} for attacks of the given {@code
     * attackingTypeId}.
     *
     * @param attackingTypeId The {@code TypeId} of the attacking {@code Move}.
     *
     * @return A {@code List} of all {@code TypeEfficacyRecords} where the attacking {@code Type} is the given {@code
     * targetTypeId}.
     *
     * @throws TypeIdNotFoundException If the provided {@code attackingTypeId} cannot be found in the database.
     */
    public static List<TypeEfficacyRecord> getTypeEfficaciesForAttackingTypeId(Integer attackingTypeId)
            throws TypeIdNotFoundException {

        Result<TypeEfficacyRecord> results =
                context.selectFrom(TYPE_EFFICACY).where(TYPE_EFFICACY.DAMAGE_TYPE_ID.equal(attackingTypeId)).fetch();

        if (results.isEmpty()) {
            throw new TypeIdNotFoundException(attackingTypeId);
        }

        return results;
    }
}
