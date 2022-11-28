package com.example.cse412laptops;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Laptop {
    private SimpleStringProperty mid;
    private SimpleStringProperty modelName;
    private SimpleStringProperty ram;
    private SimpleStringProperty storage;
    private SimpleStringProperty OsID;
    private SimpleStringProperty price;



    Laptop(Integer mid,String modelName,String OsID, Float price,String ram, String storage)
    {
        switch(mid)
        {
            case 1:
                this.mid = new SimpleStringProperty("Microsoft");
                break;
            case 2:
                this.mid = new SimpleStringProperty("Fujitsu");
                break;
            case 3:
                this.mid = new SimpleStringProperty("LG");
                break;
            case 4:
                this.mid = new SimpleStringProperty("Toshiba");
                break;
            case 5:
                this.mid = new SimpleStringProperty("HP");
                break;
            case 6:
                this.mid = new SimpleStringProperty("Huawei");
                break;
            case 7:
                this.mid = new SimpleStringProperty("Mediacom");
                break;
            case 8:
                this.mid = new SimpleStringProperty("Xiaomi");
                break;
            case 9:
                this.mid = new SimpleStringProperty("MSI");
                break;
            case 10:
                this.mid = new SimpleStringProperty("Razer");
                break;
            case 11:
                this.mid = new SimpleStringProperty("Asus");
                break;
            case 12:
                this.mid = new SimpleStringProperty("Samsung");
                break;
            case 13:
                this.mid = new SimpleStringProperty("Vero");
                break;
            case 14:
                this.mid = new SimpleStringProperty("Lenovo");
                break;
            case 15:
                this.mid = new SimpleStringProperty("Dell");
                break;
            case 16:
                this.mid = new SimpleStringProperty("Acer");
                break;
            case 17:
                this.mid = new SimpleStringProperty("Chuwi");
                break;
            case 18:
                this.mid = new SimpleStringProperty("Google");
                break;
            case 19:
                this.mid = new SimpleStringProperty("Apple");
                break;
        }
        if(OsID.equals("A"))
        {
            this.OsID = new SimpleStringProperty("Chrome OS");
        }
        else if(OsID.equals("B"))
        {
            this.OsID = new SimpleStringProperty("Linux");
        }
            else if(OsID.equals("C"))
        {
            this.OsID = new SimpleStringProperty("Windows");
        }
        else if(OsID.equals("D"))
        {
            this.OsID = new SimpleStringProperty("Android");
        }
        else if(OsID.equals("E") )
        {
            this.OsID = new SimpleStringProperty("MacOS");
        }
        else
        {
            this.OsID = new SimpleStringProperty("Other");
        }

        this.ram = new SimpleStringProperty(ram);
        this.storage = new SimpleStringProperty(storage);
        this.price = new SimpleStringProperty(String.format("%.2f",price));
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