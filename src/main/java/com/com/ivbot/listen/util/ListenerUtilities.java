package com.com.ivbot.listen.util;

import com.com.ivbot.listen.CommandListener;
import com.com.ivbot.listen.IVBotCommand;
import com.google.common.collect.ImmutableSet;
import org.pircbotx.Configuration;
import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.managers.ListenerManager;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Static settings used across (most, if not) all commands.
 */
public class ListenerUtilities {

    private static final Reflections reflections = new Reflections();
    /**
     * The prefix for {@code Class} {@code Object}s in the designated {@code commandsDirectory}.
     */
    private static final String commandsPackage = "com.com.ivbot.listen.";

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

    /**
     * Retrieves a {@link List} of all {@link IVBotCommand IVBotCommands} registered.
     *
     * @return The {@code List} of {@code IVBotCommands}.
     */
    public static List<Listener> getAllListeners() {
        List<Listener> listeners = new ArrayList<>();

        Set<Class<? extends CommandListener>> commandClasses = reflections.getSubTypesOf(CommandListener.class);

        for (Class<? extends CommandListener> commandClass : commandClasses) {
            if (!commandClass.isAnnotationPresent(IVBotCommand.class)) {
                continue;
            }
            try {
                listeners.add(commandClass.newInstance());
            } catch (InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }

        return listeners;
    }

}
