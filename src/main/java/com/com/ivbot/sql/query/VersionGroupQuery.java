package com.com.ivbot.sql.query;

import java.util.List;

import static com.com.ivbot.sql.schema.Tables.VERSIONS;
import static com.com.ivbot.sql.schema.Tables.VERSION_GROUPS;
import static com.com.ivbot.sql.schema.Tables.VERSION_NAMES;

/**
 * Handles requests to the {@code VersionGroups} table.
 */
public class VersionGroupQuery extends Query {

    /**
     * Retrieves a {@code String} representation of all of the {@code Version}s associated with the specified {@code
     * VersionGroupId}.
     *
     * @param versionGroupId The {@code VersionGroupId} of which to return the associated {@code VersionName}s.
     *
     * @return A {@code String} consisting of a concatenation of all of the {@code Version}s associated with the
     * specified {@code VersionGroupId}.
     *
     * @throws VersionGroupIdNotFoundException If the given {@code VersionGroupId} does not exist in the {@code
     *                                         pokedb.sqlite}.
     */
    public static String getVersionGroupNameFromVersionGroupId(Integer versionGroupId)
            throws VersionGroupIdNotFoundException {

        List<String> results = context.select()
                                      .from(VERSION_NAMES.join(VERSIONS).on(VERSION_NAMES.VERSION_ID.equal(VERSIONS.ID))
                                                         .join(VERSION_GROUPS)
                                                         .on(VERSIONS.VERSION_GROUP_ID.equal(VERSION_GROUPS.ID)))
                                      .where(VERSION_GROUPS.ID.equal(versionGroupId))
                                      .fetch(VERSION_NAMES.NAME, String.class);

        if (results.isEmpty()) {
            throw new VersionGroupIdNotFoundException(versionGroupId);
        }

        StringBuilder versionGroupName = new StringBuilder();
        for (int versionCounter = 0; versionCounter < results.size(); versionCounter++) {
            if (versionCounter != 0) {
                versionGroupName.append("/");
            }
            versionGroupName.append(results.get(versionCounter));
        }

        return versionGroupName.toString();
    }

}
