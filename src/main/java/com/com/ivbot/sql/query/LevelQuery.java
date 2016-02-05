package com.com.ivbot.sql.query;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Handles the extraction of a {@code Level} from a query.
 */
public class LevelQuery {

    /**
     * Default {@code Level} in queries.
     */
    public static final int STANDARD = 100;

    /**
     * The {@code RegEx} for finding the {@code Level} within a {@code String}.
     */
    private static final String LEVEL_REGEX = "\\b(?:level|lv.|lv|lvl) (?<level>[0-9]{1,2}|100)\\b";
    /**
     * The {@code RegEx} {@code Pattern} to test the {@code String} against.
     */
    private static final Pattern LEVEL_PATTERN = Pattern.compile(LEVEL_REGEX);
    /**
     * The {@code RegEx} {@code Matcher} to extract the matching part from the {@code String}.
     */
    private static Matcher LEVEL_MATCHER;

    /**
     * Retrieves the {@code Level} from the given {@code String} (if one can be found).
     *
     * @param query The {@code String} in which to find a {@code Level}.
     *
     * @return The {@code Level} indicated within the {@code String}.
     *
     * @throws LevelNotRecognisedException If there is no valid {@code Level} found within the {@code query}.
     */
    public static int getLevelFromQuery(String query) throws LevelNotRecognisedException {
        LEVEL_MATCHER = LEVEL_PATTERN.matcher(query);
        if (LEVEL_MATCHER.find()) {
            int level = Integer.parseInt(LEVEL_MATCHER.group("level"));
            if (isValidLevel(level)) {
                return level;
            }
        }
        throw new LevelNotRecognisedException(query);
    }

    /**
     * Checks if a found {@code Level} is valid.
     *
     * @param level The {@code Level} to check.
     *
     * @return {@code true} if {@code level} is a valid {@code Level}, otherwise {@code false}.
     */
    private static boolean isValidLevel(int level) {
        return !(level < 1 || level > 100);
    }

}
