package com.epam.jwd.servlet.command.page;

import com.epam.jwd.servlet.command.Command;
import com.epam.jwd.servlet.command.RequestContext;
import com.epam.jwd.servlet.command.ResponseContext;
import com.epam.jwd.servlet.service.BookService;
import com.epam.jwd.servlet.service.CommonService;
import com.epam.jwd.servlet.dao.impl.BookDao;
import com.epam.jwd.servlet.model.BookDto;

import java.util.Collections;
import java.util.List;

public enum ShowAllBooksCommand implements Command {
    INSTANCE;

    private static final ResponseContext BOOKS_PAGE_RESPONSE = new ResponseContext() {
        @Override
        public String getPage() {
            return "/WEB-INF/jsp/books.jsp";
        }

        @Override
        public boolean isRedirect() {
            return false;
        }
    };

    private static final String BOOKS_ATTRIBUTE_NAME = "books";

    private final CommonService<BookDto> bookService;

    ShowAllBooksCommand() {
        bookService = new BookService(new BookDao());
    }

    @Override
    public ResponseContext execute(RequestContext request) {
        final List<BookDto> books = bookService.findAll().orElse(Collections.emptyList());
        request.setAttribute(BOOKS_ATTRIBUTE_NAME, books);
        return BOOKS_PAGE_RESPONSE;
    }
}
