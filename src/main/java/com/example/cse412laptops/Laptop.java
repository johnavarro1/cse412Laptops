package com.example.cse412laptops;

import java.math.BigDecimal;

public class Laptop {
    private Integer mid;
    private String modelName;
    private String category;
    private String screenSize;
    private String Screen;
    private String cpu;

    @Override
    public String toString() {
        return
                "mid=" + mid +
                " " + modelName + '\'' +
                " " + category + '\'' +
                " " + screenSize + '\'' +
                " " + Screen + '\'' +
                " " + cpu + '\'' +
                " " + ram + '\'' +
                " " + storage + '\'' +
                " " + gpu + '\'' +
                " " + OsID + '\'' +
                " " + weight + '\'' +
                " " + price +
                " " + modelID;
    }

    private String ram;
    private String storage;
    private String gpu;
    private String OsID;
    private String weight;
    private BigDecimal price;
    private Integer modelID;



    public Laptop(Integer mid,String modelName, String category, String screenSize, String Screen, String cpu, String ram, String storage,
    String gpu, String OsID, String weight, BigDecimal price, Integer modelID ) {
        this.mid = mid;
        this.category = category;
        this.screenSize = screenSize;
        this.Screen = Screen;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.gpu = gpu;
        this.OsID = OsID;
        this.weight = weight;
        this.price = price;
        this.modelID = modelID;
        this.modelName = modelName;
    }


}