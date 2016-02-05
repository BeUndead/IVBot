package com.com.ivbot.sql.query;

/**
 * Indicates that something is wrong with the underlying {@code pokedb.sqlite}, which should be reviewed.
 * <p>
 * This is deliberately {@code uncaught} to ensure that {@code .com} fixes the {@code pokedb.sqlite}.
 */
public class UnexpectedDataBaseException extends RuntimeException {

    /**
     * Constructor; generates a {@link Throwable} with an informative message as to why the {@code Exception} was
     * thrown, as well as maintaining the {@code StackTrace} by propogating {@code cause}.
     *
     * @param cause The {@code Throwable} which triggered the {@code UnexpectedDataBaseException}.
     */
    public UnexpectedDataBaseException(Throwable cause) {
        super("UnexpectedDataBaseException", cause);
    }

}
