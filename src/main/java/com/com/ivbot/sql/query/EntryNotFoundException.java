package com.com.ivbot.sql.query;

/**
 * Indicates that the requested entry (whatever that may be) was not found in the database.
 * <p>
 * This is effectively the same as a {@code NoResultsException}, however we have more control over the message with a
 * local version of the {@code Throwable}.
 */
public class EntryNotFoundException extends NotFoundException {

    /**
     * Constructor; generates a {@link Throwable} with an informative message as to why the {@link Exception} was
     * thrown.
     *
     * @param description An informative description as to why the {@code Exception} was thrown.
     */
    public EntryNotFoundException(String description) {
        super(description);
    }

}
