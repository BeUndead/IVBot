package com.com.ivbot.launch.config;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Tests whether the {@code config.xml} {@link File} (as well as any passed in arguments) are correctly being read.
 */
public class ConfigurationTest {

    /**
     * The {@code IVBotConfigurationBuilder} from which to build the {@code IVBotConfiguration}.
     */
    private static IVBotConfigurationBuilder configurationBuilder;
    /**
     * The {@code IVBotConfiguration} for the default {@code IVBot}.
     */
    private static IVBotConfiguration configuration;

    /**
     * Sets up the {@code configuration} as default.
     */
    @BeforeClass
    public static void setupConfigurationBuilderAndGetConfiguration() {
        configurationBuilder = new IVBotConfigurationBuilder();
        configuration = configurationBuilder.getIVBotConfiguration();
    }

    /**
     * Tests that the extracted {@code BotNick} is as expected.
     */
    @Test
    public void testBotNick() {
        assertEquals("The IVBotNick was not as expected", "IVBot", configuration.getBotNick());
    }

}
