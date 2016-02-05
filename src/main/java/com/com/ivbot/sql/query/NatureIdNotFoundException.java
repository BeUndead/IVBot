package com.com.ivbot.sql.query;

/**
 * Indicates that the given {@code NatureId} was not found.
 */
public class NatureIdNotFoundException extends NotFoundException {

    /**
     * Constructor; creates a {@link Throwable} with an informative message as to why the {@code Exception} was
     * generated.
     *
     * @param natureId The {@code NatureId} which was not found.
     */
    public NatureIdNotFoundException(Integer natureId) {
        super(String.format("The NatureId: %d was not found", natureId));
    }

}
