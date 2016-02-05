package com.com.ivbot.sql.query;

/**
 * Indicates that the requested entity was recognised, but not found.
 */
public class NotFoundException extends Exception {

    /**
     * Constructor; generates a {@link Throwable} with an informative {@code String}.
     *
     * @param input The informative {@code String}.
     */
    public NotFoundException(String input) {
        super(input);
    }

    /**
     * Constructor; generates a {@code Throwable} with an informative {@code String}.
     *
     * @param id The {@code Integer} which was not found.
     */
    public NotFoundException(Integer id) {
        super(String.format("No matching entry found for %d", id));
    }

    /**
     * Constructor; generates a {@code Throwable} without an informative {@code String}.
     */
    public NotFoundException() {
        super();
    }

}
