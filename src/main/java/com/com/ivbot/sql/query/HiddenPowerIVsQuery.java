package com.com.ivbot.sql.query;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Like IVsQuery, handles the extraction of {@code IV}s from a {@code String}, however allows {@literal "e"} and
 * {@literal "o"} as additional acceptable values for an <i>even</i> and <i>odd</i> {@code IV} (without a specified
 * value) respectively.
 */
public class HiddenPowerIVsQuery {

    /**
     * The {@code RegEx} for the {@code IVSeparator}.
     */
    protected static final String IV_SEPARATOR_REGEX = "([\\.\\/])";
    /**
     * The {@code RegEx} for a single {@code IV}.
     */
    protected static final String IV_REGEX = "([0-2]*[0-9]|[3][0-1]|o|e)";
    /**
     * The combined {@code RegEx} for a complete set of {@code IVs}.
     */
    protected static final String IVs_REGEX =
            String.format("\\b(?<ivs>(%1$s%2$s){5}" + "(%1$s))\\b", IV_REGEX, IV_SEPARATOR_REGEX);
    /**
     * The {@code RegEx} {@code Pattern} to test the {@code String} against.
     */
    protected static final Pattern IV_PATTERN = Pattern.compile(IVs_REGEX);
    /**
     * The {@code RegEx} {@code Matcher} to extract the matching part from the {@code String}.
     */
    protected static Matcher IV_MATCHER;

    /**
     * Finds the {@code IV}s from a {@code String}.  If {@literal "e"} is found, then the {@code IV} is set to be {@code
     * 30} and if an {@literal "o"} is found, then the {@code IV} is set to be {@code 31}.
     *
     * @param query The {@code String} in which to find the {@code IV}s.
     *
     * @return An {@code Array} of the values of the {@code IV}s found in the {@code String}; with {@literal "e"}
     * replaced with {@code 30} and {@literal "o"} replaced with {@code 31}.
     *
     * @throws IVsNotRecognisedException If no valid {@code IV}s are found in the {@code String}.
     */
    public static int[] getHPIVsFromQuery(String query) throws IVsNotRecognisedException {
        IV_MATCHER = IV_PATTERN.matcher(query);
        if (IV_MATCHER.find()) {
            String[] ivsStringArray = IV_MATCHER.group("ivs").split(IV_SEPARATOR_REGEX);
            int[] ivs = new int[6];
            for (int i = 0; i < 6; i++) {
                try {
                    ivs[i] = Integer.parseInt(ivsStringArray[i]);
                } catch (NumberFormatException nfe) {
                    if (ivsStringArray[i].equals("o")) {
                        ivs[i] = 31;
                    } else if (ivsStringArray[i].equals("e")) {
                        ivs[i] = 30;
                    }
                }
            }
            if (areIVsValid(ivs)) {
                return ivs;
            }
        }
        throw new IVsNotRecognisedException(query);
    }

    /**
     * Checks if the given {@code IVs}, {@code ivs} are indeed valid {@code IVs}.
     *
     * @param ivs The {@code IVs} to be tested.
     *
     * @return {@code true} if {@code ivs} are valid {@code IVs}, otherwise {@code false}.
     */
    private static boolean areIVsValid(int[] ivs) {
        if (ivs.length != 6) {
            return false;
        }
        for (int iv : ivs) {
            if (iv < 0 || iv > 31) {
                return false;
            }
        }
        return true;
    }

}
