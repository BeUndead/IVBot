package com.com.ivbot.listen;

import com.com.ivbot.listen.security.IVBotAccessLevel;

/**
 * A {@code CommandListener} which requires the user has {@code AccessLevel.TRUSTED} (or above).
 */
public abstract class TrustedCommandListener extends LevelledCommandListener {

    /**
     * Constructor; sets {@code COMMAND_NAME} to {@code commandName}, and the {@code MINIMUM_ACCESS_LEVEL} to {@code
     * AccessLevel.TRUSTED}.
     */
    public TrustedCommandListener() {
        super(IVBotAccessLevel.TRUSTED);
    }

}
