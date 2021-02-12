package com.epam.jwd.servlet.dao.impl;

import com.epam.jwd.servlet.dao.CommonDao;
import com.epam.jwd.servlet.model.User;

import java.util.List;
import java.util.Optional;

public class UserDao implements CommonDao<User> {
    @Override
    public Optional<List<User>> findAll() {
        return Optional.empty();
    }

    @Override
    public Optional<User> save(User entity) {
        return Optional.empty();
    }

    public Optional<User> findByName(String name) {
        return Optional.empty();
    }
}
