package com.com.ivbot.listen;

import com.com.ivbot.compute.ComputationAbortedException;
import com.com.ivbot.compute.IVsComputation;
import com.com.ivbot.listen.util.MessageFormats;
import com.com.ivbot.sql.query.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles queries regarding the computation of {@code IV}s.
 */
@IVBotCommand ("ivs")
public final class IVsCommand extends NonRestrictedCommandListener {

    /**
     * Returns information about what the {@code IVsCommand} is for, and instructions for its usage.
     *
     * @param message The message to respond to (specifying which part to request help with).
     *
     * @return A {@code List} of the {@code String}s with which to respond to the request.
     */
    @Override
    protected List<String> getHelp(String message) {

        String description = "Computes possible IV ranges for Pokemon with the given specifications.";
        String usage = "<pokemon [form]> <stats> <nature> <\"Lv.\" level> [ev.ev...] [\"hp\" type]";

        return MessageFormats.helpFormat(COMMAND_NAME, description, usage);
    }

    /**
     * Computes the {@code IV}s of the {@code Pokemon} with the given specifications.  If no nature is given then it
     * will return an error response.
     *
     * @param message The message to respond to.
     *
     * @return Information regarding the {@code Pokemon}'s {@code IV}s (if they can be computed from the given {@code
     * Stat}s, otherwise an informative error message as to why no {@code IV}s can be computed.
     */
    @Override
    protected List<String> getResponse(String message) {
        List<String> response = new ArrayList<>();
        StringBuilder responseBuilder = new StringBuilder();

        try {
            // Get details of the Pokemon species (required)
            Integer pokemonFormId = PokemonFormsQuery.getPokemonFormIdFromQuery(message);
            String pokemonName = PokemonFormsQuery.getPokemonNameFromPokemonFormId(pokemonFormId);
            Integer pokemonId = PokemonFormsQuery.getPokemonIdFromPokemonFormId(pokemonFormId);
            Integer pokemonSpeciesId = PokemonSpeciesQuery.getPokemonSpeciesIdFromQuery(message);

            // Get information about the nature (required)
            Integer natureId = NatureQuery.getNatureIdFromQuery(message);
            String natureName = NatureQuery.getNatureNameFromNatureId(natureId);

            // Get information on the level (required)
            int level = LevelQuery.getLevelFromQuery(message);

            // Get the given stats (required)
            int[] givenStats = StatsQuery.getStatsFromQuery(message);
            String statsPartOfString = StatsQuery.getMatchingSubstringFromQuery(message);
            String updatedMessage = message;
            updatedMessage = updatedMessage.replace(statsPartOfString, "");

            // Get the EVs (not required)
            int[] evs = EVsQuery.STANDARD;
            try {
                evs = EVsQuery.getEVsFromQuery(updatedMessage);
            } catch (EVsNotRecognisedException enre) { // Defaults to all 0.
            }

            // Get the Base Stats
            int[] baseStats = BaseStatsQuery.getBaseStatsFromPokemonId(pokemonId);

            try {
                // If a type is given, assume hidden power is desired
                Integer hpTypeId = TypeQuery.getTypeIdFromQuery(updatedMessage);

                try {
                    // Get the possible IVs (including Hidden Power type)
                    List<Integer>[] possibleIvs = IVsComputation
                            .getPossibleIVsFromVariablesWithHiddenPowerType(givenStats, baseStats, natureId.intValue(),
                                                                            level, evs, hpTypeId.intValue());

                    // Add the details to the response
                    responseBuilder.append(MessageFormats.pokemonWithId(pokemonSpeciesId, pokemonName));

                    responseBuilder.append(MessageFormats.divider).append(natureName).append(MessageFormats.divider)
                                   .append(MessageFormats.level(level));

                    responseBuilder.append(MessageFormats.divider);

                    responseBuilder.append(MessageFormats.possibleIVsWithColors(possibleIvs));

                } catch (ComputationAbortedException cae) {
                    // Too many iterations required for the IVs computation (with Hidden Power only)
                    responseBuilder.append("There were too many possible IVs, please level up your Pokemon");
                }
            } catch (TypeNotRecognisedException tnre) {
                try {
                    // If Hidden Power implied to be given, but not recognised, propoagate again.
                    if (message.matches("\\bhp\\s+[A-Za-z]+")) {
                        throw new TypeNotRecognisedException(message);
                    }

                    // Get the IV ranges from the given details
                    int[][] ivRanges =
                            IVsComputation.getIVRangesFromVariables(givenStats, baseStats, natureId, level, evs);

                    // Add these details to the response
                    responseBuilder.append(MessageFormats.pokemonWithId(pokemonSpeciesId, pokemonName));

                    responseBuilder.append(MessageFormats.divider).append(natureName);

                    responseBuilder.append(MessageFormats.divider).append(MessageFormats.level(level));

                    responseBuilder.append(MessageFormats.divider)
                                   .append(MessageFormats.ivsFromRangeswithColors(ivRanges));

                } catch (TypeNotRecognisedException typenre) {
                    // Inform that the type wasn't recognised
                    responseBuilder.append("Hidden Power Type not recognised");
                }
            }
            // Inform of any other errors (from initial data collection) here
        } catch (PokemonFormNotRecognisedException | PokemonSpeciesNotRecognisedException pnre) {
            responseBuilder.append("No Pokemon Species recognised");
        } catch (NatureNameNotRecognisedException nnnre) {
            responseBuilder.append("No Nature recognised");
        } catch (LevelNotRecognisedException lnre) {
            responseBuilder.append("Level not recognised");
        } catch (StatsNotRecognisedException snre) {
            responseBuilder.append("Stats not recognised");
        } catch (NotFoundException nfe) {
            // Implies that something which SHOULD be in the database wasn't, and should be reviewed.
            responseBuilder.append(MessageFormats.error);
        }

        response.add(responseBuilder.toString());
        return response;
    }
}
