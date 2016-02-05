package com.com.ivbot.sql.query;

/**
 * Indicates that the given {@code AbilityId} was not found.
 */
public class AbilityIdNotFoundException extends NotFoundException {

    /**
     * Constructor; creates a {@link Throwable} with an informative description as to why the {@code Exception} was
     * {@code thrown}.
     *
     * @param abilityId The {@code AbilityId} which was not found.
     */
    public AbilityIdNotFoundException(Integer abilityId) {
        super(String.format("AbilityId: %d was not found", abilityId));
    }

}
