package com.example.cse412laptops;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class resultsController {
    IPersistenceHandler persistenceHandler = dbHandler.getInstance();
    private List<Laptop> list;
    public void initialize(List Arr)
    {
        list = Arr;
        setList();
    }
    @FXML
    private ListView<Laptop> laptopListView;

    private Button backBtn;

    @FXML
    private TableView<?> resultsTable;

    public void backToHome(ActionEvent event)
    {
        laptopListView.getItems().clear();
    }
    public void setList()
    {
        laptopListView.getItems().addAll(list);
    }

}
