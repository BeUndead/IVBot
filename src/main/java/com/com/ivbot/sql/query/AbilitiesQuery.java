package com.com.ivbot.sql.query;

import static com.com.ivbot.sql.schema.Tables.ABILITY_NAMES;

/**
 * Handles queries relating to the {@link com.com.ivbot.sql.schema.tables.Abilities} table.
 */
public class AbilitiesQuery extends Query {

    /**
     * Retrieves the {@code AbilityId} of the Ability in {@code input} (if one can be found).
     *
     * @param input The {@code String} in which the {@code AbilityName} should be found.
     *
     * @return The {@code AbilityId} of the Ability found in {@code input}.
     *
     * @throws AbilityNotRecognisedException If there is no recognised {@code AbilityName} found in {@code input}.
     */
    public static Integer getAbilityIdFromQuery(String input) throws AbilityNotRecognisedException {

        try {
            return findIdFromQuery(input, ABILITY_NAMES.ABILITY_ID, ABILITY_NAMES.NAME, ABILITY_NAMES);
        } catch (NotRecognisedException nre) {
            throw new AbilityNotRecognisedException(input);
        }
    }

    /**
     * Retrieves an {@code Array} of {@code String}s of the {@code AbilityName}s associated with the specified {@code
     * AbilityId}s.
     *
     * @param abilityIds An {@code Array} of {@code AbilityId}s of which to retrieve the {@code AbilityName}s.
     *
     * @return An {@code Array} of the {@code AbilityName}s associated with the specified {@code AbilityId}s.
     *
     * @throws AbilityIdNotFoundException If any of the specified {@code AbilityId}s do not have an entry in the {@code
     *                                    AbilityNames} table.
     */
    public static String[] getAbilityNamesFromAbilityIds(Integer[] abilityIds) throws AbilityIdNotFoundException {

        String[] results = new String[] {"", "", ""};
        for (int i = 0; i < 3; i++) {
            results[i] = getAbilityNameFromAbilityId(abilityIds[i]);
        }

        return results;
    }

    /**
     * Retrieves the {@code AbilityName} of the Ability specified by the given {@code abilityId}.
     *
     * @param abilityId The {@code abilityId} of the Ability whose {@code AbilityName} is to be retrieved.
     *
     * @return The {@code AbilityName} of the Ability specified by the given {@code abilityId}.
     *
     * @throws AbilityIdNotFoundException If the provided {@code abilityId} was not found.
     */
    public static String getAbilityNameFromAbilityId(Integer abilityId) throws AbilityIdNotFoundException {

        if (abilityId.equals(Integer.valueOf(0))) {
            return "";
        }

        try {
            return findNameFromId(abilityId, ABILITY_NAMES.ABILITY_ID, ABILITY_NAMES.NAME, ABILITY_NAMES);
        } catch (NotFoundException nfe) {
            throw new AbilityIdNotFoundException(abilityId);
        }
    }

}
