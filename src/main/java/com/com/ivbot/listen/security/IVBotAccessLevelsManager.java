package com.com.ivbot.listen.security;

import org.pircbotx.PircBotX;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the present {@link IVBotAccessLevel}s for users as defined by this {@link PircBotX}.
 */
public class IVBotAccessLevelsManager {

    /**
     * The {@code Map} which contains the {@code nick} of users as the key, and their present {@code AccessLevel} as the
     * value.
     */
    private static final Map<String, IVBotAccessLevel> accessLevels = new HashMap<>();

    /**
     * Constructor; disable instantiation.
     */
    private IVBotAccessLevelsManager() {
    }

    /**
     * Sets the {@code AccessLevel} of user {@code nick} to {@code newLevel}.
     *
     * @param nick     The nick of the user to change {@code AccessLevel} of.
     * @param newLevel The new {@code AccessLevel} for the user specified by {@code nick}.
     */
    public static void setLevel(String nick, IVBotAccessLevel newLevel) {
        IVBotAccessLevel currentLevel = accessLevels.get(nick.toLowerCase());
        if (newLevel == IVBotAccessLevel.NORMAL) {
            if (currentLevel != null) {
                accessLevels.remove(nick.toLowerCase());
            }
        } else {
            if (currentLevel == null) {
                accessLevels.put(nick, newLevel);
            } else {
                currentLevel = newLevel;
            }
        }
    }

    /**
     * Tests if the user specified by {@code nick} has the {@code AccessLevel} {@code level} or above.
     *
     * @param nick  The nick of the user to test.
     * @param level The {@code AccessLevel} to see if the user specified by {@code nick} has.
     *
     * @return {@code true} if the user specified by {@code nick} has at least {@code AccessLevel} {@code level},
     * otherwise {@code false}.
     */
    public static boolean hasLevel(String nick, IVBotAccessLevel level) {
        if (level == IVBotAccessLevel.RESTRICTED) {
            return true;
        }
        IVBotAccessLevel currentLevel = accessLevels.get(nick.toLowerCase());
        if (currentLevel == null) {
            return level.getLevel() <= IVBotAccessLevel.NORMAL.getLevel();
        }
        return currentLevel.getLevel() >= level.getLevel();
    }

}
