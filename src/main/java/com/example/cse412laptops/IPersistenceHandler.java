package com.example.cse412laptops;



import java.util.List;

public interface IPersistenceHandler {

    public List<Laptop> getAllLaptop();
    public List<Laptop> getLaptopUnder500();
    public List<Laptop> getLaptopUnder1000();
    public List<Laptop> getLaptopApple();
    public List<Laptop> getLaptopWindow();
    public List<Laptop> getLaptopRam16();

}