package com.com.ivbot.sql.query;

/**
 * Indicates that the given {@code MoveId} was not found.
 */
public class MoveIdNotFoundException extends NotFoundException {

    /**
     * Constructor; creates a {@link Throwable} with an informative description as to why the {@code Exception} was
     * {@code thrown}.
     *
     * @param moveId The {@code MoveId} which was not found.
     */
    public MoveIdNotFoundException(Integer moveId) {
        super(String.format("MoveId: %d was not found", moveId));
    }

}
