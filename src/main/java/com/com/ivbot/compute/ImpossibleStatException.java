package com.com.ivbot.compute;

/**
 * Indicates that the given {@code Stat} is impossible to occur with the given parameters (for any {@code IV}).
 */
public class ImpossibleStatException extends Exception {

    /**
     * Constructor; creates a {@link Throwable} with an informative message as to why the {@code Exception} was thrown.
     *
     * @param stat The {@code Stat} value which was impossible.
     */
    public ImpossibleStatException(int stat) {
        super(String.format("The stat %d is not possible", stat));
    }

}
