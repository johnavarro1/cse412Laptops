package com.example.cse412laptops;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class SearchPageController {
    @FXML
    private RadioButton under500;

    @FXML
    private Label selectedLabel;

    @FXML
    public void searchBtnClick(ActionEvent actionEvent) {

        // test if radio button is selected
        if(under500.isSelected())
        {
            selectedLabel.setText("Display laptops under $500");
        }
        else
        {
            selectedLabel.setText("No selection");
        }

    }
}
