package com.epam.jwd.servlet.command;

public interface Command {

    ResponseContext execute(RequestContext request);

    static Command of(String name) {
        return CommandManager.of(name);
    }

}
