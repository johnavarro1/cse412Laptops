package com.example.cse412laptops;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.math.BigDecimal;

public class Laptop {
    private SimpleStringProperty mid;
    private SimpleStringProperty modelName;
    private SimpleStringProperty ram;
    private SimpleStringProperty storage;
    private SimpleStringProperty OsID;
    private SimpleStringProperty price;



    Laptop(Integer mid,String modelName,String OsID, Float price,String ram, String storage)
    {
        this.mid = new SimpleStringProperty(mid.toString());
        this.ram = new SimpleStringProperty(ram);
        this.storage = new SimpleStringProperty(storage);
        this.OsID = new SimpleStringProperty(OsID);
        this.price = new SimpleStringProperty(price.toString());
        this.modelName = new SimpleStringProperty(modelName);
    }
    public String getMid() {
        return mid.get();
    }

    public String getModelName() {
        return modelName.get();
    }

    public String getRam() {
        return ram.get();
    }

    public String getStorage() {
        return storage.get();
    }

    public String getOsID() {
        return OsID.get();
    }

    public String getPrice() {
        return price.get();
    }

    @Override
    public String toString() {
        return mid +
        " " + modelName + '\'' +
        " " + ram + '\'' +
        " " + storage + '\'' +

        " " + OsID + '\'' +

        " " + price;

    }


}