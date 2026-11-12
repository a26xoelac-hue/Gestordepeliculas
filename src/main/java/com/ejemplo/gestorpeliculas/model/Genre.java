package com.ejemplo.gestorpeliculas.model;

import java.util.Locale;
import java.util.Objects;

/** Representa un género cinematográfico, por ejemplo, Acción o Comedia. */
public class Genre {
    private final String name;

    public Genre(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre del género no puede estar vacío.");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    // Dos géneros con el mismo nombre se consideran iguales, sin distinguir mayúsculas.
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Genre genre)) return false;
        return name.equalsIgnoreCase(genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(Locale.ROOT));
    }
}
