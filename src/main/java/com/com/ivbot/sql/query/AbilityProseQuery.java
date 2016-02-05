package com.com.ivbot.sql.query;

import java.util.List;

import static com.com.ivbot.sql.schema.tables.AbilityProse.ABILITY_PROSE;

/**
 * Handles queries to the {@code ABILITY_PROSE} table.
 */
public class AbilityProseQuery extends Query {

    /**
     * Finds the {@code SHORT_EFFECT} of the {@code Ability} specified by {@code abilityId}.
     *
     * @param abilityId The {@code AbilityId} of the {@code Ability} to fetch the {@code SHORT_EFFECT} of.
     *
     * @return The {@code SHORT_EFFECT} of the {@code Ability} specified by {@code abilityId}.
     *
     * @throws AbilityIdNotFoundException If the {@code AbilityId} is <i>not</i> in the database.
     */
    public static String getAbilityDescriptionFromAbilityId(Integer abilityId) throws AbilityIdNotFoundException {

        List<String> results = context.select().from(ABILITY_PROSE).where(ABILITY_PROSE.ABILITY_ID.equal(abilityId))
                                      .fetch(ABILITY_PROSE.SHORT_EFFECT, String.class);

        if (results.isEmpty()) {
            throw new AbilityIdNotFoundException(abilityId);
        }

        String description = results.get(0);

        // Must replace various "links" within the response.
        description = description.replaceAll("\\[([^\\]]+)\\]\\{[^\\}]+\\}", "$1");
        description = description.replaceAll("\\[\\]\\{(?:move|type|ability|item)\\:([^\\}]+)\\}", "$1");
        return description;
    }

}
