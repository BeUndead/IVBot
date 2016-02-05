package com.com.ivbot.sql.query;

/**
 * Indicates that there was no entry in the {@literal "database"} for the specified {@code VersionGroupId}.
 */
public class VersionGroupIdNotFoundException extends NotFoundException {

    public VersionGroupIdNotFoundException(Integer versionGroupId) {
        super(String.format("versionGroupID: %d not found", versionGroupId));
    }

}
