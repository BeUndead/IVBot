package com.com.ivbot.listen;

import com.com.ivbot.listen.security.IVBotAccessLevel;
import com.com.ivbot.listen.security.IVBotAccessLevelsManager;
import com.com.ivbot.listen.util.MessageFormats;
import com.google.common.collect.ImmutableSet;
import org.pircbotx.hooks.Listener;

import java.util.ArrayList;
import java.util.List;

import static com.com.ivbot.listen.util.ListenerUtilities.COMMAND_TRIGGER;

/**
 * CommandsCommand lists the available commands supported by this {@code PircBotX}.  Added implementations during
 * run-time should be included in the {@code commands.txt} file to ensure inclusion.
 */
@IVBotCommand (value = "commands", explicitHelp = true)
public final class CommandsCommand extends NonRestrictedCommandListener {

    /**
     * A general "help" response to commands (self-explanatory command is self-explanatory).
     *
     * @param message The message to respond to (specifying which part to request help with).
     *
     * @return Some incredibly helpful help response.
     */
    protected List<String> getHelp(String message) {

        String description = "Lists the commands available to the requesting user";
        String usage = "";

        return MessageFormats.helpFormat(COMMAND_NAME, description, usage);
    }

    /**
     * Lists the commands supported by this {@code PircBotX}.
     *
     * @param message The message to respond to.
     *
     * @return A {@code String[]} of the supported commands.
     */
    protected List<String> getResponse(String message) {
        ImmutableSet<Listener> currentListeners =
                latestEvent.getBot().getConfiguration().getListenerManager().getListeners();
        String userNick = latestEvent.getUser().getNick();
        StringBuilder responseStringBuilder = new StringBuilder();
        responseStringBuilder.append("Available commands:");
        for (Listener listener : currentListeners) {
            if (listener instanceof LevelledCommandListener) {
                LevelledCommandListener levelledListener = (LevelledCommandListener) listener;
                IVBotAccessLevel levelForCommand = levelledListener.MINIMUM_ACCESS_LEVEL;
                if (IVBotAccessLevelsManager.hasLevel(userNick, levelForCommand)) {
                    responseStringBuilder
                            .append(String.format(" %s%s", COMMAND_TRIGGER, ((CommandListener) listener).COMMAND_NAME));
                }
            } else if (listener instanceof CommandListener) {
                responseStringBuilder
                        .append(String.format(" %s%s", COMMAND_TRIGGER, ((CommandListener) listener).COMMAND_NAME));
            }
        }
        List<String> response = new ArrayList<>();
        if (responseStringBuilder.toString().equals("Available commands:")) {
            response.add("Available commands: None");
        } else {
            response.add(responseStringBuilder.toString());
        }
        return response;
    }

}
