package com.ejemplo.gestorpeliculas.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenreTest {
    @Test
    void guardaElNombreSinEspaciosAlPrincipioNiAlFinal() {
        Genre genre = new Genre("  Comedia  ");
        assertEquals("Comedia", genre.getName());
    }

    @Test
    void noPermiteUnNombreVacio() {
        assertThrows(IllegalArgumentException.class, () -> new Genre("  "));
    }

    @Test
    void comparaLosNombresSinDistinguirMayusculas() {
        assertEquals(new Genre("Drama"), new Genre("drama"));
    }
}
