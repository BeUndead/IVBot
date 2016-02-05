package com.com.ivbot.listen.util;

import com.com.ivbot.sql.query.DamageClassIdNotFoundException;
import com.com.ivbot.sql.query.DamageClassQuery;
import com.com.ivbot.sql.query.TypeIdNotFoundException;
import com.com.ivbot.sql.query.TypeQuery;
import com.com.ivbot.sql.schema.tables.records.MovesRecord;
import org.pircbotx.Colors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Stores the base formats for {@code String}s to be outputted to the user.
 */
public class MessageFormats {

    /**
     * Standardised divider for separate clauses in a response.
     */
    public static final String divider = " | ";

    /**
     * Standardised error (implies something is wrong with the database).
     */
    public static final String error = "oCom: I done broked :(";
    /**
     * These are used to extract the appropriate value from the given {@code ivRanges}.
     */
    private static final int MIN = 0;
    private static final int MAX = 1;
    private static final String[] STAT_NAMES = {"Att", "Def", "SpA", "SpD", "Spe"};

    /**
     * Standardises the {@code help} response for {@code Commands}.
     *
     * @param name        The {@code COMMAND_NAME} for that command.
     * @param description The description of what the {@code Command} does.
     * @param usage       The syntax for the {@code Command}.
     *
     * @return A standardised {@code help} response for the {@code Command} instance.
     */
    public static List<String> helpFormat(String name, String description, String usage) {
        List<String> help = new ArrayList<>(2);
        help.add(description);
        StringBuilder helpBuilder = new StringBuilder();
        helpBuilder.append(String.format("Usage: \"?%s", name));
        if (!usage.equals("")) {
            helpBuilder.append(String.format(" %s", usage));
        }
        helpBuilder.append('\"');

        help.add(helpBuilder.toString());
        return help;
    }

    /**
     * Returns a standardised format for the {@code PokemonSpeciesId} and {@code PokemonFormName}.
     *
     * @param id          The {@code PokemonSpeciesId} of the {@code Pokemon} to format.
     * @param pokemonName The {@code PokemonSpeciesName} of the {@code Pokemon} to format.
     *
     * @return A standardised format for the {@code PokemonSpeciesId} and {@code PokemonFormName}.
     */
    public static String pokemonWithId(Integer id, String pokemonName) {

        StringBuilder pokemonBuilder = new StringBuilder();
        pokemonBuilder.append(MessageFormats.formatted(String.format("#%03d", id), Colors.BOLD)).append(" ")
                      .append(MessageFormats.formatted(pokemonName, Colors.BOLD));

        return pokemonBuilder.toString();
    }

    /**
     * Returns a {@code String} with the given {@code String} wrapped in {@code Color...} tags specified by the given
     * {@code format} argument.
     *
     * @param string The {@code String} to wrap in {@code Color} tags.
     * @param format The {@code Colors...} tag to wrap {@code string} in.
     *
     * @return {@code string} with {@code Color} {@code color} tags appended.
     */
    public static String formatted(String string, String format) {

        return String.format("%2$s%1$s%3$s", string, format, Colors.NORMAL);
    }

    /**
     * Generates a {@code String} of a standard format for the given {@code AbilityNames}.
     *
     * @param abilityNames The {@code AbilityName}s to format.
     *
     * @return A {@code String} representing the given {@code abilityNames} in a standard format.
     */
    public static String abilities(String[] abilityNames) {

        StringBuilder abilitiesBuilder = new StringBuilder();
        abilitiesBuilder.append(String.format("[0] %s", abilityNames[0]));
        if (!abilityNames[1].equals("")) {
            abilitiesBuilder.append(String.format(" [1] %s", abilityNames[1]));
        }
        if (!abilityNames[2].equals("")) {
            abilitiesBuilder.append(String.format(" [HA] %s", abilityNames[2]));
        }
        return abilitiesBuilder.toString();
    }

    /**
     * Generates a {@code String} in a standard format for the {@code TypeName}s given.
     *
     * @param typeNames The {@code TypeName}s which should be formatted.
     *
     * @return A {@code String} representation of the {@code TypeName}s in a standard format.
     */
    public static String types(String[] typeNames) {

        StringBuilder typesBuilder = new StringBuilder();
        typesBuilder.append(typeNames[0]);
        if (!typeNames[1].isEmpty()) {
            typesBuilder.append(String.format("/%s", typeNames[1]));
        }
        return typesBuilder.toString();
    }

    /**
     * Generates a {@code String} in a standard format to denote the given {@code Level}.
     *
     * @param level The {@code Level} to generate a {@code String} for.
     *
     * @return A {@code String} representation of the {@code level} in a standard format.
     */
    public static String level(int level) {

        return String.format("Lv. %d", level);
    }

    /**
     * Generates a {@code String} representation of the given {@code Array} in a per-{@code Stat} basis.  This is used
     * for {@code IV}s, {@code EV}s, {@code Stat}s and {@code BaseStat}s.
     *
     * @param values The {@code Array} to represent as a {@code String}
     *
     * @return A standardised format of the given {@code Array} as a {@code String}.
     */
    public static String perStat(int[] values) {

        StringBuilder perStatBuilder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (i != 0) {
                perStatBuilder.append(".");
            }
            perStatBuilder.append(values[i]);
        }
        return perStatBuilder.toString();
    }

    /**
     * Generates a standardised {@code String} of the {@code IV}s.
     *
     * @param possibleIvs The {@code IV}s to format.
     *
     * @return A standardised {@code String} of the {@code IV}s.
     */
    public static String possibleIVsWithColors(List<Integer>[] possibleIvs) {

        StringBuilder ivsBuilder = new StringBuilder();
        for (int statId = 0; statId < possibleIvs.length; statId++) {
            if (statId != 0) {
                ivsBuilder.append(" . ");
            }
            List<Integer> possibleIvsForThisStat = possibleIvs[statId];
            if (possibleIvsForThisStat.size() == 0) {
                ivsBuilder.append(MessageFormats.formatted("X", Colors.LIGHT_GRAY));
            } else {
                for (int ivCounter = 0; ivCounter < possibleIvsForThisStat.size(); ivCounter++) {
                    if (ivCounter != 0) {
                        ivsBuilder.append(",");
                    }
                    int iv = possibleIvsForThisStat.get(ivCounter);
                    ivsBuilder.append(colorIndividualIv(iv));
                }
            }
        }
        return ivsBuilder.toString();
    }

    /**
     * Colors an individual {@code IV} ({@code RED} if low, {@code DARK_GREEN} if high, {@code BOLD} if [up to {@code
     * HiddenPower}] perfect).
     *
     * @param iv The {@code IV} to be formatted.
     *
     * @return A {@code String} of the given {@code IV} colored to reprsent its value.
     */
    private static String colorIndividualIv(int iv) {
        StringBuilder ivBuilder = new StringBuilder();
        if (iv <= 1 || iv >= 30) {
            ivBuilder.append(Colors.BOLD);
        }
        if (iv <= 2) {
            ivBuilder.append(Colors.RED);
        } else if (iv >= 29) {
            ivBuilder.append(Colors.DARK_GREEN);
        }
        ivBuilder.append(iv);
        if (iv <= 2 || iv >= 29) {
            ivBuilder.append(Colors.NORMAL);
        }
        return ivBuilder.toString();
    }

    /**
     * Returns a nicely formatted {@code String} representing the given {@code ivRanges}.
     *
     * @param ivRanges The {@code ivRanges} to be formatted.
     *
     * @return A {@code String} representing the given {@code ivRanges} formatted appropriately.
     */
    public static String ivsFromRangeswithColors(int[][] ivRanges) {

        StringBuilder ivsBuilder = new StringBuilder();
        for (int statId = 0; statId < ivRanges.length; statId++) {
            if (statId != 0) {
                ivsBuilder.append(" . ");
            }
            if (ivRanges[statId].length == 0) { // Invalid stat was supplied
                ivsBuilder.append(colorInvalidIv());
                continue;
            }
            int minIv = ivRanges[statId][MIN];
            int maxIv = ivRanges[statId][MAX];
            ivsBuilder.append(colorIndividualIv(minIv));
            if (minIv != maxIv) {
                ivsBuilder.append("-").append(colorIndividualIv(maxIv));
            }
        }
        return ivsBuilder.toString();
    }

    private static String colorInvalidIv() {
        return MessageFormats.formatted("X", Colors.LIGHT_GRAY);
    }

    /**
     * Gives a {@code String} formatted to indicate that the given {@code Pokemon} <i>can</i> learn the given {@code
     * Move}, and in the circumstances as described.
     *
     * @param pokemonName  The {@code PokemonName} to print.
     * @param moveName     The {@code MoveName} that it <i>can</i> learn.
     * @param learnsAsName The {@code PokemonName} of the {@code Pokemon} who learns the {@code Move}.  This is present
     *                     to allow indication that the {@code pokemonName} learns {@code moveName} in a prevolution.
     * @param moveMethod   The {@code PokemonMoveMethod} by which {@code pokemonName} learns {@code moveName}.
     * @param versionGroup The {@code VersionGroup} in which {@code pokemonName} learns {@code moveName} by the
     *                     specified {@code PokemonMoveMethod}.
     * @param level        The {@code Level} at which {@code pokemonName} learns {@code moveName} (in the specified
     *                     circumstances).  A value of {@code 0} indicates that it is <i>not</i> level based.
     *
     * @return A formatted {@code String} informing of the given information.
     */
    public static String learns(String pokemonName, String moveName, String learnsAsName, String moveMethod,
                                String versionGroup, int level) {

        StringBuilder learnsBuilder = new StringBuilder();
        learnsBuilder.append(MessageFormats.formatted(pokemonName, Colors.BOLD)).append(" ")
                     .append(MessageFormats.formatted("can", Colors.DARK_GREEN)).append(String.format(" learn "))
                     .append(MessageFormats.formatted(moveName, Colors.BOLD))
                     .append(String.format(" by %s in %s", moveMethod, versionGroup));
        if (level != 0) {
            learnsBuilder.append(String.format(" (at Lv. %d)", level));
        }
        if (!learnsAsName.equals(pokemonName)) {
            learnsBuilder.append(" as ").append(MessageFormats.formatted(learnsAsName, Colors.BOLD));
        }

        return learnsBuilder.toString();
    }

    /**
     * Generates a {@code String} which informs that {@code pokemonName} can<i>not</i> learn {@code moveName}.
     *
     * @param pokemonName The {@code PokemonName} of the learning {@code Pokemon}.
     * @param moveName    The {@code MoveName} of the unlearnable {@code Move}.
     *
     * @return A {@code String} informing that {@code pokemonName} cannot learn {@code moveName}.
     */
    public static String doesNotLearn(String pokemonName, String moveName) {

        StringBuilder noLearnBuilder = new StringBuilder();
        noLearnBuilder.append(MessageFormats.formatted(pokemonName, Colors.BOLD)).append(" ")
                      .append(MessageFormats.formatted("cannot", Colors.RED)).append(" learn ")
                      .append(MessageFormats.formatted(moveName, Colors.BOLD));

        return noLearnBuilder.toString();
    }

    /**
     * Generates a {@code String} for the {@code Move} and {@code FlavorText}.
     *
     * @param moveFlavorText The {@code FlavorText} of the {@code Move}.
     *
     * @return A formatted {@code String} for the {@code Move} and {@code FlavorText}.
     */
    public static String moveFlavorText(String moveFlavorText) {

        return moveFlavorText;
    }

    /**
     * Generates a formatted {@code String} for the given {@code MoveMetaRecord}.
     *
     * @param movesRecord The {@code MoveMetaRecord} of which to generate a {@code String}.
     *
     * @return A formatted {@code String} for the given {@code MoveMetaRecord}.
     */
    public static String moveMeta(String moveName, MovesRecord movesRecord) {

        StringBuilder moveMetaBuilder = new StringBuilder();
        Integer typeId = movesRecord.getTypeId();
        String typeName = "Unknown Type";
        try {
            typeName = TypeQuery.getTypeNameFromTypeId(typeId);
        } catch (TypeIdNotFoundException tinfe) {
        }

        Integer damageClassId = movesRecord.getDamageClassId();
        String damageClassName = "-";
        try {
            damageClassName = DamageClassQuery.getDamageClassNameFromDamageClassId(damageClassId);
        } catch (DamageClassIdNotFoundException dcinfe) {
        }

        Integer powerInt = Integer.valueOf(0);
        try {
            powerInt = movesRecord.getPower().intValue();
        } catch (NullPointerException npe) {
        }
        String power = (powerInt == null || powerInt == 0) ? "-" : powerInt.toString();
        Integer pp = movesRecord.getPp().intValue();

        Integer accuracyInt = Integer.valueOf(0);
        try {
            accuracyInt = movesRecord.getAccuracy().intValue();
        } catch (NullPointerException npe) {
        }
        String accuracy = accuracyInt == 0 ? "-" : String.format("%d%%", accuracyInt);

        moveMetaBuilder.append(MessageFormats.formatted(moveName, Colors.BOLD)).append(MessageFormats.divider)
                       .append(typeName).append(MessageFormats.divider).append(damageClassName)
                       .append(MessageFormats.divider).append(String.format("BP: %s", power))
                       .append(MessageFormats.divider).append(String.format("Acc: %s", accuracy))
                       .append(MessageFormats.divider).append(String.format("PP: %d", pp));

        return moveMetaBuilder.toString();
    }

    /**
     * Generates a {@link String} representation of the {@code Nature} specified by the given {@code natureName} and the
     * specified {@code modifiers}.
     *
     * @param natureName The <strong>name</strong> of the {@code Nature}.
     * @param modifiers  The {@code Stat} boost and hindrance of the specified {@code Nature}.
     *
     * @return A {@link String} representing the requested {@code Nature}.
     */
    public static String nature(String natureName, int[] modifiers) {
        StringBuilder responseBuilder = new StringBuilder().append(MessageFormats.formatted(natureName, Colors.BOLD))
                                                           .append(MessageFormats.divider);

        if (modifiers[0] == modifiers[1]) {
            responseBuilder.append(MessageFormats.formatted("No changes", Colors.LIGHT_GRAY));
        } else {
            responseBuilder.append(MessageFormats.formatted("+" + STAT_NAMES[modifiers[1]], Colors.DARK_GREEN))
                           .append(MessageFormats.formatted(" -" + STAT_NAMES[modifiers[0]], Colors.RED));
        }

        return responseBuilder.toString();
    }

    /**
     * Converts the given {@link List} of {@code efficacies} to a {@link String} giving an indication of the effective-
     * ness of each type. <p> <p> Assumes that the {@code efficacies} {@code List} is ordered as per the {@code TypeIds}
     * in {@code pokedb.sqlite}. </p>
     *
     * @param efficacies The {@link List} of {@code TypeEfficacies}.
     *
     * @return {@code String} representation of the given {@code efficacies}.
     */
    public static String efficacies(List<Map.Entry<Integer, Integer>> efficacies) {
        StringBuilder builder = new StringBuilder();
        boolean first = true;

        // The key is the typeId, the value is the efficacy (0|25|50|100|200|400).
        for (Map.Entry<Integer, Integer> efficacy : efficacies) {
            try {
                String parsed = MessageFormats.efficacy(efficacy.getKey(), efficacy.getValue());
                if (parsed.isEmpty()) {
                    // Do nothing for empty Strings (efficacy = 100 returns empty String)
                    continue;
                }
                if (!first) {
                    builder.append(" ");
                }
                // Add to the message
                builder.append(parsed);
                first = false;
            } catch (TypeIdNotFoundException tinfe) {
                // Something wrong with the database.
                return MessageFormats.error;
            }
        }
        return builder.toString();
    }

    /**
     * Converts a <i>single</i> {@code TypeId} and {@code efficacy} to a {@link String}, to be appended internally to
     * the {@link #efficacies(List)} {@code String}.
     *
     * @param typeId   The {@code TypeId} of the {@code Type} in question.
     * @param efficacy The {@code TypeEfficacy} of the {@code Type} in question.
     *
     * @return A {@code String} representing the efficacy of the single {@code TypeId} and {@code efficacy}.
     *
     * @throws TypeIdNotFoundException If the given {@code TypeId} has no {@code TypeName} in the {@code
     *                                 pokedb.sqlite}.
     */
    private static String efficacy(int typeId, Integer efficacy) throws TypeIdNotFoundException {
        String typeName = TypeQuery.getTypeNameFromTypeId(typeId);
        switch (efficacy) {
            // Bold for 4* restistance / weaknesses, green for resistance, red for weakness, gray for no effect
            case 0:
                return MessageFormats.formatted(typeName, Colors.DARK_GRAY + Colors.BOLD);
            case 25:
                return MessageFormats.formatted(typeName, Colors.DARK_GREEN + Colors.BOLD);
            case 50:
                return MessageFormats.formatted(typeName, Colors.DARK_GREEN);
            case 200:
                return MessageFormats.formatted(typeName, Colors.RED);
            case 400:
                return MessageFormats.formatted(typeName, Colors.RED + Colors.BOLD);
            case 100:
                // Don't bother listing all the 100% types
                return "";
            default:
                // Something unexpected happenbed (probably bad math...)
                throw new TypeIdNotFoundException(typeId);
        }
    }
}
