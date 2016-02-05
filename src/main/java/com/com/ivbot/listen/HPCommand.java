package com.com.ivbot.listen;

import com.com.ivbot.compute.ComputationUtilities;
import com.com.ivbot.compute.HiddenPowerComputation;
import com.com.ivbot.listen.util.MessageFormats;
import com.com.ivbot.sql.query.*;
import com.com.nfor.NFor;
import org.pircbotx.Colors;

import java.util.ArrayList;
import java.util.List;

/**
 * Deals with {@code HiddenPower} related queries.
 */
@IVBotCommand ("hp")
public final class HPCommand extends NonRestrictedCommandListener {

    /**
     * Informs the {@code User} the purpose of this command, and how to use it.
     *
     * @param message The message to respond to (specifying which part to request help with).
     *
     * @return Information about this {@code CommandListener} and instructions on how to use it.
     */
    @Override
    public List<String> getHelp(String message) {

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("Gives information about the Hidden Power of a Pokemon.")
                       .append(" If IVs are given, informs the Type and Power such a Pokemon would have;")
                       .append(" otherwise (if a type is given) gives all IV spreads which would result in said type");
        String description = responseBuilder.toString();
        String usage = "[<iv.iv...> | <type>]";

        return MessageFormats.helpFormat(COMMAND_NAME, description, usage);
    }

    /**
     * Returns either the {@code HiddenPower} {@code Type} and {@code Power} if a set of {@code IV}s are given, or all
     * possible {@code IV} combinations (assuming an {@code IV} of {@code 30} or {@code 31}) which would result in a
     * given {@code Type} if a {@code Type} is specified.
     *
     * @param message The message to respond to.
     *
     * @return {@code HiddenPower} related information.
     */
    @Override
    public List<String> getResponse(String message) {
        List<String> response = new ArrayList<>();
        StringBuilder responseBuilder = new StringBuilder();
        calculating:
        try {
            // Attempt to find a type name in the query
            Integer typeId = TypeQuery.getTypeIdFromQuery(message);
            String typeName = TypeQuery.getTypeNameFromTypeId(typeId);

            // If type name is one of Normal or Fairy, ignore as HiddenPower is not possible.
            if (typeId == Integer.valueOf(HiddenPowerComputation.NORMAL) ||
                typeId == Integer.valueOf(HiddenPowerComputation.FAIRY)) {

                responseBuilder.append("HP ").append(MessageFormats.formatted(typeName, Colors.BOLD))
                               .append(" is not possible");
            } else {
                responseBuilder.append("HP ").append(MessageFormats.formatted(typeName, Colors.BOLD)).append(": ");

                // Compute the possible IV spreads result in that Hidden Power.
                NFor<Integer> hpIvsNfor = HiddenPowerComputation.getHiddenPowerLoopNfor();
                List<int[]> ivSpreadsForHP = new ArrayList<int[]>();
                for (Integer[] ivsBoxed : hpIvsNfor) {
                    int[] ivs = ComputationUtilities.convertToPrimitive(ivsBoxed);
                    Integer typeForIvs = HiddenPowerComputation.getTypeIdOfHiddenPowerFromIvs(ivs);
                    if (typeForIvs == typeId) {
                        ivSpreadsForHP.add(ivs);
                    }
                }

                for (int spread = 0; spread < ivSpreadsForHP.size(); spread++) {
                    int[] ivs = ivSpreadsForHP.get(spread);
                    if (spread != 0) {
                        responseBuilder.append(MessageFormats.divider);
                    }
                    responseBuilder.append(MessageFormats.perStat(ivs));
                }
            }
        } catch (TypeNotRecognisedException | TypeIdNotFoundException te) {
            // If no type name, attempt to find IVs in the message
            try {
                int[] ivs = new int[6];
                boolean oddEvenSpecified = false;
                try {
                    // First check for explicit IVs
                    ivs = IVsQuery.getIVsFromQuery(message);
                } catch (IVsNotRecognisedException ie) {
                    try {
                        // If no explicit IVs, check with "o" and "e" allowed
                        ivs = HiddenPowerIVsQuery.getHPIVsFromQuery(message);
                        oddEvenSpecified = true;
                    } catch (IVsNotRecognisedException ive) {
                        responseBuilder.append("IVs or Type not recognised");
                        break calculating;
                    }
                }

                // Compute the type of the Hidden Power with the specified IVs
                int typeId = HiddenPowerComputation.getTypeIdOfHiddenPowerFromIvs(ivs);
                String typeName = TypeQuery.getTypeNameFromTypeId(typeId);
                responseBuilder.append("HP ").append(MessageFormats.formatted(typeName, Colors.BOLD));

                // Only add power information if "o" and "e' were not used
                if (!oddEvenSpecified) {
                    int power = HiddenPowerComputation.getPreGenVIPowerOfHiddenPowerFromIvs(ivs);
                    int g6power = HiddenPowerComputation.getGenVIPowerOfHiddenPowerFromIvs(ivs);

                    responseBuilder.append(MessageFormats.divider).append("Power: ")
                                   .append(MessageFormats.formatted(String.format("%d", g6power), Colors.BOLD))
                                   .append(MessageFormats.divider).append("Pre Gen-6 Power: ")
                                   .append(MessageFormats.formatted(String.format("%d", power), Colors.BOLD));
                }
            } catch (TypeIdNotFoundException e) {
                // Inform of error
                responseBuilder.append(MessageFormats.error);
            }
        }

        response.add(responseBuilder.toString());
        return response;
    }

}
