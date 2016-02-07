package com.com.ivbot.listen;

import com.com.ivbot.listen.util.MessageFormats;
import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
import org.pircbotx.UserChannelDao;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.output.OutputChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Handles the leaving of a {@code Channel}.
 */
@IVBotCommand(value = "part", explicitHelp = true)
public final class PartCommand extends AdminCommandListener {

    private static final String CHANNEL_REGEX = "\\#(?<channel>[^\\s]+)";
    private static final Pattern CHANNEL_PATTERN = Pattern.compile(CHANNEL_REGEX);
    private static Matcher CHANNEL_MATCHER;

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<String> getHelp(String message) {
        String description = "Informs this Bot to leave the channel. If no channel is specified, it will leave the " +
                             "one in which it received the command";
        String usage = "[#<channel name>]";
        return MessageFormats.helpFormat(COMMAND_NAME, description, usage);
    }

    /**
     * Offers some {@code response} to the success or failure of {@code part}-ing the requested {@code Channel}.
     *
     * @param message The message to respond to.
     *
     * @return A success or failure response.
     */
    @Override
    protected List<String> getResponse(String message) {
        List<String> response = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        try {
            // Get the bot
            PircBotX bot = latestEvent.getBot();

            Channel channel;
            CHANNEL_MATCHER = CHANNEL_PATTERN.matcher(message);
            if (CHANNEL_MATCHER.find()) {
                // If the command gave a channel name, use it
                String channelName = CHANNEL_MATCHER.group("channel");

                UserChannelDao userChannelDao = bot.getUserChannelDao();
                if (userChannelDao.containsChannel(channelName)) {
                    // Is the bot in the specified channel?
                    channel = userChannelDao.getChannel(channelName);
                } else {
                    throw new IllegalArgumentException("I'm not in that channel :/");
                }
            } else {
                if (latestEvent instanceof MessageEvent) {
                    // Was the event sent from a channel (not PM)
                    MessageEvent messageEvent = (MessageEvent) latestEvent;
                    channel = messageEvent.getChannel();
                } else {
                    throw new IllegalArgumentException("Channel not recognised");
                }
            }

            // Instruct to leave the channel in 3 seconds, to give message time to send.
            OutputChannel outputChannel = new OutputChannel(bot, channel);
            Executors.newSingleThreadScheduledExecutor()
                     .schedule(() -> outputChannel.part("TTFN o/"),
                               3L, TimeUnit.SECONDS);

            builder.append("Okely dokely :(");
        } catch (IllegalArgumentException iae) {
            builder.append(iae.getMessage());
        }

        response.add(builder.toString());
        return response;
    }
}
