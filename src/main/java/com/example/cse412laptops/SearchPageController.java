package com.example.cse412laptops;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;

public class SearchPageController {
    @FXML
    private RadioButton under500;
    private CheckBox Lenovo;

    @FXML
    private CheckBox apple;

    @FXML
    private CheckBox chromeOS;

    private CheckBox otherManufacturer;
    @FXML
    private CheckBox dell;
    private CheckBox otherOS;
    @FXML
    private RadioButton over2000;

    @FXML
    private RadioButton range1000_1500;

    @FXML
    private RadioButton range1500_2000;

    @FXML
    private RadioButton range500_1000;
    

    @FXML
    private CheckBox windows;
    @FXML
    private CheckBox linux;

    @FXML
    private CheckBox macOS;

    @FXML
    private CheckBox microsoft;
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
            //selectedLabel.setText("Display ALL laptops ");
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
