package com.com.ivbot.launch;

import com.com.ivbot.launch.config.ConfigurationBuilder;
import com.com.ivbot.launch.config.IVBotConfigurationBuilder;
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;

import java.io.IOException;

/**
 * Sets up and runs the {@code PircBotX} {@code IVBot}.
 */
public class IVBot implements Runnable {

    /**
     * Launch point for {@code IVBot}'s {@code Thread}.
     */
    @Override
    public void run() {
        // query the {@code Configuration} from the {@code config.xml} {@code File}
        IVBotConfigurationBuilder builder = new IVBotConfigurationBuilder();
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder(builder.getIVBotConfiguration());
        Configuration configuration = configurationBuilder.getConfiguration();

        PircBotX ivBot = new PircBotX(configuration);

        // attempt to start the {@code IVBot}
        try {
            ivBot.startBot();
        } catch (IOException e) {
            System.err.format("%n%s: %s", e.getClass().getName(), e.getMessage());
            // abort application if an {@code IOException} halts {@code IVBot#start()}
            throw new RuntimeException("IO trouble for startBot()");
        } catch (IrcException e) {
            System.err.format("%n%s: %s", e.getClass().getName(), e.getMessage());
            // abort application if an {@code IrcException} halts {@code IVBot#start()}
            throw new RuntimeException("IRC connection trouble in startBot()");
        }
    }

}
