package com.com.ivbot.sql.query;

import org.apache.commons.lang3.text.WordUtils;

import java.util.List;

import static com.com.ivbot.sql.schema.Tables.MOVE_DAMAGE_CLASS_PROSE;

/**
 * Handles queries to the {@code MOVE_DAMAGE_CLASS} table.
 */
public class DamageClassQuery extends Query {

    /**
     * Retrieves the {@code MoveDamageClassName} from the specified {@code MoveDamageClassId}.
     *
     * @param damageClassId The {@code MoveDamageClassId} for which to return the {@code MoveDamageClassName}.
     *
     * @return The {@code MoveDamageClassName} for the specified {@code MoveDamageClassId}.
     *
     * @throws DamageClassIdNotFoundException If the {@code MoveDamageClassId} is <i>not</i> found in the database.
     */
    public static String getDamageClassNameFromDamageClassId(Integer damageClassId)
            throws DamageClassIdNotFoundException {

        List<String> results = context.select().from(MOVE_DAMAGE_CLASS_PROSE)
                                      .where(MOVE_DAMAGE_CLASS_PROSE.MOVE_DAMAGE_CLASS_ID.equal(damageClassId))
                                      .fetch(MOVE_DAMAGE_CLASS_PROSE.NAME, String.class);

        if (results.isEmpty()) {
            throw new DamageClassIdNotFoundException(damageClassId);
        }

        String damageClassName = results.get(0);
        return WordUtils.capitalize(damageClassName);
    }

}
