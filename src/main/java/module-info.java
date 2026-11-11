module co.edu.univalle.EntendiendoTexto {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.univalle.EntendiendoTexto to javafx.fxml;
    opens co.edu.univalle.EntendiendoTexto.modelo to org.junit.platform.commons;
    exports co.edu.univalle.EntendiendoTexto;
}