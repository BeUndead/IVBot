package com.com.ivbot.listen;

import com.com.ivbot.listen.security.IVBotAccessLevel;
import com.com.ivbot.listen.security.IVBotAccessLevelsManager;
import com.com.ivbot.listen.util.MessageFormats;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Handles {@code IVBotAccessLevel}s of users.
 */
@IVBotCommand ("grant")
public final class GrantAccessLevelCommand extends OwnerCommandListener {

    /**
     * The format for a command of this type to be successful.
     */
    private static final String commandFormat =
            "\\?grant[\\s]+(?<nick>[^\\s]+)[\\s]+(?<level>10|0|1|2|normal|trusted|admin|owner)";

    /**
     * The regex {@code Pattern} to compare our command to for a successful match.
     */
    private static final Pattern commandPattern = Pattern.compile(commandFormat);

    /**
     * A {@code Matcher} to store results of comparisons with input {@code String}s.
     */
    private static Matcher commandMatcher;

    /**
     * Gives information on how to use this command.
     *
     * @param message The message to respond to (specifying which part to request help with).
     *
     * @return Some incredibly helpful help response.
     */
    @Override
    protected List<String> getHelp(String message) {

        String description = "Sets the Access Level of the specified nick to the specified level";
        String usage = "<nick> <level #>|<descriptor>";

        return MessageFormats.helpFormat(COMMAND_NAME, description, usage);
    }

    /**
     * Provides the specified user the specified access level.
     *
     * @param message The message to respond to.
     *
     * @return A {@code String[]} of the supported commands.
     */
    @Override
    protected List<String> getResponse(String message) {
        commandMatcher = commandPattern.matcher(message);
        List<String> response = new ArrayList<>();
        if (commandMatcher.find()) {
            String nick = commandMatcher.group("nick");
            String accessLevel = commandMatcher.group("level");
            IVBotAccessLevel level = parseAccessLevel(accessLevel);
            IVBotAccessLevelsManager.setLevel(nick, level);
            response.add(String.format("Granted %s level %d", nick, level.getLevel()));
        } else {
            response.add("Invalid syntax");
        }
        return response;
    }

    /**
     * Tests the input {@code String} to see what {@code IVBotAccessLevel} of permissions were being modified.
     *
     * @param level The {@code String} to parse.
     *
     * @return The {@code IVBotAccessLevel} being modified.
     */
    private IVBotAccessLevel parseAccessLevel(String level) {
        if (level.contains("10") || level.contains("owner")) {
            return IVBotAccessLevel.OWNER;
        } else if (level.contains("1") || level.contains("trusted")) {
            return IVBotAccessLevel.TRUSTED;
        } else if (level.contains("2") || level.contains("admin")) {
            return IVBotAccessLevel.ADMIN;
        } else {
            return IVBotAccessLevel.NORMAL;
        }
    }

}
