package com.com.ivbot.listen.util;

import com.com.ivbot.listen.CommandListener;
import com.com.ivbot.listen.IVBotCommand;
import com.google.common.collect.ImmutableSet;
import org.pircbotx.Configuration;
import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.managers.ListenerManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Static settings used across (most, if not) all commands.
 */
public class ListenerUtilities {

    /**
     * The folder containing the (compiled) {@code Command}'s class files.
     */
    private static final File commandsDirectory = new File("./out/production/ivbot2/com/com/ivbot/listen/");
    /**
     * The prefix for {@code Class} {@code Object}s in the designated {@code commandsDirectory}.
     */
    private static final String commandsDirectoryClassPrefix = "com.com.ivbot.listen.";
    /**
     * The {@code File} extension for {@code Class} {@code Objects}.
     */
    private static final String classPostfix = ".class";
    /**
     * The {@link String} to proceed any messages to trigger a reaction from the bot.  Can be configured in the {@code
     * config.xml} {@code File} used in {@link com.com.ivbot.launch.config.IVBotConfigurationBuilder}.
     */
    public static String COMMAND_TRIGGER = "?";

    /**
     * Removes all {@code Listener}s from {@code bot}, and re-adds all valid ones (including those newly compiled).
     *
     * @param config The {@code PircBotX's} {@link Configuration} to configure the {@code Listener}s for.
     */
    public static void addAllCommandListeners(Configuration config) {
        // Remove all existing Listeners from the bot
        ListenerManager listenerManager = config.getListenerManager();
        ImmutableSet<Listener> oldListeners = listenerManager.getListeners();
        for (Listener oldListener : oldListeners) {
            listenerManager.removeListener(oldListener);
        }
        // Add all the new ones
        List<Listener> listeners = ListenerUtilities.getAllListeners();
        for (Listener listener : listeners) {
            listenerManager.addListener(listener);
        }
    }

    public static List<Listener> getAllListeners() {
        List<Listener> listeners = new ArrayList<>();
        // Scan through all the Files in the directory
        File[] filesInDirectory = commandsDirectory.listFiles();
        if (filesInDirectory == null || filesInDirectory.length == 0) {
            return listeners;
        }
        for (File file : commandsDirectory.listFiles()) {
            if (file == null) {
                continue;
            }
            if (file.isDirectory()) {
                continue;
            }
            String fileName = file.getName();
            if (!fileName.endsWith(classPostfix)) {
                continue;
            }
            fileName = fileName.substring(0, fileName.length() - classPostfix.length());
            fileName = commandsDirectoryClassPrefix + fileName;
            try {
                Class commandClass = Class.forName(fileName);
                if (commandClass.isAnnotationPresent(IVBotCommand.class)) {
                    // If they have the IVBotCommand annotation, then add it
                    CommandListener listener = (CommandListener) commandClass.newInstance();
                    listeners.add(listener);
                }
            } catch (ClassNotFoundException e) {
                System.err.format("Could not find class for %s%n", fileName);
            } catch (InstantiationException e) {
                System.err.format("Could not instance %s%n", fileName);
            } catch (IllegalAccessException e) {
                System.err.format("Illegal access at %s%n", fileName);
            }
        }
        return listeners;
    }

}
