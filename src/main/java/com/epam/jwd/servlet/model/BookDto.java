package com.epam.jwd.servlet.model;

import java.util.Objects;

public class BookDto {
    private final String name;

    public BookDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookDto)) return false;

        BookDto bookDto = (BookDto) o;

        return Objects.equals(name, bookDto.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
