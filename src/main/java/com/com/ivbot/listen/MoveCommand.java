package com.com.ivbot.listen;

import com.com.ivbot.listen.util.MessageFormats;
import com.com.ivbot.sql.query.*;
import com.com.ivbot.sql.schema.tables.records.MovesRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles {@code Move} related queries.
 */
@IVBotCommand ("move")
public final class MoveCommand extends NonRestrictedCommandListener {

    /**
     * Returns a helpful help response for this {@code Command}.
     *
     * @param message The message to respond to (specifying which part to request help with).
     *
     * @return A helpful help response for this {@code Command}.
     */
    @Override
    protected List<String> getHelp(String message) {

        String description = "Retrieves information based on the requested move";
        String usage = "<move name>";
        return MessageFormats.helpFormat(COMMAND_NAME, description, usage);
    }

    /**
     * Displays basic information about the {@code Move} specified in the given {@code message}.
     *
     * @param message The message to respond to.
     *
     * @return Basic information about the {@code Move} specified in the given {@code message}.
     */
    @Override
    protected List<String> getResponse(String message) {
        List<String> response = new ArrayList<>();
        StringBuilder responseBuilder = new StringBuilder();

        try {
            // Get the move's information
            Integer moveId = MoveQuery.getMoveIdFromQuery(message);
            String moveName = MoveQuery.getMoveNameFromMoveId(moveId);

            MovesRecord movesRecord = MoveMetaQuery.getMoveMetaRecordFromMoveId(moveId);

            String flavorText = MoveProseQuery.getMoveProseFromMoveId(moveId);

            // Add basic information to first message
            responseBuilder.append(MessageFormats.moveMeta(moveName, movesRecord));
            response.add(responseBuilder.toString());

            // And flavor text to the second
            responseBuilder.setLength(0);

            responseBuilder.append(MessageFormats.moveFlavorText(flavorText));

            // Inform of any errors.
        } catch (MoveNotRecognisedException mnre) {
            responseBuilder.append("Move not recognised");
        } catch (NotFoundException nfe) {
            // Need to clear the resopnse, on the off-chance that the moveId was not found in the MoveMetaQuery.
            response.clear();
            responseBuilder.append(MessageFormats.error);
        }

        // Add to response and return
        response.add(responseBuilder.toString());
        return response;
    }
}
