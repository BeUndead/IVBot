package com.com.ivbot.listen;

import com.com.ivbot.listen.util.MessageFormats;
import com.com.ivbot.sql.query.ItemNotRecognisedException;
import com.com.ivbot.sql.query.ItemProseQuery;
import com.com.ivbot.sql.query.ItemQuery;
import com.com.ivbot.sql.query.NotFoundException;
import org.pircbotx.Colors;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles {@code Item} related queries.
 */
@IVBotCommand ("item")
public final class ItemCommand extends NonRestrictedCommandListener {

    /**
     * Gives a helpful help response.
     *
     * @param message The message to respond to (specifying which part to request help with).
     *
     * @return A helpful help response.
     */
    @Override
    protected List<String> getHelp(String message) {
        String description = "Gives details about items";
        String usage = "<item name>";
        return MessageFormats.helpFormat(COMMAND_NAME, description, usage);
    }

    /**
     * Lists information about the requested {@code Item}.
     *
     * @param message The message to respond to.
     *
     * @return Information about the requested {@code Item}.
     */
    @Override
    protected List<String> getResponse(String message) {
        List<String> response = new ArrayList<>();
        StringBuilder responseBuilder = new StringBuilder();
        try {
            Integer itemId = ItemQuery.getItemIdFromQuery(message);
            String itemName = ItemQuery.getItemNameFromItemId(itemId);

            String itemCategoryName = ItemProseQuery.getItemCategoryNameFromItemId(itemId);
            String itemShortEffect = ItemProseQuery.getItemDescriptionFromItemId(itemId);

            responseBuilder.append(MessageFormats.formatted(itemName, Colors.BOLD)).append(MessageFormats.divider)
                           .append(itemCategoryName);

            response.add(responseBuilder.toString());

            responseBuilder.setLength(0);

            responseBuilder.append(itemShortEffect);
        } catch (ItemNotRecognisedException inre) {
            responseBuilder.append("Item not recognised");
        } catch (NotFoundException nfe) {
            responseBuilder.append(MessageFormats.error);
        }
        response.add(responseBuilder.toString());
        return response;
    }
}
