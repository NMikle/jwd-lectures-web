package com.epam.jwd.servlet.dao.impl;

import com.epam.jwd.servlet.dao.CommonDao;
import com.epam.jwd.servlet.model.Book;
import com.epam.jwd.servlet.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDao implements CommonDao<Book> {

    private static final String FIND_ALL_BOOKS_SQL = "SELECT id, book_name, year_published FROM book";
    private static final String ID_COLUMN_NAME = "id";
    private static final String BOOK_NAME_COLUMN_NAME = "book_name";
    private static final String YEAR_PUBLISHED_COLUMN_NAME = "year_published";

    @Override
    public Optional<List<Book>> findAll() {
        try (final Connection conn = ConnectionPool.INSTANCE.retrieveConnection();
             final Statement statement = conn.createStatement();
             final ResultSet resultSet = statement.executeQuery(FIND_ALL_BOOKS_SQL)) {
            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {
                books.add(readBook(resultSet));
            }
            return Optional.of(books);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Book> save(Book entity) {
        return Optional.empty();
    }

    private Book readBook(ResultSet resultSet) throws SQLException {
        return new Book(resultSet.getInt(ID_COLUMN_NAME),
                resultSet.getString(BOOK_NAME_COLUMN_NAME),
                resultSet.getInt(YEAR_PUBLISHED_COLUMN_NAME));
    }
}
