package com.com.ivbot.listen;

import com.com.ivbot.listen.util.ListenerUtilities;
import com.com.ivbot.listen.util.MessageFormats;

import java.util.ArrayList;
import java.util.List;

/**
 * Command to recheck the {@code .class} files in order to see if any additional {@link CommandListener}s have been
 * written since, and if they have, add them to the global {@code CommandListener}s.  Extends {@link
 * AdminCommandListener} so that only those on the config.xml admin list may use this command.
 */
@IVBotCommand (value = "refactor", explicitHelp = true)
public final class RefactorCommand extends OwnerCommandListener {

    /**
     * Gives information about the access level of this command, as well as what it does.
     *
     * @param message The message to respond to.
     *
     * @return Information about the required access level for this command and what it can be expected to achieve.
     */
    @Override
    protected List<String> getHelp(String message) {

        String description = "Compiles and implements any new CommandListeners";
        String usage = "";

        return MessageFormats.helpFormat(COMMAND_NAME, description, usage);
    }

    /**
     * Checks for additional {@code *Command.class} files need to be dealt with, and adds any which do to the global
     * {@code CommandListener}s.
     *
     * @param message The message to respond to.
     *
     * @return A comment on the success or failure of the operation.
     */
    @Override
    protected List<String> getResponse(String message) {
        ListenerUtilities.addAllCommandListeners(latestEvent.getBot().getConfiguration());
        List<String> response = new ArrayList<>();
        response.add("Project refactor complete");
        return response;
    }

}
