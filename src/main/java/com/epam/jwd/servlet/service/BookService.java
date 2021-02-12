package com.epam.jwd.servlet.service;

import com.epam.jwd.servlet.dao.CommonDao;
import com.epam.jwd.servlet.model.Book;
import com.epam.jwd.servlet.model.BookDto;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class BookService implements CommonService<BookDto> {

    private final CommonDao<Book> bookDao;

    public BookService(CommonDao<Book> bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Optional<List<BookDto>> findAll() {
        return bookDao.findAll()
                .map(
                        books -> books.stream()
                                .map(this::convertToDto)
                                .collect(toList())
                );
    }

    @Override
    public Optional<BookDto> save(BookDto dto) {
        return Optional.empty();
    }

    private BookDto convertToDto(Book book) {
        return new BookDto(book.getName(), book.getYear());
    }
}
