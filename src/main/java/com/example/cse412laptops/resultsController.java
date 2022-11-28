package com.example.cse412laptops;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;

public class resultsController {
    IPersistenceHandler persistenceHandler = dbHandler.getInstance();
    private ObservableList<Laptop> list;
    public void initialize(ObservableList<Laptop> Arr)
    {
        list = Arr;
        //setList();
    }
    @FXML
    private TableView<Laptop> laptopListView;
    @FXML
    private Button backBtn;
    @FXML
    private TableColumn<Laptop,String> Manufacture;
    @FXML
    private TableColumn<Laptop,String> Model;
    @FXML
    private TableColumn<Laptop,String> OS;
    @FXML
    private TableColumn<Laptop, BigDecimal> Price;
    @FXML
    private TableColumn<Laptop,String> RAM;
    @FXML
    private TableColumn<Laptop,String> Storage;

    public void backToHome(ActionEvent event)
    {
        laptopListView.getItems().clear();
    }
    @FXML
    public void initialize()
    {
        TableColumn Manufacture = new TableColumn("Manufacture");
        TableColumn Model = new TableColumn("Model");
        TableColumn OS = new TableColumn("OS");
        TableColumn Price = new TableColumn("Price");
        TableColumn RAM = new TableColumn("RAM");
        TableColumn Storage = new TableColumn("Storage");
        Manufacture.setCellValueFactory(new PropertyValueFactory<Laptop, String>("mid"));
        Model.setCellValueFactory(new PropertyValueFactory<Laptop, String>("modelName"));
        OS.setCellValueFactory(new PropertyValueFactory<Laptop, String>("OsID"));
        Price.setCellValueFactory(new PropertyValueFactory<Laptop, String>("price"));
        RAM.setCellValueFactory(new PropertyValueFactory<Laptop, String>("ram"));
        Storage.setCellValueFactory(new PropertyValueFactory<Laptop, String>("storage"));
        laptopListView.setItems(list);

    }

}
