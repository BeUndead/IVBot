package com.com.ivbot.launch.config;

import com.com.ivbot.launch.IVBot;
import com.com.ivbot.listen.security.IVBotAccessLevel;
import com.com.ivbot.listen.security.IVBotAccessLevelsManager;
import com.com.ivbot.listen.util.ListenerUtilities;
import org.pircbotx.Configuration;
import org.pircbotx.Configuration.Builder;
import org.pircbotx.hooks.Listener;

import java.util.Map;

/**
 * Generates the {@link Configuration} used to instance the {@link IVBot} from the {@link IVBotConfiguration}.
 */
public class ConfigurationBuilder {

    /**
     * The {@code IVBotConfiguration} from which to extract settings.
     */
    private final IVBotConfiguration ivBotConfiguration;

    /**
     * The {@code Configuration} used to instance the {@code IVBot}.
     */
    private Configuration configuration;

    /**
     * Constructor; builds the {@code configuration} from the given {@code IVBotConfiguration}.
     *
     * @param ivBotConfiguration the {@code IVBotConfiguration} from which to extract the required settings.
     */
    public ConfigurationBuilder(IVBotConfiguration ivBotConfiguration) {
        this.ivBotConfiguration = ivBotConfiguration;
        setup();
    }

    /**
     * Sets the {@code configuration} based on the given {@code IVBotConfiguration}.
     */
    private void setup() {
        // settings for the {@code Configuration}
        Builder builder = new Builder();
        builder.setName(ivBotConfiguration.getBotNick());
        builder.setLogin(ivBotConfiguration.getLogin());
        builder.setServerHostname(ivBotConfiguration.getMainServer());
        ivBotConfiguration.getAutoJoinChannels().forEach(channel -> builder.addAutoJoinChannel(channel));
        builder.setVersion(ivBotConfiguration.getVersion());
        builder.setAutoReconnect(true);
        builder.setMessageDelay(0L);
        for (Listener listener : ListenerUtilities.getAllListeners()) {
            builder.addListener(listener);
        }
        configuration = builder.buildConfiguration();

        // settings for {@code IVBotAccessLevel}s
        for (Object object : ivBotConfiguration.getAccessLevels().entrySet()) {
            Map.Entry<String, IVBotAccessLevel> entry = (Map.Entry) object;
            IVBotAccessLevelsManager.setLevel(entry.getKey(), entry.getValue());
        }

        // settings for the {@code Listener}s for the {@code IVBot}
        ListenerUtilities.COMMAND_TRIGGER = ivBotConfiguration.getCommandTrigger();
    }

    /**
     * The {@code Configuration} to be used to instance an {@code IVBot} with the settings inherited from the given
     * {@code IVBotConfiguration}.
     *
     * @return the {@code Configuration} to be used to instance an {@code IVBot}.
     */
    public Configuration getConfiguration() {
        return configuration;
    }

}
