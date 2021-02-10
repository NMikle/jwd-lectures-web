package com.epam.jwd.servlet.command;

import com.epam.jwd.servlet.model.BookDto;

import java.util.Arrays;
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
    private static final List<BookDto> BOOKS_COLLECTION = Arrays.asList(new BookDto("Spring in Action"),
            new BookDto("Calculus"), new BookDto("Effective Java"));
    private static final String BOOKS_ATTRIBUTE_NAME = "books";

    @Override
    public ResponseContext execute(RequestContext request) {
        request.setAttribute(BOOKS_ATTRIBUTE_NAME, BOOKS_COLLECTION);
        return BOOKS_PAGE_RESPONSE;
    }
}
