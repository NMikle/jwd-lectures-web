package com.epam.jwd.servlet.model;

import java.util.Objects;

public class BookDto {
    private final String name;
    private final Integer year;

    public BookDto(String name, Integer year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookDto)) return false;

        BookDto bookDto = (BookDto) o;

        if (!Objects.equals(name, bookDto.name)) return false;
        return Objects.equals(year, bookDto.year);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
