package com.com.ivbot.listen;

import com.google.common.collect.ImmutableSet;
import org.mockito.stubbing.Answer;
import org.pircbotx.Channel;
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.User;
import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.managers.ListenerManager;
import org.pircbotx.output.OutputChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test suite utilising {@code Mockito}.
 */
public class ListenerTest {

    /**
     * Test {@code ListenerAdapter}s added to {@code listenersToTest} without requiring an established IRCConnection.
     * Lots of mockery, probably best to ignore implementation, and just go with it.
     * <p>
     * It is worth noting that while this is <i>not</i> a Unit Test, it minimises the boiler-plate necessary to test the
     * specific {@code ListenerAdapter}s which exist for {@code IVBot} to simplify testing prior to deployment.
     *
     * @param args Command-line arguments (unused).
     */
    public static void main(String[] args) {
        /*
         * TODO: mock {@code IVBotAccessLevelsManager::hasLevel(String, IVBotAccessLevel)} to return {@code true} for
         * any call.
         */
        // Construct a mock ImmutableSet for current Listeners (these are real)
        ImmutableSet<Listener> currentListeners = ImmutableSet
                .of(new CommandsCommand(), new RefactorCommand(), new GrantAccessLevelCommand(),
                    new StatsCommand(), new HPCommand(), new IVsCommand(), new LearnCommand(),
                    new AbilityCommand(), new MoveCommand(), new ItemCommand(), new NatureCommand(),
                    new TypeCommand());

        // And a mock PircBotX (returns above ImmutableSet when asked for listeners)
        PircBotX mockBot = mock(PircBotX.class);
        Configuration mockConfig = mock(Configuration.class);
        ListenerManager mockListenerManager = mock(ListenerManager.class);

        when(mockBot.getConfiguration()).thenReturn(mockConfig);
        when(mockConfig.getListenerManager()).thenReturn(mockListenerManager);
        when(mockListenerManager.getListeners()).thenReturn(currentListeners);

        // Mock MessageEvent
        MessageEvent mockMessageEvent = mock(MessageEvent.class);
        when(mockMessageEvent.getBot()).thenReturn(mockBot);
        User mockUser = mock(User.class);
        when(mockMessageEvent.getUser()).thenReturn(mockUser);
        when(mockUser.getNick()).thenReturn("oCom");

        Channel mockChannel = mock(Channel.class);
        OutputChannel mockOutputChannel = mock(OutputChannel.class);
        when(mockMessageEvent.getChannel()).thenReturn(mockChannel);
        when(mockChannel.send()).thenReturn(mockOutputChannel);

        // Simulates sending message to IRC channel (uses System.out#println(String)).
        Answer<Void> mockAnswer = I -> {
            String toPrint = (String) I.getArguments()[0];
            if (toPrint != null && !toPrint.equals("")) {
                System.out.println(String.format("<IVBot> %s", toPrint));
            }
            return null;
        };
        doAnswer(mockAnswer).when(mockOutputChannel).message(anyString());

        // Input methods (also real)
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        // Keep going, listening to the input each time
        while (true) {
            try {
                System.out.print("<&oCom> ");
                input = keyboard.readLine();
            } catch (IOException e) {
                System.err.println(String.format("%s : %s", e.getClass().getName(), e.getMessage()));
                e.printStackTrace();
            }
            // Exit while loop if `q` (or `Q`) is the input.
            if (input != null && input.equalsIgnoreCase("q")) {
                break;
            }
            when(mockMessageEvent.getMessage()).thenReturn(input);

            // Pass mockMessageEvent to all of the listenersToTest, to query theirResponse.
            for (Listener listener : currentListeners) {
                try {
                    ListenerAdapter adapter = (ListenerAdapter) listener;
                    // Print the name of the ListenerAdapter presently being tested (for debug).
                    //System.out.println(listener.getClass().getSimpleName());
                    adapter.onGenericMessage(mockMessageEvent);
                } catch (RuntimeException e) {
                    // Do not lump RuntimeException with other Exceptions.  Rethrow.
                    throw e;
                } catch (Exception e) {
                    System.err.println(String.format("%s : %s", e.getClass().getName(), e.getMessage()));
                    e.printStackTrace();
                } // End Catch
            } // End For
        } // End while
    } // End main

}
