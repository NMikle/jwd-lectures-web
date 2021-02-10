package com.epam.jwd.servlet.command;

public enum LogoutCommand implements Command {
    INSTANCE;

    @Override
    public ResponseContext execute(RequestContext request) {
        return null;
    }
}
