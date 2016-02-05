package com.com.ivbot.compute;

/**
 * Indicates that due to internal settings, the computation was aborted (typically because it was predicted to take too
 * long to complete).
 */
public class ComputationAbortedException extends Exception {

    /**
     * Constructor; creates a {@link Throwable} with an informative message indicating the {@code reason} that the
     * computation was aborted.
     *
     * @param reason The {@code reason} that computation was aborted.
     */
    public ComputationAbortedException(String reason) {
        super(String.format("ComputationAbortedException: %s", reason));
    }

}
