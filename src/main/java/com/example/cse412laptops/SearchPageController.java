package com.example.cse412laptops;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;

import java.io.IOException;
import java.util.ArrayList;

public class SearchPageController {
    @FXML
    private RadioButton under500;

    @FXML
    private Label selectedLabel;

    @FXML
    private ListView<Laptop> laptopListView;

    @FXML
    private Button searchButton;
    @FXML
    public void searchBtnClick(ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        // test if radio button is selected
        if(under500.isSelected())
        {
            selectedLabel.setText("Display ALL laptops ");
            m.resultScene(persistenceHandler.getAllLaptop());
        }
        else
        {
            selectedLabel.setText("No selection");
        }

    }
    IPersistenceHandler persistenceHandler = dbHandler.getInstance();

    public void showALLLaptops(ActionEvent event)
    {
        laptopListView.getItems().addAll(persistenceHandler.getAllLaptop());
    }
}
