package co.edu.univalle.EntendiendoTextos.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**Esta clase mantiene al jugador en el archivo de texto, guardando en una linea el puntaje y en otra el nombre.*/

public class Repositorio {
    private final String ruta;

    public Repositorio(String ruta){
        this.ruta = ruta;
    }

    /**Guarda al jugador*/

    public void guardar (Jugador jugador) throws IOException {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta, StandardCharsets.UTF_8))) {
            escritor.write(jugador.getNombre());
            escritor.newLine();
            escritor.write(String.valueOf(jugador.getPuntaje()));
            escritor.newLine();
        }
    }

    /**Para leer al jugador que se guarda*/

    public Jugador cargar() throws IOException {
        try (BufferedReader lector = new BufferedReader(new FileReader(ruta, StandardCharsets.UTF_8))) {
            String nombre = lector.readLine();
            String puntajeTexto = lector.readLine();

            if (nombre == null || puntajeTexto == null) {
                throw new IOException("El archivo está incompleto.");
            }

            int puntaje;
            try {
                puntaje = Integer.parseInt(puntajeTexto.trim());
            } catch (NumberFormatException e) {
                throw new IOException("El puntaje guardado no es un número válido.");
            }
            if (puntaje < 0) {
                throw new IOException("El puntaje guardado es negativo.");
            }
            return new Jugador(nombre, puntaje);
        }
    }
}