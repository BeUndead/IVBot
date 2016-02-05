package com.com.ivbot.listen;

import com.com.ivbot.listen.util.MessageFormats;
import com.com.ivbot.sql.query.AbilitiesQuery;
import com.com.ivbot.sql.query.AbilityNotRecognisedException;
import com.com.ivbot.sql.query.AbilityProseQuery;
import com.com.ivbot.sql.query.NotFoundException;
import org.pircbotx.Colors;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles {@code Ability} related queries.
 */
@IVBotCommand ("ability")
public final class AbilityCommand extends NonRestrictedCommandListener {

    /**
     * Returns a useful help message.
     *
     * @param message The message to respond to (specifying which part to request help with).
     *
     * @return A helpful help message.
     */
    @Override
    protected List<String> getHelp(String message) {

        String description = "Gives a description of the given ability";
        String usage = "<ability name>";

        return MessageFormats.helpFormat(COMMAND_NAME, description, usage);
    }

    /**
     * Retrieves a description of the queried {@code Ability}.
     *
     * @param message The message to respond to.
     *
     * @return A description of the queried {@code Ability}.
     */
    @Override
    protected List<String> getResponse(String message) {
        List<String> response = new ArrayList<>();
        StringBuilder responseBuilder = new StringBuilder();
        try {
            Integer abilityId = AbilitiesQuery.getAbilityIdFromQuery(message);
            String abilityName = AbilitiesQuery.getAbilityNameFromAbilityId(abilityId);

            String abilityDescription = AbilityProseQuery.getAbilityDescriptionFromAbilityId(abilityId);

            responseBuilder.append(MessageFormats.formatted(abilityName, Colors.BOLD)).append(MessageFormats.divider)
                           .append(abilityDescription);
        } catch (AbilityNotRecognisedException anre) {
            responseBuilder.append("Ability not recognised");
        } catch (NotFoundException nfe) {
            responseBuilder.append(MessageFormats.error);
        }

        response.add(responseBuilder.toString());
        return response;
    }
}
