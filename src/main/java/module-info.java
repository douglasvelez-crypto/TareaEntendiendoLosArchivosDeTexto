module co.edu.univalle.EntendiendoTextos {
    requires javafx.controls;

    exports co.edu.univalle.EntendiendoTextos;
    opens co.edu.univalle.EntendiendoTextos.modelo to org.junit.platform.commons;
}