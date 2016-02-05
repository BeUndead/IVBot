package com.com.ivbot.launch.config;

import com.com.ivbot.listen.security.IVBotAccessLevel;
import org.apache.commons.configuration2.HierarchicalConfiguration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.tree.ImmutableNode;

import java.io.File;
import java.util.List;

/**
 * Handles reading the required properties from the default {@code config.xml}, or taking any values set in the passed
 * {@link String} {@code filePath} which differ from the defaults.
 */
public class IVBotConfigurationBuilder {

    /**
     * The filepath to the local default {@code config.xml} {@link File}.
     */
    private static final String DEFAULT_CONFIGURATION_FILEPATH = "resources/config.xml";

    /**
     * The default {@code config.xml} {@code File}.  Defaults are taken from this, and then additional properties (if
     * present) are taken from the given {@code File} or {@code String} {@code filepath}.
     */
    private static final File defaultConfigurationFile = new File(DEFAULT_CONFIGURATION_FILEPATH);
    /**
     * Holds the current configuration file.
     */
    private File configurationFile;
    /**
     * Configuration to extract information from the required {@code config.xml} {@code File}s.
     */
    private XMLConfiguration xmlConfiguration;
    /**
     * Local instance of {@code IVBotConfiguration}.  To be returned from the {@link #getIVBotConfiguration} method.
     */
    private IVBotConfiguration ivBotConfiguration;

    /**
     * Constructor; uses the default {@code config.xml} {@code File} exclusively to take settings from.
     */
    public IVBotConfigurationBuilder() {
        setup();
        readValuesFromFile(defaultConfigurationFile);
    }

    /**
     * Sets up the {@code ivBotConfiguration} as a new instance, to which the read values will be written.
     */
    private void setup() {
        ivBotConfiguration = new IVBotConfiguration();
    }

    /**
     * Attempts to initialise the {@code XMLConfiguration} {@code config} to allow extraction of the required settings
     * from.
     *
     * @throws RuntimeException if there is a {@link ConfigurationException} while attempting to locate the {@code
     *                          File}.
     */
    private void readValuesFromFile(File configurationFile) {
        try {
            Parameters parameters = new Parameters();
            FileBasedConfigurationBuilder<XMLConfiguration> builder =
                    new FileBasedConfigurationBuilder<>(XMLConfiguration.class)
                            .configure(parameters.xml().setFile(configurationFile));

            xmlConfiguration = builder.getConfiguration();
        } catch (ConfigurationException e) {
            System.err.format("%s : %s%n", e.getClass().getName(), e.getMessage());
            throw new RuntimeException(e);
        }

        String botNick = xmlConfiguration.getString("settings.botNick");
        if (botNick != null) {
            ivBotConfiguration.setBotNick(botNick);
        }

        String server = xmlConfiguration.getString("settings.servers.server");
        if (server != null) {
            ivBotConfiguration.setMainServer(server);
        }

        String nickservPassword = xmlConfiguration.getString("settings.nsPassword");
        if (nickservPassword != null) {
            ivBotConfiguration.setBotNickServPassword(nickservPassword);
        }

        String login = xmlConfiguration.getString("settings.login");
        if (login != null) {
            ivBotConfiguration.setLogin(login);
        }

        String version = xmlConfiguration.getString("settings.version");
        if (version != null) {
            ivBotConfiguration.setVersion(version);
        }

        Boolean debug = xmlConfiguration.getBoolean("settings.debug");
        if (debug != null) {
            ivBotConfiguration.setDebug(debug);
        }

        String commandTrigger = xmlConfiguration.getString("settings.trigger");
        if (commandTrigger != null) {
            ivBotConfiguration.setCommandTrigger(commandTrigger);
        }

        ivBotConfiguration.resetAutoJoinChannels();
        List<HierarchicalConfiguration<ImmutableNode>> channels =
                debug ? xmlConfiguration.configurationsAt("settings.channels.debug") :
                xmlConfiguration.configurationsAt("settings.channels.release");
        channels.forEach(channel -> ivBotConfiguration.addAutoJoinChannel(channel.getString("channel")));

        List<HierarchicalConfiguration<ImmutableNode>> owners =
                xmlConfiguration.configurationsAt("settings.accessLevels.owner");
        owners.forEach(user -> ivBotConfiguration.addAccessLevel(user.getString("[@nick]"), IVBotAccessLevel.OWNER));

        List<HierarchicalConfiguration<ImmutableNode>> admins =
                xmlConfiguration.configurationsAt("settings.accessLevels.admin");
        admins.forEach(user -> ivBotConfiguration.addAccessLevel(user.getString("[@nick]"), IVBotAccessLevel.ADMIN));

        List<HierarchicalConfiguration<ImmutableNode>> trusteds =
                xmlConfiguration.configurationsAt("settings.accessLevels.trusted");
        trusteds.forEach(
                user -> ivBotConfiguration.addAccessLevel(user.getString("[@nick]"), IVBotAccessLevel.TRUSTED));

        List<HierarchicalConfiguration<ImmutableNode>> restricteds =
                xmlConfiguration.configurationsAt("settings.accessLevels.restricted");
        restricteds.forEach(
                user -> ivBotConfiguration.addAccessLevel(user.getString("[@nick]"), IVBotAccessLevel.RESTRICTED));
    }

    /**
     * Constructor; uses the default {@code config.xml} {@code File} to take settings from, overwriting with any
     * settings defined in the {@code File} linked to by the {@code filePath}.
     *
     * @param filePath The filepath of the {@code .xml} {@code File} to read overwritten settings from.
     */
    public IVBotConfigurationBuilder(String filePath) {
        configurationFile = new File(filePath);
        setup();
        readValuesFromFile(defaultConfigurationFile);
        readValuesFromFile(configurationFile);
    }

    /**
     * Constructor; uses the default {@code config.xml} {@code File} to take settings from, overwriting with any
     * settings defined in the {@code File} {@code configFile}.
     *
     * @param configurationFile The {@code File} to extract non-default settings from.
     */
    public IVBotConfigurationBuilder(File configurationFile) {
        this.configurationFile = configurationFile;
        setup();
        readValuesFromFile(defaultConfigurationFile);
        readValuesFromFile(configurationFile);
    }

    /**
     * Gives an instance of {@code IVBotConfiguration} read from the {@code File}s passed into this {@code
     * IVBotConfigurationReader}.
     *
     * @return an instance of {@code IVBotConfiguration} with the values set from the default and given {@code
     * config.xml} {@code File}s.
     */
    public IVBotConfiguration getIVBotConfiguration() {
        return ivBotConfiguration;
    }

}
