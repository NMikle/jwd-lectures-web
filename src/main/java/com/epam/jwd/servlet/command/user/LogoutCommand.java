package com.epam.jwd.servlet.command.user;

import com.epam.jwd.servlet.command.Command;
import com.epam.jwd.servlet.command.RequestContext;
import com.epam.jwd.servlet.command.ResponseContext;
import com.epam.jwd.servlet.command.page.ShowMainPageCommand;

public enum LogoutCommand implements Command {
    INSTANCE;

    @Override
    public ResponseContext execute(RequestContext request) {
        request.invalidateSession();
        return ShowMainPageCommand.INSTANCE.execute(request);
    }
}
