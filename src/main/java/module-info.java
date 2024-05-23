module dev.cunning.fitnesstracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;


    opens dev.cunning.fitnesstracker to javafx.fxml;
    exports dev.cunning.fitnesstracker;
}