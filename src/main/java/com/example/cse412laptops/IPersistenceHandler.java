package com.example.cse412laptops;

import javafx.collections.ObservableList;

public interface IPersistenceHandler {

    public ObservableList<Laptop> getAllLaptop();

    public ObservableList<Laptop> specificQuery(String s);

}