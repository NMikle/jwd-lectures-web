package com.epam.jwd.servlet.command;

import com.epam.jwd.servlet.command.page.ShowAllBooksCommand;
import com.epam.jwd.servlet.command.page.ShowMainPageCommand;
import com.epam.jwd.servlet.command.user.LoginCommand;
import com.epam.jwd.servlet.command.user.LogoutCommand;

public enum CommandManager {
    LOGIN(LoginCommand.INSTANCE),
    LOGOUT(LogoutCommand.INSTANCE),
    DEFAULT(ShowMainPageCommand.INSTANCE),
    SHOW_BOOKS(ShowAllBooksCommand.INSTANCE);

    private final Command command;

    CommandManager(Command command) {
        this.command = command;
    }

    static Command of(String name) {
        for (CommandManager action : values()) {
            if (action.name().equalsIgnoreCase(name)) {
                return action.command;
            }
        }
        return DEFAULT.command;
    }
}
