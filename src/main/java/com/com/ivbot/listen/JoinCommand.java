package com.com.ivbot.listen;

import com.com.ivbot.listen.util.MessageFormats;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Handles the leaving of a {@code Channel}.
 */
// TODO - Finish off implementing this.
//@IVBotCommand(value = "join", explicitHelp = true)
public final class JoinCommand extends AdminCommandListener {

    private static final String CHANNEL_REGEX = "\\#(?<channel>[^\\s]+)";
    private static final Pattern CHANNEL_PATTERN = Pattern.compile(CHANNEL_REGEX);
    private static Matcher CHANNEL_MATCHER;

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<String> getHelp(String message) {
        String description = "Informs this Bot to join the channel.";
        String usage = "#<channel name>]";
        return MessageFormats.helpFormat(COMMAND_NAME, description, usage);
    }

    /**
     * Offers some {@code response} to the success or failure of {@code join}-ing the requested {@code Channel}.
     *
     * @param message The message to respond to.
     *
     * @return A success or failure response.
     */
    @Override
    protected List<String> getResponse(String message) {
        List<String> response = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        CHANNEL_MATCHER = CHANNEL_PATTERN.matcher(message);
        if (!CHANNEL_MATCHER.find()) {
            builder.append("No channel name recognised");
        } else {
            // Leave the specified channel.
        }

        response.add(builder.toString());
        return response;
    }
}
