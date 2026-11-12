package co.edu.univalle.EntendiendoTextos.controlador;

import co.edu.univalle.EntendiendoTextos.modelo.Jugador;
import co.edu.univalle.EntendiendoTextos.modelo.Repositorio;
import co.edu.univalle.EntendiendoTextos.vista.Vista;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Controlador{
    private final Vista vista;
    private final Repositorio repositorio;

    public Controlador (Vista vista, Repositorio repositorio){
        this.vista = vista;
        this.repositorio = repositorio;

        vista.getBtnGuardar().setOnAction(e -> guardar());
        vista.getBtnCargar().setOnAction(e -> cargar());
    }

    private void guardar(){
        String nombre = vista.getTxtNombre().getText().trim();
        String puntajeTexto = vista.getTxtPuntaje().getText().trim();

        if(nombre.isEmpty()){
            vista.mostrarMensaje("El nombre no puede estar vacio.", true);
            return;
        }
        if(puntajeTexto.isEmpty()){
            vista.mostrarMensaje("El puntaje no puede estar vacio.",true);
            return;
        }

        int puntaje;
        try{
            puntaje = Integer.parseInt(puntajeTexto);
        } catch (NumberFormatException ex){
            vista.mostrarMensaje("El puntaje debe ser un numero entero.",true);
            return;
        }
        if (puntaje < 0){
            vista.mostrarMensaje("El puntaje debe ser mayor o igual a cero.",true);
            return;
        }
        try {
            repositorio.guardar(new Jugador(nombre, puntaje));
            vista.mostrarMensaje("Datos guardados correctamente.",false);
        } catch (IOException ex){
            vista.mostrarMensaje("Error al guardar el archivo" + ex.getMessage(), true);
        }
    }
    private void cargar(){
        try{
            Jugador jugador = repositorio.cargar();
            vista.getTxtNombre().setText(jugador.getNombre());
            vista.getTxtPuntaje().setText(String.valueOf(jugador.getPuntaje()));
            vista.mostrarMensaje("Datos cargados correctamente.", false);
        } catch (FileNotFoundException ex){
            vista.mostrarMensaje("Aun no hay un registro guardado (no hay record.txt)", true);
        } catch (IOException ex){
            vista.mostrarMensaje("Error al leer el archivo: " + ex.getMessage(), true);
        }
    }
}