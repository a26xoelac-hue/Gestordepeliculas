# Gestor de películas

Aplicación de consola sencilla hecha con **Java 17 y Maven**. Permite añadir géneros, añadir películas, listar películas y géneros y buscar películas por género.

## Estructura

```text
gestor-peliculas/
├── src/
│   ├── main/java/com/ejemplo/gestorpeliculas/  # Código de la aplicación
│   └── test/java/com/ejemplo/gestorpeliculas/  # Pruebas JUnit 5
├── target/                                     # Maven coloca aquí los archivos compilados
├── pom.xml                                     # Configuración de Maven
└── README.md                                   # Este documento
```

> `target/` se crea y rellena automáticamente al compilar. No hace falta añadir archivos manualmente.

## Requisitos

- Java 17 o superior.
- Maven.

En Ubuntu/Linux puedes instalarlos con:

```bash
sudo apt update
sudo apt install default-jdk maven
```

## Ejecutar

Abre una terminal en la carpeta donde está `pom.xml` y ejecuta:

```bash
mvn clean package
java -jar target/gestor-peliculas-1.0.0.jar
```

## Ejecutar las pruebas

```bash
mvn test
```

## Subir a GitHub

1. Crea un repositorio vacío en https://github.com.
2. Abre una terminal en esta carpeta (la que contiene `pom.xml`).
3. Ejecuta, cambiando `TU-USUARIO` por tu usuario de GitHub:

```bash
git init
git add .
git commit -m "Primer commit: gestor de peliculas"
git branch -M main
git remote add origin https://github.com/TU-USUARIO/gestor-peliculas.git
git push -u origin main
```

## Clases principales

- `Main`: inicia el programa.
- `model/Genre`: representa un género.
- `model/Movie`: representa una película.
- `repository`: almacena películas y géneros en memoria.
- `service/MovieManagerService`: contiene las operaciones principales.
- `ui/ConsoleMenu`: muestra el menú de consola.

Los datos se guardan en memoria, por lo que se reinician al cerrar el programa.
