package com.com.ivbot.sql.query;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Handles the extraction of {@code IVs} from a query.
 */
public class IVsQuery {

    /**
     * Default values for the {@code IV}s in queries.
     */
    public static final int[] STANDARD = new int[] {31, 31, 31, 31, 31, 31};

    /**
     * The {@code RegEx} for a single {@code IV}.
     */
    private static final String IV_REGEX = "([0-2]*[0-9]|[3][0-1])";
    /**
     * The {@code RegEx} for the {@code IVSeparator}.
     */
    private static final String IV_SEPARATOR_REGEX = "([\\.\\/\\-])";
    /**
     * The combined {@code RegEx} for a complete set of {@code IVs}.
     */
    private static final String IVs_REGEX =
            String.format("\\b(?<ivs>(%1$s(?<div>%2$s))" + "(%1$s\\k<div>){4}(%1$s))\\b", IV_REGEX, IV_SEPARATOR_REGEX);
    /**
     * The {@code RegEx} {@code Pattern} to test the {@code String} against.
     */
    private static final Pattern IV_PATTERN = Pattern.compile(IVs_REGEX);
    /**
     * The {@code RegEx} {@code Matcher} to extract the matching part from the {@code String}.
     */
    private static Matcher IV_MATCHER;

    /**
     * Retrieves the {@code IVs} from {@code query} (if they can be found).
     *
     * @param query The {@code String} in which to attempt to locate the {@code IVs}.
     *
     * @return An {@code array} of {@code Integer}s representing the {@code IVs} found in the given {@code String}.
     *
     * @throws IVsNotRecognisedException If no {@code IVs} can be located within the given {@code String}.
     */
    public static int[] getIVsFromQuery(String query) throws IVsNotRecognisedException {
        IV_MATCHER = IV_PATTERN.matcher(query);
        if (IV_MATCHER.find()) {
            String[] ivsStringArray = IV_MATCHER.group("ivs").split(IV_SEPARATOR_REGEX);
            int[] ivs = new int[6];
            for (int i = 0; i < 6; i++) {
                ivs[i] = Integer.parseInt(ivsStringArray[i]);
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

    /**
     * Retrieves the sub{@code String} of the {@code query} at which point the {@code IV}s were found.  This is used so
     * that they are <i>not</i> read again (as {@code EV}s) and get removed from the {@code String} once located.
     *
     * @param query The {@code String} from the {@code User} in which the {@code IV}s are to be found.
     *
     * @return The sub{@code String} of the {@code query} at which point the {@code IV}s were found.
     *
     * @throws IVsNotRecognisedException If there are <i>no</i> recognised {@code IV}s in the given {@code String}.
     */
    public static String getMatchingSubstringFromQuery(String query) throws IVsNotRecognisedException {
        IV_MATCHER = IV_PATTERN.matcher(query);
        if (IV_MATCHER.find()) {
            return IV_MATCHER.group("ivs");
        }
        throw new IVsNotRecognisedException(query);
    }

}
