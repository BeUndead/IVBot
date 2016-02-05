package com.com.ivbot.listen.security;

/**
 * Represents the access level a specific user has.
 * <p>
 * Should be maintained in ascending order.  I.e. a user with a higher {@code AccessLevel#level} should have all
 * privileges of a user with a lower {@code AccessLevel#level}.
 */
public enum IVBotAccessLevel {

    /**
     * Indicates that the user should have less than {@code NORMAL} access to commands.
     */
    RESTRICTED(-1),
    /**
     * The default {@code level}.  Indicates that the user should have the standard access to commands.
     */
    NORMAL(0),
    /**
     * Indicates that the user is trusted to not abuse commands which may cause <i>spam</i> in the channel.
     */
    TRUSTED(1),
    /**
     * Indicates that the user is an admin should have access to administrative commands.
     */
    ADMIN(5),
    /**
     * Indicates that the user is an (~a co-)owner of {@code IVBot}, and should have full access to all commands.
     */
    OWNER(10);

    /**
     * The {@code level} of this {@code IVBotAccessLevel}, used for comparisons between differing {@code
     * IVBotAccessLevel}s.
     */
    private final int level;

    /**
     * Constructor; creates a new (named) {@code AccessLevel} with the given {@code level}.
     *
     * @param level The {@code level} to apply to the constructed {@code AccessLevel{.}}
     */
    IVBotAccessLevel(int level) {
        this.level = level;
    }

    /**
     * The {@code level} of the calling {@code AccessLevel}.
     *
     * @return The {@code level} of the calling {@code AccessLevel}.
     */
    public int getLevel() {
        return level;
    }

}
