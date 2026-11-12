package com.ejemplo.gestorpeliculas.ui;

import com.ejemplo.gestorpeliculas.model.Genre;
import com.ejemplo.gestorpeliculas.model.Movie;
import com.ejemplo.gestorpeliculas.service.MovieManagerService;

import java.util.List;
import java.util.Scanner;

/** Menú de texto para utilizar el gestor desde la consola. */
public class ConsoleMenu {
    private final Scanner scanner;
    private final MovieManagerService service;

    public ConsoleMenu(Scanner scanner, MovieManagerService service) {
        this.scanner = scanner;
        this.service = service;
    }

    public void start() {
        boolean running = true;
        System.out.println("=== GESTOR DE PELÍCULAS ===");

        while (running) {
            printMenu();
            String option = scanner.nextLine().trim();

            switch (option) {
                case "1" -> addGenre();
                case "2" -> addMovie();
                case "3" -> showMovies(service.getAllMovies());
                case "4" -> showGenres();
                case "5" -> searchByGenre();
                case "0" -> {
                    running = false;
                    System.out.println("¡Hasta pronto!");
                }
                default -> System.out.println("Opción no válida. Elige una opción del menú.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n1. Añadir género");
        System.out.println("2. Añadir película");
        System.out.println("3. Ver todas las películas");
        System.out.println("4. Ver géneros");
        System.out.println("5. Buscar películas por género");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    private void addGenre() {
        System.out.print("Nombre del género: ");
        String name = scanner.nextLine();
        try {
            service.addGenre(name);
            System.out.println("Género añadido correctamente.");
        } catch (IllegalArgumentException exception) {
            System.out.println("No se pudo añadir: " + exception.getMessage());
        }
    }

    private void addMovie() {
        System.out.print("Título: ");
        String title = scanner.nextLine();
        int year = readYear();
        System.out.print("Género: ");
        String genre = scanner.nextLine();

        try {
            service.addMovie(title, year, genre);
            System.out.println("Película añadida correctamente.");
        } catch (IllegalArgumentException exception) {
            System.out.println("No se pudo añadir: " + exception.getMessage());
        }
    }

    private int readYear() {
        while (true) {
            System.out.print("Año de estreno: ");
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Escribe un año válido usando números.");
            }
        }
    }

    private void showGenres() {
        List<Genre> genres = service.getAllGenres();
        if (genres.isEmpty()) {
            System.out.println("Todavía no hay géneros.");
            return;
        }
        System.out.println("Géneros:");
        genres.forEach(genre -> System.out.println("- " + genre.getName()));
    }

    private void searchByGenre() {
        System.out.print("¿Qué género quieres buscar?: ");
        String genre = scanner.nextLine();
        showMovies(service.getMoviesByGenre(genre));
    }

    private void showMovies(List<Movie> movies) {
        if (movies.isEmpty()) {
            System.out.println("No hay películas para mostrar.");
            return;
        }
        System.out.println("Películas:");
        movies.forEach(movie -> System.out.println("- " + movie));
    }
}
