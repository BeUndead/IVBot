package com.com.ivbot.sql.query;

/**
 * Indicates that the given {@code TypeId} was not found.
 */
public class TypeIdNotFoundException extends NotFoundException {

    /**
     * Constructor; creates a {@link Throwable} with an informative description as to why the {@code Exception} was
     * {@code thrown}.
     *
     * @param typeId The {@code TypeId} which was not found.
     */
    public TypeIdNotFoundException(Integer typeId) {
        super(String.format("TypeId: %d was not found", typeId));
    }

}
