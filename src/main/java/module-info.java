module com.example.cse412laptops {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires postgresql;


    opens com.example.cse412laptops to javafx.fxml;
    exports com.example.cse412laptops;
}