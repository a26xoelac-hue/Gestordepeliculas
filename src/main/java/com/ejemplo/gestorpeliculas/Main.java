package com.ejemplo.gestorpeliculas;

import com.ejemplo.gestorpeliculas.repository.GenreRepository;
import com.ejemplo.gestorpeliculas.repository.MovieRepository;
import com.ejemplo.gestorpeliculas.service.MovieManagerService;
import com.ejemplo.gestorpeliculas.ui.ConsoleMenu;

import java.util.Scanner;

/** Inicia la aplicación y conecta sus componentes. */
public class Main {
    public static void main(String[] args) {
        GenreRepository genreRepository = new GenreRepository();
        MovieRepository movieRepository = new MovieRepository();
        MovieManagerService service = new MovieManagerService(genreRepository, movieRepository);

        try (Scanner scanner = new Scanner(System.in)) {
            new ConsoleMenu(scanner, service).start();
        }
    }
}
