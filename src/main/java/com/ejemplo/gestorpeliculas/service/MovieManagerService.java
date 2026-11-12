package com.ejemplo.gestorpeliculas.service;

import com.ejemplo.gestorpeliculas.model.Genre;
import com.ejemplo.gestorpeliculas.model.Movie;
import com.ejemplo.gestorpeliculas.repository.GenreRepository;
import com.ejemplo.gestorpeliculas.repository.MovieRepository;

import java.util.List;

/** Contiene las operaciones y las reglas principales del gestor. */
public class MovieManagerService {
    private final GenreRepository genreRepository;
    private final MovieRepository movieRepository;

    public MovieManagerService(GenreRepository genreRepository, MovieRepository movieRepository) {
        this.genreRepository = genreRepository;
        this.movieRepository = movieRepository;
    }

    public void addGenre(String name) {
        Genre genre = new Genre(name);
        if (genreRepository.findByName(genre.getName()) != null) {
            throw new IllegalArgumentException("Ese género ya existe.");
        }
        genreRepository.add(genre);
    }

    public void addMovie(String title, int year, String genreName) {
        Genre genre = genreRepository.findByName(genreName);
        if (genre == null) {
            throw new IllegalArgumentException("Ese género no existe. Añádelo primero.");
        }
        movieRepository.add(new Movie(title, year, genre));
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getMoviesByGenre(String genreName) {
        return movieRepository.findByGenre(genreName);
    }
}
