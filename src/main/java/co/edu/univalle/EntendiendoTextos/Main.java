package co.edu.univalle.EntendiendoTextos;

import co.edu.univalle.EntendiendoTextos.controlador.Controlador;
import co.edu.univalle.EntendiendoTextos.modelo.Repositorio;
import co.edu.univalle.EntendiendoTextos.vista.Vista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start (Stage stage){
        Vista vista = new Vista();
        Repositorio repositorio = new Repositorio("record.txt");
        new Controlador(vista,repositorio);

        stage.setTitle("Record del jugador");
        stage.setScene(new Scene(vista,380,220));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}