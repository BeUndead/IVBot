package com.com.ivbot.listen;

import com.com.ivbot.listen.util.MessageFormats;
import org.pircbotx.output.OutputIRC;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Handles the leaving of a {@code Channel}.
 */
@IVBotCommand(value = "join")
public final class JoinCommand extends AdminCommandListener {

    private static final String CHANNEL_REGEX = "\\#(?<channel>[^\\s]+)";
    private static final Pattern CHANNEL_PATTERN = Pattern.compile(CHANNEL_REGEX);
    private static Matcher CHANNEL_MATCHER;

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<String> getHelp(String message) {
        String description = "Informs this Bot to join the specified channel.";
        String usage = "#<channel name>";
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
            // Join the specified channel.
            String channelName = CHANNEL_MATCHER.group("channel");
            OutputIRC irc = new OutputIRC(latestEvent.getBot());
            irc.joinChannel(channelName);

            builder.append("Joined channel ").append(channelName);
        }

        response.add(builder.toString());
        return response;
    }
}
