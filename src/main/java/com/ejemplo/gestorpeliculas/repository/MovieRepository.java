package com.ejemplo.gestorpeliculas.repository;

import com.ejemplo.gestorpeliculas.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Guarda las películas en memoria. */
public class MovieRepository {
    private final List<Movie> movies = new ArrayList<>();

    public void add(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> findAll() {
        return new ArrayList<>(movies);
    }

    public List<Movie> findByGenre(String genreName) {
        return movies.stream()
                .filter(movie -> movie.getGenre().getName().equalsIgnoreCase(genreName))
                .collect(Collectors.toList());
    }
}
