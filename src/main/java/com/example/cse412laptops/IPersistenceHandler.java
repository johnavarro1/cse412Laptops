package com.example.cse412laptops;



import java.util.List;

public interface IPersistenceHandler {

    public List<Laptop> getAllLaptop();

    public List<Laptop> specificQuery();

}