package com.example.cse412laptops;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.math.BigDecimal;

public class Laptop {
    private SimpleIntegerProperty mid;
    private SimpleStringProperty modelName;
    private SimpleStringProperty ram;
    private SimpleStringProperty storage;
    private SimpleStringProperty OsID;
    private SimpleFloatProperty price;



    Laptop(Integer mid,String modelName, String category, String screenSize, String Screen, String cpu, String ram, String storage,
    String gpu, String OsID, String weight, Float price, Integer modelID )
    {
        this.mid = new SimpleIntegerProperty(mid);
        this.ram = new SimpleStringProperty(ram);
        this.storage = new SimpleStringProperty(storage);
        this.OsID = new SimpleStringProperty(OsID);
        this.price = new SimpleFloatProperty(price);
        this.modelName = new SimpleStringProperty(modelName);
    }
    public Integer getMid() {
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

    public Float getPrice() {
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