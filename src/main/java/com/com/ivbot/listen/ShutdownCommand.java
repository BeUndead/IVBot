package com.com.ivbot.listen;

import com.com.ivbot.listen.util.MessageFormats;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Handles the shutdown of this {@code Bot}.
 */
// TODO - Finish implementing this.
//@IVBotCommand(value = "shutdown", explicitHelp = true)
public final class ShutdownCommand extends OwnerCommandListener {

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<String> getHelp(String message) {
        String description = "Instructs this Bot to quit IRC";
        String usage = "";
        return MessageFormats.helpFormat(COMMAND_NAME, description, usage);
    }

    /**
     * Attempts to quit IRC.
     *
     * @param message The message to respond to.
     *
     * @return A farewell message.
     */
    @Override
    protected List<String> getResponse(String message) {

        List<String> response = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        builder.append("Okely dokely; TTFN o/");
        response.add(builder.toString());

        // Set off the shutdown command (will trigger in 5s).
        new Thread(new Shutdown()).run();

        return response;
    }

    /**
     * Simple {@link Runnable} to handle {@code Shutdown} on a separate {@link Thread}.
     */
    private static class Shutdown implements Runnable {

        /**
         * Shuts down the {@code Bot}, with a delay (so that the {@code response} has time to deliver).
         */
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException iException) {
                iException.printStackTrace();
                Thread.currentThread().interrupt();
            }

            // TODO - Shutdown IRC here...
        }
    }
}
