package co.edu.univalle.EntendiendoTextos.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/** Este clase es solo para mostrar
 los elementos de la interfaz y conectarlos a los botones*/

public class Vista extends VBox{
    private final TextField txtNombre = new TextField();
    private final TextField txtPuntaje = new TextField();
    private final Button btnGuardar = new Button("Guardar");
    private final Button btnCargar = new Button("Cargar");
    private final Label lblMensaje = new Label();

    public Vista(){
        txtNombre.setPromptText("Nombre del jugador");
        txtPuntaje.setPromptText("Entero mayor o igual a 0");

        GridPane campos = new GridPane();
        campos.setHgap(10);
        campos.setVgap(10);
        campos.addRow(0, new Label("Nombre:"), txtNombre);
        campos.addRow(1, new Label("Puntaje:"), txtPuntaje);

        HBox botones = new HBox(10, btnGuardar, btnCargar);
        botones.setAlignment(Pos.CENTER);

        lblMensaje.setWrapText(true);

        setSpacing(15);
        setPadding(new Insets(20));
        getChildren().addAll(campos, botones, lblMensaje);
    }

    public TextField getTxtNombre(){
        return txtNombre;
    }

    public TextField getTxtPuntaje() {
        return txtPuntaje;
    }

    public Button getBtnGuardar() {
        return btnGuardar;
    }

    public Button getBtnCargar() {
        return btnCargar;
    }
    public void mostrarMensaje(String texto, boolean esError){
        lblMensaje.setStyle(esError ? "-fx-text-fill: red;" : "-fx-text-fill: green;");
        lblMensaje.setText(texto);
        lblMensaje.setText(texto);
    }
}