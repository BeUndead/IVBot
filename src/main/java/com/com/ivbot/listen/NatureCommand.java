package com.com.ivbot.listen;

import com.com.ivbot.listen.util.MessageFormats;
import com.com.ivbot.sql.query.NatureModifiersNotFoundException;
import com.com.ivbot.sql.query.NatureNameNotRecognisedException;
import com.com.ivbot.sql.query.NatureQuery;
import com.com.ivbot.sql.query.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Handles {@code Nature} related information.
 */
@IVBotCommand ("nature")
public final class NatureCommand extends NonRestrictedCommandListener {

    private static final String STATS_REGEX = "(?<stat>(?:att|attack|def|defense|spa|specialattack|special attack" +
                                              "|spd|specialdefense|special defense|spe|spe))";
    private static final String BOOST_REGEX = String.format("\\+%s", STATS_REGEX);
    private static final String HINDER_REGEX = String.format("\\-%s", STATS_REGEX);

    private static final Pattern BOOST_PATTERN = Pattern.compile(BOOST_REGEX);
    private static final Pattern HINDER_PATTERN = Pattern.compile(HINDER_REGEX);
    private static Matcher matcher;

    /**
     * Informs the user as to how to use this {@link CommandListener}.
     *
     * @param message The message to respond to (specifying which part to request help with).
     *
     * @return A help message of what is to be returned, and how to invoke.
     */
    @Override
    protected List<String> getHelp(String message) {
        String description = "Gives the stat-modifiers of the nature, or informs the nature from the stat-modifiers";
        String usage = "[<nature name> | <\"+\"stat \"-\"stat>]";

        return MessageFormats.helpFormat(COMMAND_NAME, description, usage);
    }

    /**
     * Informs the user the details of the specified {@code Nature}; either specified by the modifiers of the given
     * {@code Nature}, or by the {@code NatureName} of the {@code Nature}.
     *
     * @param message The message to respond to.
     *
     * @return Information of the specified {@code Nature}.
     */
    @Override
    protected List<String> getResponse(String message) {
        List<String> response = new ArrayList<>();
        StringBuilder responseBuilder = new StringBuilder();
        try {
            // Try and get the nature by name
            Integer natureId = NatureQuery.getNatureIdFromQuery(message);
            String natureName = NatureQuery.getNatureNameFromNatureId(natureId);

            int[] natureModifiers = NatureQuery.getNatureModifiersFromNatureId(natureId);
            // Must modify the statIds as 0 != HP in natures
            natureModifiers[0]--;
            natureModifiers[1]--;

            responseBuilder.append(MessageFormats.nature(natureName, natureModifiers));
        } catch (NatureNameNotRecognisedException nnnre) {
            try {
                // Otherwise, attempt to get +stat and -stat from the query
                matcher = BOOST_PATTERN.matcher(message);
                String boostedStat;
                if (matcher.find()) {
                    boostedStat = matcher.group("stat");
                } else {
                    // Propogate exception if no match
                    throw new NatureNameNotRecognisedException(message);
                }
                matcher = HINDER_PATTERN.matcher(message);
                String hinderedStat;
                if (matcher.find()) {
                    hinderedStat = matcher.group("stat");
                } else {
                    // Propogate exception if no match
                    throw new NatureNameNotRecognisedException(message);
                }
                int[] modifiers = new int[2];

                modifiers[0] = getStatIdFromStatName(hinderedStat);
                modifiers[1] = getStatIdFromStatName(boostedStat);

                String natureName = NatureQuery.getNatureNameFromNatureModifiers(modifiers);

                // Again, must modify the modifiers, but by 2 as pokedb.sqlite has HP = 1
                modifiers[0] -= 2;
                modifiers[1] -= 2;
                responseBuilder.append(MessageFormats.nature(natureName, modifiers));
            } catch (NatureNameNotRecognisedException | NatureModifiersNotFoundException nnnre2) {
                // Couldn't identify the nature name / modifiers from query
                responseBuilder.append("Nature name or modifiers not recognised");
            }
        } catch (NotFoundException nfe) {
            // Something was broken, for example, nature name recognised, but no natureId in the database
            responseBuilder.append(MessageFormats.error);
        }
        response.add(responseBuilder.toString());
        return response;
    }

    /**
     * Converts the given {@code statName} to the relevant {@code statId}.
     *
     * @param statName The {@code StatName} to be converted.
     *
     * @return The {@code StatId} of the specified {@code Stat}.
     */
    private static int getStatIdFromStatName(String statName) {
        switch (statName) {
            case "att":
            case "attack":
                return 2;
            case "def":
            case "defense":
                return 3;
            case "spe":
            case "speed":
                return 6;
            case "spa":
            case "specialattack":
            case "special attack":
                return 4;
            case "spd":
            case "specialdefense":
            case "special defense":
                return 5;
            default:
                return -1;
        }
    }

}
