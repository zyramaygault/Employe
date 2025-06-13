module com.example.employee {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.employee to javafx.fxml;
    exports com.example.employee;
}