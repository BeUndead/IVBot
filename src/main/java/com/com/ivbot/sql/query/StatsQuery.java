package com.com.ivbot.sql.query;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Handles the extraction of {@code Stats} from a query.
 */
public class StatsQuery {

    /**
     * The {@code RegEx} for a single {@code Stat}.
     */
    private static final String STAT_REGEX = "([0-9]{1,3})";
    /**
     * The {@code RegEx} for the {@code StatsSeparator}.
     */
    private static final String STAT_SEPARATOR_REGEX = "([\\.\\/\\-])";
    /**
     * The combined {@code RegEx} for a complete set of {@code Stats}.
     */
    private static final String STATS_REGEX = String.format("\\b(?<stats>(%1$s" +
                                                            "(?<div>%2$s))" +
                                                            "(%1$s\\k<div>){4}(%1$s)" +
                                                            ")\\b", STAT_REGEX, STAT_SEPARATOR_REGEX);
    /**
     * The {@code RegEx} {@code Pattern} to test the {@code String} against.
     */
    private static final Pattern STATS_PATTERN = Pattern.compile(STATS_REGEX);
    /**
     * The {@code RegEx} {@code Matcher} to extract the matching part from the {@code String}.
     */
    private static Matcher STATS_MATCHER;

    /**
     * Retrieves the {@code Stats} from {@code query} (if they can be found).
     *
     * @param query The {@code String} in which to attempt to locate the {@code Stats}.
     *
     * @return An {@code array} of {@code int}s representing the {@code Stats} found in the given {@code String}.
     *
     * @throws StatsNotRecognisedException If no {@code Stats} can be located within the given {@code String}.
     */
    public static int[] getStatsFromQuery(String query) throws com.com.ivbot.sql.query.StatsNotRecognisedException {
        STATS_MATCHER = STATS_PATTERN.matcher(query);
        if (STATS_MATCHER.find()) {
            String[] statsStringArray = STATS_MATCHER.group("stats").split(STAT_SEPARATOR_REGEX);
            int[] stats = new int[6];
            for (int i = 0; i < 6; i++) {
                stats[i] = Integer.parseInt(statsStringArray[i]);
            }
            if (areStatsValid(stats)) {
                return stats;
            }
        }
        throw new com.com.ivbot.sql.query.StatsNotRecognisedException(query);
    }

    /**
     * Checks if the given {@code Stats}, {@code stats} are indeed valid {@code Stats}.
     *
     * @param stats The {@code Stats} to be tested.
     *
     * @return {@code true} if {@code stats} are valid {@code Stats}, otherwise {@code false}.
     */
    private static boolean areStatsValid(int[] stats) {
        if (stats.length != 6) {
            return false;
        }
        for (int stat : stats) {
            if (stat < 1 || stat > 714) {
                return false;
            }
        }
        return true;
    }

    /**
     * Finds the matching part of the given {@code String}; this is used to remove the matching part from the given
     * message during parsing, so that the stats are not (incorrectly) read as {@code EV}s afterwards.
     *
     * @param query The {@code String} with the {@code Stat}s contained.
     *
     * @return The sub-{@code String} of the {@code query} which matched as {@code Stat}s.
     *
     * @throws StatsNotRecognisedException If there is no matching sub-{@code String} within the given {@code query}.
     */
    public static String getMatchingSubstringFromQuery(String query)
            throws com.com.ivbot.sql.query.StatsNotRecognisedException {
        STATS_MATCHER = STATS_PATTERN.matcher(query);
        if (!STATS_MATCHER.find()) {
            throw new com.com.ivbot.sql.query.StatsNotRecognisedException(query);
        }
        return STATS_MATCHER.group("stats");
    }

}
