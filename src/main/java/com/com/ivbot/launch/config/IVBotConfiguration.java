package com.com.ivbot.launch.config;

import com.com.ivbot.listen.security.IVBotAccessLevel;
import org.pircbotx.PircBotX;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Maintains the configuration settings used for this {@link PircBotX} {@code IVBot}.
 */
public class IVBotConfiguration {

    private final List<String> autoJoinChannels = new ArrayList<>();
    private final Map<String, IVBotAccessLevel> accessLevels = new HashMap<>();
    private boolean debug;
    private String botNick;
    private String botNickServPassword;
    private String login;
    private String version;
    private String mainServer;
    private String backupServer;
    private String commandTrigger;

    /**
     * Constructor; allow access only within package.  All instances should be returned from methods within {@code
     * IVBotConfigurationBuilder}.
     */
    IVBotConfiguration() {
    }

    public boolean getDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getBotNick() {
        return botNick;
    }

    public void setBotNick(String newBotNick) {
        this.botNick = newBotNick;
    }

    public String getBotNickServPassword() {
        return botNickServPassword;
    }

    public void setBotNickServPassword(String newBotNickServPassword) {
        this.botNickServPassword = newBotNickServPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMainServer() {
        return mainServer;
    }

    public void setMainServer(String mainServer) {
        this.mainServer = mainServer;
    }

    public String getBackupServer() {
        return backupServer;
    }

    public void setBackupServer(String backupServer) {
        this.backupServer = backupServer;
    }

    public List<String> getAutoJoinChannels() {
        return autoJoinChannels;
    }

    public void resetAutoJoinChannels() {
        autoJoinChannels.clear();
    }

    public void addAutoJoinChannel(String autoJoinChannel) {
        if (!autoJoinChannels.contains(autoJoinChannel.toLowerCase())) {
            autoJoinChannels.add(autoJoinChannel.toLowerCase());
        }
    }

    public String getCommandTrigger() {
        return commandTrigger;
    }

    public void setCommandTrigger(String commandTrigger) {
        this.commandTrigger = commandTrigger;
    }

    public Map<String, IVBotAccessLevel> getAccessLevels() {
        return accessLevels;
    }

    public void resetAccessLevels() {
        accessLevels.clear();
    }

    public void addAccessLevel(String nick, IVBotAccessLevel level) {
        accessLevels.put(nick.toLowerCase(), level);
    }

}
