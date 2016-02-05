package com.com.ivbot.sql.query;

/**
 * Indicates that the given {@code modifiers} could not be resolved to a {@code NatureName}.
 */
public class NatureModifiersNotFoundException extends NotFoundException {

    /**
     * Constructor; generates a {@link Exception} with an informative message as to why the {@code Exception} was
     * generated.
     *
     * @param modifiers The {@code NatureModifiers} which could not be resolved.
     */
    public NatureModifiersNotFoundException(int[] modifiers) {
        super(String.format("+%d -%d", modifiers[0], modifiers[1]));
    }

}
