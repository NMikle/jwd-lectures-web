package com.epam.jwd.servlet.model;

public class Book {

    private final Integer id;
    private final String name;
    private final Integer year;

    public Book(Integer id, String name, Integer year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }
}
