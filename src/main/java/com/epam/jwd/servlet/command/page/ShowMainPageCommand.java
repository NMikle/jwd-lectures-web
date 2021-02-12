package com.epam.jwd.servlet.command.page;

import com.epam.jwd.servlet.command.Command;
import com.epam.jwd.servlet.command.RequestContext;
import com.epam.jwd.servlet.command.ResponseContext;

public enum ShowMainPageCommand implements Command {
    INSTANCE;

    private static final ResponseContext MAIN_PAGE_RESPONSE = new ResponseContext() {
        @Override
        public String getPage() {
            return "/WEB-INF/jsp/main.jsp";
        }

        @Override
        public boolean isRedirect() {
            return false;
        }
    };

    @Override
    public ResponseContext execute(RequestContext request) {
        return MAIN_PAGE_RESPONSE;
    }
}
