package com.com.ivbot.sql.query;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Handles the extraction of {@code EVs} from a query.
 */
public class EVsQuery {

    /**
     * Default values for the {@code EV}s in queries.
     */
    public static final int[] STANDARD = new int[] {0, 0, 0, 0, 0, 0};

    /**
     * The {@code RegEx} for a single {@code EV}.
     */
    private static final String EV_REGEX = "([0-1]*[0-9]*[0-9]|[2][0-4][0-9]|[2][5][0-2])";
    /**
     * The {@code RegEx} for the {@code EVSeparator}.
     */
    private static final String EV_SEPARATOR_REGEX = "([\\.\\/\\-])";
    /**
     * The combined {@code RegEx} for a complete set of {@code EVs}.
     */
    private static final String EVs_REGEX =
            String.format("\\b(?<evs>(%1$s(?<div>%2$s))" + "(%1$s\\k<div>){4}(%1$s))\\b", EV_REGEX, EV_SEPARATOR_REGEX);
    /**
     * The {@code RegEx} {@code Pattern} to test the {@code String} against.
     */
    private static final Pattern EV_PATTERN = Pattern.compile(EVs_REGEX);
    /**
     * The {@code RegEx} {@code Matcher} to extract the matching part from the {@code String}.
     */
    private static Matcher EV_MATCHER;

    /**
     * Retrieves the {@code EVs} from {@code query} (if they can be found).
     *
     * @param query The {@code String} in which to attempt to locate the {@code EVs}.
     *
     * @return An {@code array} of {@code int}s representing the {@code EVs} found in the given {@code String}.
     *
     * @throws EVsNotRecognisedException If no {@code EVs} can be located within the given {@code String}.
     */
    public static int[] getEVsFromQuery(String query) throws com.com.ivbot.sql.query.EVsNotRecognisedException {
        EV_MATCHER = EV_PATTERN.matcher(query);
        if (EV_MATCHER.find()) {
            String[] evsStringArray = EV_MATCHER.group("evs").split(EV_SEPARATOR_REGEX);
            int[] evs = new int[6];
            for (int i = 0; i < 6; i++) {
                evs[i] = Integer.parseInt(evsStringArray[i]);
            }
            if (areEVsValid(evs)) {
                return evs;
            }
        }
        throw new com.com.ivbot.sql.query.EVsNotRecognisedException(query);
    }

    /**
     * Checks if the given {@code EVs}, {@code evs} are indeed valid {@code EVs}.
     *
     * @param evs The {@code EVs} to be tested.
     *
     * @return {@code true} if {@code evs} are valid {@code EVs}, otherwise {@code false}.
     */
    private static boolean areEVsValid(int[] evs) {
        if (evs.length != 6) {
            return false;
        }
        int sum = 0;
        for (int ev : evs) {
            if (ev < 0 || ev > 252) {
                return false;
            }
            sum += ev;
        }
        return sum <= 510;
    }

}
