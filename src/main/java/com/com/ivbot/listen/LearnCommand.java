package com.com.ivbot.listen;

import com.com.ivbot.listen.util.MessageFormats;
import com.com.ivbot.sql.query.*;
import org.jooq.Record3;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles queries regarding whether a {@code Pokemon} learns the specified {@code Move} (and how).
 */
@IVBotCommand ("learn")
public final class LearnCommand extends NonRestrictedCommandListener {

    /**
     * Returns information about what the {@code IVsCommand} is for, and instructions for its usage.
     *
     * @param message The message to respond to (specifying which part to request help with).
     *
     * @return A {@code List} of the {@code String}s with which to respond to the request.
     */
    @Override
    public List<String> getHelp(String message) {

        String description = "Offers information on whether a Pokemon can learn a move, and if so how";
        String usage = "<pokemon [form]> <move>";

        return MessageFormats.helpFormat(COMMAND_NAME, description, usage);
    }

    /**
     * Informs whether the {@code Pokemon} specified can learn the {@code Move} specified, and if so how.
     *
     * @param message The message to respond to.
     *
     * @return Whether the {@code Pokemon} specified in {@code message} can learn the {@code Move} specified, and if so
     * how.
     */
    @Override
    public List<String> getResponse(String message) {
        List<String> response = new ArrayList<>();
        StringBuilder responseBuilder = new StringBuilder();

        searching:
        try {
            // Get information about the Pokemon
            Integer pokemonFormId = PokemonFormsQuery.getPokemonFormIdFromQuery(message);
            Integer pokemonId = PokemonFormsQuery.getPokemonIdFromPokemonFormId(pokemonFormId);
            Integer pokemonSpeciesId = PokemonSpeciesQuery.getPokemonSpeciesIdFromQuery(message);
            String pokemonSpeciesName = PokemonSpeciesQuery.getPokemonSpeciesNameFromPokemonSpeciesId(pokemonSpeciesId);

            // And the move
            Integer moveId = MoveQuery.getMoveIdFromQuery(message);
            String moveName = MoveQuery.getMoveNameFromMoveId(moveId);

            // This will store the result of how/where/level.
            // value1() = pokemon_move_method_id
            // value2() = version_group_id
            // value3() = level (which is 0 if not a level-up move)
            Record3<Integer, Integer, Integer> optimalRecord = null;

            // This is for testing if the eventual learning Pokemon was the queried one
            Integer learningSpeciesId = null;

            try {
                // Does the queried Pokemon learn the move?
                optimalRecord = PokemonMoveQuery.getOptimalRecord(pokemonId, moveId);
                learningSpeciesId = pokemonId;
            } catch (EntryNotFoundException enfe) {
                // If not, let's look at evolutions
                List<Integer> prevolutionSpeciesIds =
                        EvolutionQuery.getPrevolutionSpeciesIdsFromPokemonSpeciesIds(pokemonSpeciesId);

                for (Integer prevolutionSpeciesId : prevolutionSpeciesIds) {
                    try {
                        // Does the evolution learn the move?
                        optimalRecord = PokemonMoveQuery.getOptimalRecord(prevolutionSpeciesId, moveId);
                        learningSpeciesId = prevolutionSpeciesId;
                        break;
                    } catch (EntryNotFoundException esnfe) {
                        // Control passes forward due to nullity
                    }
                }

                if (learningSpeciesId == null) {
                    // If we finished iterating and never set the learningSpeciesId, then none of the prevolutions can
                    // learn the move.  Inform and break to return.

                    responseBuilder.append(MessageFormats.doesNotLearn(pokemonSpeciesName, moveName));
                    break searching;
                }
            }
            // How does it learn?
            String moveMethod =
                    PokemonMoveMethodQuery.getPokemonMoveMethodNameFromPokemonMoveMethodId(optimalRecord.value1());

            // In which versions does it learn?
            String versionGroupName = VersionGroupQuery.getVersionGroupNameFromVersionGroupId(optimalRecord.value2());

            int level = optimalRecord.value3();

            String learningSpeciesName = pokemonSpeciesName;
            if (!learningSpeciesId.equals(pokemonId)) {
                learningSpeciesName = PokemonSpeciesQuery.getPokemonSpeciesNameFromPokemonSpeciesId(learningSpeciesId);
            }

            responseBuilder.append(MessageFormats.learns(pokemonSpeciesName, moveName, learningSpeciesName, moveMethod,
                                                         versionGroupName, level));

            // Handle any exceptions thrown during searching
        } catch (PokemonSpeciesNotRecognisedException | PokemonFormNotRecognisedException pnre) {
            responseBuilder.append("Pokemon species not recognised");
        } catch (MoveNotRecognisedException mnre) {
            responseBuilder.append("Move not recognised");
        } catch (NotFoundException nfe) {
            responseBuilder.append(MessageFormats.error);
        }
        response.add(responseBuilder.toString());
        return response;
    }

}
