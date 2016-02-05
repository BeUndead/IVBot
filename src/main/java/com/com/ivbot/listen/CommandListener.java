package com.com.ivbot.listen;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.function.Consumer;

import static com.com.ivbot.listen.util.ListenerUtilities.COMMAND_TRIGGER;

/**
 * Abstract class to provide basic implementation of the methods necessary for a command, leaving specific response
 * details are left to subclass extensions.
 */
public abstract class CommandListener extends ListenerAdapter {

//    /**
//     * {@link Logger} for the {@link CommandListener} {@link Class}.
//     */
//    private static final Logger LOG = Logger.getLogger(CommandListener.class);

    /**
     * The regex to check message for being a help request.
     */
    private static final String HELP_REGEX = "[^\\s]+[\\s]+(?:help)[\\s]*";
    /**
     * The {@link String} representation for this command's name.
     */
    protected String COMMAND_NAME;
    /**
     * If {@code true}, means that the user must explicitly have {@literal " help"} appended to the command name in
     * order to invoke the help response.
     */
    protected boolean EXPLICIT_HELP = false;

    /**
     * The latest {@code Event} received which required handling.  This is occasionally used by subclasses in order to
     * handle additional requirements of their task.  For the most part it is unused however.
     */
    protected GenericMessageEvent latestEvent;

    /**
     * Constructor: creates an extending {@code CommandListener} with the passed {@code commandName} as {@code
     * COMMAND_NAME} and {@code EXPLICIT_HELP} set to {@code false}.
     */
    public CommandListener() {
        Annotation[] annotations = this.getClass().getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof IVBotCommand) {
                // If its annotated as IVBotCommand, then take the name from the annotation
                IVBotCommand command = (IVBotCommand) annotation;
                this.COMMAND_NAME = command.value();
                this.EXPLICIT_HELP = command.explicitHelp();
                break;
            }
        }
    }

    /**
     * Reviews each {@link GenericMessageEvent} received by {@code T}, and handles it via the appropriate response.
     * Other {@code CommandListener}'s are free to override other methods from the {@code ListenerAdapter} as required.
     *
     * @param event The {@code GenericMessageEvent} to be processed.
     */
    @Override
    public void onGenericMessage(GenericMessageEvent event) {

        String message = event.getMessage().toLowerCase();
        // Do nothing if the message does not match this command
        if (!message.startsWith(COMMAND_TRIGGER + COMMAND_NAME)) {
            return;
        }

//        // Log the call
//        LOG.info(String.format("COMMAND_INVOKED_BY_USER_WITH_QUERY", COMMAND_NAME, event.getUser().getNick(),
//                               event.getMessage()));

        // Store the latest event
        latestEvent = event;

        // Respond
        List<String> response;
        // With help
        if (message.matches(HELP_REGEX) || (!EXPLICIT_HELP && message.equals(COMMAND_TRIGGER + COMMAND_NAME))) {
            response = getHelp(message);
        } else { // Or with standard response
            response = getResponse(message);
        }

        // Choose appropriate response method from the event type
        Consumer<String> responseMethod = input -> {
        };
        if (event instanceof MessageEvent) {
            responseMethod = input -> ((MessageEvent) event).getChannel().send().message(input);
        } else if (event instanceof PrivateMessageEvent) {
            responseMethod = event:: respond;
        }
        // respond
        response.forEach(responseMethod);
    }

    /**
     * The help array (one line per-{@code String}).
     *
     * @param message The message to respond to (specifying which part to request help with).
     *
     * @return The help response as a {@code String[]} where each element represents an output line.
     */
    protected abstract List<String> getHelp(String message);

    /**
     * The response array (one line per-{@code String}).
     *
     * @param message The message to respond to.
     *
     * @return The response as a {@code String[]} where each element represents an output line.
     */
    protected abstract List<String> getResponse(String message);

}
