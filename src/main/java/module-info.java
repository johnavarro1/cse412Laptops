module com.example.cse412laptops {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cse412laptops to javafx.fxml;
    exports com.example.cse412laptops;
}