package com.com.ivbot.listen;

import com.com.ivbot.listen.security.IVBotAccessLevel;
import com.com.ivbot.listen.security.IVBotAccessLevelsManager;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;
import org.pircbotx.hooks.types.GenericMessageEvent;

import static com.com.ivbot.listen.util.ListenerUtilities.COMMAND_TRIGGER;

/**
 * A command which requires the user has a certain {@code AccessLevel} in order to implement.
 */
public abstract class LevelledCommandListener extends CommandListener {

    private static final String ACCESS_DENIED_RESPONSE = "Access denied.";
    /**
     * The minimum {@code AccessLevel} required for a user to have access to this command.
     */
    final IVBotAccessLevel MINIMUM_ACCESS_LEVEL;

    /**
     * Constructor; sets {@code COMMAND_NAME} and {@code MINIMUM_ACCESS_LEVEL}.
     *
     * @param level The desired minimum {@code IVBotAccessLeve} required for a user to access this command.
     */
    public LevelledCommandListener(IVBotAccessLevel level) {
        super();
        this.MINIMUM_ACCESS_LEVEL = level;
    }

    /**
     * Tests if the user has the required {@code AccessLevel} in order to access this command; if they do, it responds
     * as per usual; if they do not, it informs them that access was denied.
     *
     * @param event The {@code GenericMessageEvent} to be processed.
     */
    @Override
    public void onGenericMessage(GenericMessageEvent event) {
        String message = event.getMessage();
        if (message.startsWith(COMMAND_TRIGGER + COMMAND_NAME)) {
            if (IVBotAccessLevelsManager.hasLevel(event.getUser().getNick(), MINIMUM_ACCESS_LEVEL)) {
                super.onGenericMessage(event);
            } else {
                if (event instanceof MessageEvent) {
                    ((MessageEvent) event).getChannel().send().message(ACCESS_DENIED_RESPONSE);
                } else if (event instanceof PrivateMessageEvent) {
                    event.respond(ACCESS_DENIED_RESPONSE);
                }
            }
        }
    }

}
