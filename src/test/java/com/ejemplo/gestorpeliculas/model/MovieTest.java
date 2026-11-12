package com.ejemplo.gestorpeliculas.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    @Test
    void creaUnaPeliculaConSusDatos() {
        Movie movie = new Movie("Titanic", 1997, new Genre("Drama"));
        assertEquals("Titanic", movie.getTitle());
        assertEquals(1997, movie.getYear());
        assertEquals("Drama", movie.getGenre().getName());
    }

    @Test
    void noPermiteUnTituloVacio() {
        assertThrows(IllegalArgumentException.class,
                () -> new Movie("", 2000, new Genre("Drama")));
    }

    @Test
    void noPermiteUnAnoFueraDelRango() {
        assertThrows(IllegalArgumentException.class,
                () -> new Movie("Película", 1800, new Genre("Drama")));
    }
}
