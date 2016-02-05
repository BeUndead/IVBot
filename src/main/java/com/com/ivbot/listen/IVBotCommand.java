package com.com.ivbot.listen;

import java.lang.annotation.*;

/**
 * Marker {@link Annotation} to indicate that the annotated {@link Class} is a {@code Command} to be added during
 * scanning. <p> <p> The assumptions of {@link Class Classes} having this {@link Annotation} is that they extend the
 * {@link CommandListener} {@code Class}, and are {@code final}. </p>
 */
@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.TYPE)
public @interface IVBotCommand {

    /**
     * The {@link CommandListener#COMMAND_NAME} to be used by this {@link IVBotCommand}.
     *
     * @return The {@code COMMAND_NAME} to be used by this {@code IVBotCommand}.
     */
    String value();

    /**
     * Indicates whether or not <i>explicit help</i> invocation is required when calling this command.  The default
     * behaviour is that {@literal "?<COMMAND_NAME>"} will invoke the <strong>help</strong> response, however for
     * certain {@link CommandListener Commands} this is the intended manner to use them.
     * <p>
     * <p> Setting this as {@code true} will require the user to query {@literal "?<COMMAND_NAME> help"} in order to
     * invoke the help response. </p>
     *
     * @return {@code true} if {@code explicitHelp} <i>is</i> required; otherwise {@code false}.
     */
    boolean explicitHelp() default false;
}
