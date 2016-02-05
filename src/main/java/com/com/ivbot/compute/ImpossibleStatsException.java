package com.com.ivbot.compute;

import java.util.Arrays;

/**
 * Indicates that the given {@code Stat}s are impossible to occur with the given parameters (for any {@code IV}s).
 */
public class ImpossibleStatsException extends Exception {

    /**
     * Constructor; creates a {@link Throwable} with an informative message as to why the {@code Exception} was thrown.
     *
     * @param stats The {@code Stat}s value which were impossible.
     */
    public ImpossibleStatsException(int[] stats) {
        super(String.format("The stat %s is not possible", Arrays.toString(stats)));
    }

}
