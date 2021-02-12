package com.epam.jwd.servlet.command.user;

import com.epam.jwd.servlet.command.Command;
import com.epam.jwd.servlet.command.RequestContext;
import com.epam.jwd.servlet.command.ResponseContext;
import com.epam.jwd.servlet.command.page.ShowMainPageCommand;
import com.epam.jwd.servlet.command.page.ShowUserLoginPage;
import com.epam.jwd.servlet.model.UserDto;
import com.epam.jwd.servlet.service.UserService;

import java.util.Optional;

public enum LoginCommand implements Command {
    INSTANCE;

    private final UserService userService;

    LoginCommand() {
        userService = new UserService();
    }

    @Override
    public ResponseContext execute(RequestContext request) {
        final String name = String.valueOf(request.getAttribute("userName"));
        final String password = String.valueOf(request.getAttribute("userPassword"));
        final Optional<UserDto> user = userService.login(name, password);
        ResponseContext result;
        if (user.isPresent()) {
            request.setSessionAttribute("userName", name);
            result = ShowMainPageCommand.INSTANCE.execute(request); //TODO: rewrite with redirect
        } else {
            request.setAttribute("errorMessage", "invalid credentials");
            result = ShowUserLoginPage.INSTANCE.execute(request); //TODO: redirect
        }
        return result;
    }
}
