package com.example.cse412laptops;



import javafx.collections.ObservableList;

import java.util.List;

public interface IPersistenceHandler {

    public List<Laptop> getAllLaptop();

    public ObservableList<Laptop> specificQuery(String s);

}