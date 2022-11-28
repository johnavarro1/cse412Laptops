package com.example.cse412laptops;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class dbHandler implements IPersistenceHandler {
    private static dbHandler instance;
    private String url = "localhost";
    private int port = 5432;
    private String databaseName = "412project";
    private String username = "postgres";
    private String password = "0401";
    private Connection connection = null;

    private dbHandler(){
        initializePostgresqlDatabase();
    }

    public static dbHandler getInstance(){
        if (instance == null) {
            instance = new dbHandler();
        }
        return instance;
    }

    private void initializePostgresqlDatabase() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection("jdbc:postgresql://" + url + ":" + port + "/" + databaseName, username, password);
            System.out.println("DB connected");
        } catch (SQLException | IllegalArgumentException ex) {
            ex.printStackTrace(System.err);
        } finally {
            if (connection == null) {
                System.exit(-1);
            }
        }
    }


    @Override
    public List<Laptop> getAllLaptop() {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM model");
            ResultSet sqlReturnValues = stmt.executeQuery();

            List<Laptop> returnValues = new ArrayList<>();

            while (sqlReturnValues.next()){
                returnValues.add(new Laptop(sqlReturnValues.getInt(1),sqlReturnValues.getString(2),
                        sqlReturnValues.getString(10),sqlReturnValues.getFloat(12),sqlReturnValues.getString(7),
                        sqlReturnValues.getString(8)));
            }
            return returnValues;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public ObservableList<Laptop> specificQuery(String s)
    {
        try {
            PreparedStatement stmt = connection.prepareStatement(s);
            ResultSet sqlReturnValues = stmt.executeQuery();

            ObservableList<Laptop> returnValues = FXCollections.observableArrayList();

            while (sqlReturnValues.next()){
                returnValues.add(new Laptop(sqlReturnValues.getInt(1),sqlReturnValues.getString(2),
                        sqlReturnValues.getString(10),sqlReturnValues.getFloat(12),sqlReturnValues.getString(7),
                        sqlReturnValues.getString(8)));
            }
            System.out.println(returnValues.size());
            return returnValues;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}