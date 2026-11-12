package co.edu.univalle.EntendiendoTextos.modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RepositorioTest {

    @TempDir
    Path carpeta;

    private Repositorio repositorio() {
        return new Repositorio(carpeta.resolve("record.txt").toString());
    }

    @Test
    void guardaYRecuperaLosDatos() throws IOException {
        repositorio().guardar(new Jugador("Dayana Muñoz", 150));

        // Se crea un repositorio nuevo para simular cerrar y abrir la aplicación.
        Jugador recuperado = repositorio().cargar();
        assertEquals("Dayana Muñoz", recuperado.getNombre());
        assertEquals(150, recuperado.getPuntaje());
    }

    @Test
    void guardarReemplazaElRegistroAnterior() throws IOException {
        Repositorio repo = repositorio();
        repo.guardar(new Jugador("Ana", 10));
        repo.guardar(new Jugador("Luis", 99));

        Jugador recuperado = repo.cargar();
        assertEquals("Luis", recuperado.getNombre());
        assertEquals(99, recuperado.getPuntaje());
    }

    @Test
    void cargarSinArchivoLanzaFileNotFound() {
        assertThrows(FileNotFoundException.class, () -> repositorio().cargar());
    }

    @Test
    void cargarConPuntajeInvalidoLanzaIOException() throws IOException {
        Files.writeString(carpeta.resolve("record.txt"), "Ana\nabc\n");
        assertThrows(IOException.class, () -> repositorio().cargar());
    }

    @Test
    void cargarConArchivoIncompletoLanzaIOException() throws IOException {
        Files.writeString(carpeta.resolve("record.txt"), "Ana\n");
        assertThrows(IOException.class, () -> repositorio().cargar());
    }
}
