package com.com.ivbot.listen;

import com.com.ivbot.compute.TypeEfficacyComputation;
import com.com.ivbot.listen.util.MessageFormats;
import com.com.ivbot.sql.query.NotFoundException;
import com.com.ivbot.sql.query.TypeNotRecognisedException;
import com.com.ivbot.sql.query.TypeQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Gives details of the specified {@code Type}.
 */
@IVBotCommand ("type")
public final class TypeCommand extends CommandListener {

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<String> getHelp(String message) {
        String description = "Gives information about the given type, including weaknesses and resistances. " +
                             "If a combination is given, these details are given for the combination.";
        String usage = "<type name #1> [type name #2]";
        return MessageFormats.helpFormat(COMMAND_NAME, description, usage);
    }

    /**
     * Lists the weaknesses and resistances of the given {@code Type(s)}.
     *
     * @param message The message to respond to.
     *
     * @return An informative description of the weaknesses and resistances of the given {@code Type(s)}.
     */
    @Override
    protected List<String> getResponse(String message) {
        StringBuilder responseBuilder = new StringBuilder();
        List<String> response = new ArrayList<>();
        try {
            // Replace selectors with spaces in the message.
            String updatedMessage = message.replaceAll("\\+\\-\\/", " ");
            // Get the first typeId
            Integer typeId1 = TypeQuery.getTypeIdFromQuery(updatedMessage);
            String typeName1 = TypeQuery.getTypeNameFromTypeId(typeId1);

            // Try and get the second TypeId
            Optional<Integer> typeId2 = Optional.<Integer>empty();
            Optional<String> typeName2 = Optional.<String>empty();
            try {
                updatedMessage = updatedMessage.replace(typeName1.toLowerCase(), "");
                typeId2 = Optional.of(TypeQuery.getTypeIdFromQuery(updatedMessage));
                typeName2 = Optional.of(TypeQuery.getTypeNameFromTypeId(typeId2.get()));
            } catch (TypeNotRecognisedException tnre) {
                // Do nothing, just won't have added to the types
            }

            // Get their efficacies.
            List<Map.Entry<Integer, Integer>> efficacies =
                    TypeEfficacyComputation.getDamageEfficaciesFromTypes(typeId1, typeId2);

            // Something in the database not as expected
            if (efficacies.size() != 18) {
                throw new NotFoundException();
            }

            // Inform of the results
            response.add(MessageFormats.efficacies(efficacies));
        } catch (TypeNotRecognisedException tnre) {
            responseBuilder.append("Type(s) not recognised");
        } catch (NotFoundException nfe) {
            responseBuilder.append(MessageFormats.error);
        }
        response.add(responseBuilder.toString());
        return response;
    }
}
