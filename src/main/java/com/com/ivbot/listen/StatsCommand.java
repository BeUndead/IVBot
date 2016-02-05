package com.com.ivbot.listen;

import com.com.ivbot.compute.StatsComputation;
import com.com.ivbot.listen.util.MessageFormats;
import com.com.ivbot.sql.query.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Lists the {@code BaseStats} of a {@code Pokemon} if no {@code Nature} is given, otherwise computes the {@code Stat}s
 * of the {@code Pokemon} with the given variables.
 */
@IVBotCommand ("stats")
public final class StatsCommand extends NonRestrictedCommandListener {

    /**
     * Gives the help information for this {@code Command}.
     *
     * @param message The message to respond to (specifying which part to request help with).
     *
     * @return A {@code List} of the responses (to be returned to the {@code User} in the order they're given).
     */
    @Override
    public List<String> getHelp(String message) {

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("Lists the basic information of the requested Pokemon (form).")
                       .append(" If a nature is specified, then computes the stats with the given parameters.");
        String description = responseBuilder.toString();
        String usage = "<pokemon [form]> [<nature> [\"Lv. \"<level>] [iv.iv...] [ev.ev...]]";

        return MessageFormats.helpFormat(COMMAND_NAME, description, usage);
    }

    /**
     * Lists the {@code BaseStats} of the {@code PokemonForm} given if no required information for computation of exact
     * stats are provided.
     * <p>
     * If a {@code Nature} is provided, then it will compute the {@code Stat}s of the {@code PokemonForm} with the given
     * setting.  The defaults are (if not specified): <li>{@code IVs}: {@literal 31/31/31/31/31/31};</li> <li>{@code
     * EVs}: {@literal 0/0/0/0/0/0};</li> <li>{@code Level}: {@literal 100};</li> however these can be specified by the
     * {@code User} in the given {@code message}.
     *
     * @param message The message to respond to.
     *
     * @return The {@code BaseStats} of the {@code PokemonForm}, or (if enough information is provided) the computed
     * {@code Stat}s of the {@code PokemonForm}.
     */
    @Override
    public List<String> getResponse(String message) {

        List<String> response = new ArrayList<>();
        try {
            // Try to find the Pokemon Species (+ form) from the message
            Integer pokemonSpeciesId = PokemonSpeciesQuery.getPokemonSpeciesIdFromQuery(message);
            Integer pokemonFormId = PokemonFormsQuery.getPokemonFormIdFromQuery(message);
            Integer pokemonId = PokemonFormsQuery.getPokemonIdFromPokemonFormId(pokemonFormId);

            String pokemonFormName = PokemonFormsQuery.getPokemonNameFromPokemonFormId(pokemonFormId);

            // Get Base Stats of said Pokemon form
            int[] baseStats = BaseStatsQuery.getBaseStatsFromPokemonId(pokemonId);

            StringBuilder responseBuilder = new StringBuilder();
            responseBuilder.append(MessageFormats.pokemonWithId(pokemonSpeciesId, pokemonFormName));

            try {
                // Attempt to find Nature in query
                Integer natureId = NatureQuery.getNatureIdFromQuery(message);
                String natureName = NatureQuery.getNatureNameFromNatureId(natureId);

                // And other data (set to default values if it's not present)
                int level = LevelQuery.STANDARD;
                try {
                    level = LevelQuery.getLevelFromQuery(message);
                } catch (LevelNotRecognisedException le) {
                }

                // Remove the IVs from the message (and store as updatedMessage) so they aren't accidentally
                // interpreted as EVs
                String updatedMessage = message;
                int[] ivs = IVsQuery.STANDARD;
                try {
                    ivs = IVsQuery.getIVsFromQuery(message);
                    String ivsSubstring = IVsQuery.getMatchingSubstringFromQuery(message);
                    updatedMessage = updatedMessage.replace(ivsSubstring, "");
                } catch (IVsNotRecognisedException ie) {
                }

                int[] evs = EVsQuery.STANDARD;
                try {
                    evs = EVsQuery.getEVsFromQuery(updatedMessage);
                } catch (EVsNotRecognisedException ee) {
                }

                // Compute the base stats of the Pokemon with the given values
                int[] computedStats =
                        StatsComputation.getStatsFromVariables(baseStats, natureId.intValue(), level, ivs, evs);

                // And report this back to the user
                responseBuilder.append(MessageFormats.divider).append(natureName);

                responseBuilder.append(MessageFormats.divider).append(MessageFormats.level(level));

                responseBuilder.append(MessageFormats.divider);
                responseBuilder.append(MessageFormats.perStat(computedStats));

                response.add(responseBuilder.toString());
            } catch (NatureNameNotRecognisedException | NatureIdNotFoundException ne) {
                // If no nature specified, default to listing the base stats + basic information
                Integer[] typeIds = PokemonTypeQuery.getTypeIdsFromPokemonId(pokemonId);
                String[] typeNames = TypeQuery.getTypeNamesFromTypeIds(typeIds);
                Integer[] abilityIds = PokemonAbilitiesQuery.getPokemonAbilityIdsFromPokemonId(pokemonId);
                String[] abilityNames = AbilitiesQuery.getAbilityNamesFromAbilityIds(abilityIds);

                // Inform the user of said basic information
                responseBuilder.append(MessageFormats.divider).append(MessageFormats.types(typeNames));

                responseBuilder.append(MessageFormats.divider).append(MessageFormats.abilities(abilityNames));

                responseBuilder.append(MessageFormats.divider).append(MessageFormats.perStat(baseStats));

                response.add(responseBuilder.toString());
            }

        } catch (NotRecognisedException nre) {
            // In some form, the Pokemon Species was not recognised
            response.add("Pokemon Species not recognised");
        } catch (NotFoundException nfe) {
            // This implies a database error, which should alert .com to fix
            response.add(MessageFormats.error);
        }

        return response;
    }

}
