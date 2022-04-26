module com.example.pmvanwendung {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.pmvanwendung to javafx.fxml;
    exports com.example.pmvanwendung;
}