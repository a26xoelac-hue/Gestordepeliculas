package com.ejemplo.gestorpeliculas.service;

import com.ejemplo.gestorpeliculas.model.Movie;
import com.ejemplo.gestorpeliculas.repository.GenreRepository;
import com.ejemplo.gestorpeliculas.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerServiceTest {
    private MovieManagerService service;

    @BeforeEach
    void setUp() {
        service = new MovieManagerService(new GenreRepository(), new MovieRepository());
    }

    @Test
    void permiteAnadirUnGenero() {
        service.addGenre("Acción");
        assertEquals(1, service.getAllGenres().size());
        assertEquals("Acción", service.getAllGenres().get(0).getName());
    }

    @Test
    void noPermiteAnadirDosVecesElMismoGenero() {
        service.addGenre("Comedia");
        assertThrows(IllegalArgumentException.class, () -> service.addGenre("comedia"));
    }

    @Test
    void permiteAnadirUnaPeliculaConUnGeneroExistente() {
        service.addGenre("Ciencia ficción");
        service.addMovie("Interstellar", 2014, "Ciencia ficción");

        assertEquals(1, service.getAllMovies().size());
        assertEquals("Interstellar", service.getAllMovies().get(0).getTitle());
    }

    @Test
    void noPermiteAnadirUnaPeliculaConUnGeneroInexistente() {
        assertThrows(IllegalArgumentException.class,
                () -> service.addMovie("Interstellar", 2014, "Ciencia ficción"));
    }

    @Test
    void buscaPeliculasPorGenero() {
        service.addGenre("Comedia");
        service.addGenre("Drama");
        service.addMovie("Película A", 2001, "Comedia");
        service.addMovie("Película B", 2002, "Drama");

        List<Movie> comedies = service.getMoviesByGenre("comedia");
        assertEquals(1, comedies.size());
        assertEquals("Película A", comedies.get(0).getTitle());
    }

    @Test
    void devuelveListasVaciasCuandoNoHayDatos() {
        assertTrue(service.getAllGenres().isEmpty());
        assertTrue(service.getAllMovies().isEmpty());
    }
}
