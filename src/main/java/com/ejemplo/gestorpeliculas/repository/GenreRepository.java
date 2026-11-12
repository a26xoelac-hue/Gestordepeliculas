package com.ejemplo.gestorpeliculas.repository;

import com.ejemplo.gestorpeliculas.model.Genre;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/** Guarda los géneros en memoria y permite consultarlos por nombre. */
public class GenreRepository {
    private final Map<String, Genre> genres = new LinkedHashMap<>();

    public void add(Genre genre) {
        genres.put(key(genre.getName()), genre);
    }

    public Genre findByName(String name) {
        if (name == null) return null;
        return genres.get(key(name));
    }

    public List<Genre> findAll() {
        return new ArrayList<>(genres.values());
    }

    private String key(String name) {
        return name.trim().toLowerCase(Locale.ROOT);
    }
}
