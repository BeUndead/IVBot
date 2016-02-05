package com.com.ivbot.sql.query;

/**
 * Indicates that the requested {@code DamageClassId} was not found in the database.
 */
public class DamageClassIdNotFoundException extends NotFoundException {

    /**
     * Constructor; generates a {@link Throwable} with a helpful message as to why the {@link Exception} was thrown.
     *
     * @param damageClassId The {@code DamageClassId} which was not found in the database.
     */
    public DamageClassIdNotFoundException(Integer damageClassId) {
        super(String.format("DamageClassId %d not found", damageClassId.intValue()));
    }

}
