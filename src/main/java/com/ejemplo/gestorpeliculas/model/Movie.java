package com.ejemplo.gestorpeliculas.model;

/** Representa una película con título, año de estreno y género. */
public class Movie {
    private final String title;
    private final int year;
    private final Genre genre;

    public Movie(String title, int year, Genre genre) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }
        if (year < 1888 || year > 2100) {
            throw new IllegalArgumentException("El año debe estar entre 1888 y 2100.");
        }
        if (genre == null) {
            throw new IllegalArgumentException("La película debe tener un género.");
        }
        this.title = title.trim();
        this.year = year;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return title + " (" + year + ") - " + genre.getName();
    }
}
