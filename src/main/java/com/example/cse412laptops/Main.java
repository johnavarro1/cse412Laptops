package com.example.cse412laptops;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import java.io.IOException;

public class Main extends Application {

    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("search-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("Welcome");
        stage.setScene(scene);
        stage.show();
    }

    public void resultScene(ObservableList<Laptop> arr) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("results.fxml")));
        Parent pane = loader.load();
        stg.getScene().setRoot(pane);
        resultsController controller = loader.getController();
        controller.initialize(arr);
    }
    public void searchScene() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("search-page.fxml")));
        Parent pane = loader.load();
        stg.getScene().setRoot(pane);
        SearchPageController controller = loader.getController();

    }
    public static void main(String[] args) {
        launch();
    }
}