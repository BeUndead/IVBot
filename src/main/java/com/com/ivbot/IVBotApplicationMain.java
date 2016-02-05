package com.com.ivbot;

import com.com.ivbot.launch.IVBot;

/**
 * Application launch class.
 */
public class IVBotApplicationMain {

    /**
     * Entry point for {@code IVBot} application.
     *
     * @param args Command line arguments (unused).
            */
    public static void main(String... args) {

        IVBot bot = new IVBot();
        bot.run();
    }

}
