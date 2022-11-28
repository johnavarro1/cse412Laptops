package com.example.cse412laptops;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;

public class SearchPageController {
    @FXML
    private RadioButton under500;
    @FXML
    private CheckBox Lenovo;
    @FXML
    private CheckBox apple;
    @FXML
    private CheckBox chromeOS;
    @FXML
    private CheckBox otherManufacturer;
    @FXML
    private CheckBox dell;
    @FXML
    private CheckBox otherOS;
    @FXML
    private RadioButton over2000;

    @FXML
    private RadioButton range1000_1500;

    @FXML
    private RadioButton range1500_2000;

    @FXML
    private RadioButton range500_1000;


    @FXML
    private CheckBox windows;
    @FXML
    private CheckBox linux;

    @FXML
    private CheckBox macOS;

    @FXML
    private CheckBox microsoft;
    @FXML
    private Label selectedLabel;

    @FXML
    private ListView<Laptop> laptopListView;

    @FXML
    private Button searchButton;
    @FXML
    public void searchBtnClick(ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        String q = genQuery();

        m.resultScene(persistenceHandler.specificQuery(q));


    }
    IPersistenceHandler persistenceHandler = dbHandler.getInstance();

    public String genQuery()
    {
        String query = "SELECT DISTINCT * FROM model, os, manufacturer WHERE ";
        ArrayList<String> blocks = new ArrayList<String>(100);
        if(microsoft.isSelected() && apple.isSelected())
        {
            blocks.add("manufacturer.\"mID\" = model.mid");
            blocks.add( "manufacturer.\"Name\" in ('Microsoft','Apple')");
        }
        else if(microsoft.isSelected())
        {
            blocks.add("manufacturer.\"mID\" = model.mid");
            blocks.add("manufacturer.\"Name\" = 'Microsoft'");
        }

        else if(apple.isSelected())
        {
            blocks.add("manufacturer.\"mID\" = model.mid");
            blocks.add("manufacturer.\"Name\" = 'Apple'");
        }
        else if(Lenovo.isSelected())
        {
            blocks.add("manufacturer.\"mID\" = model.mid");
            blocks.add("manufacturer.\"Name\" = 'Lenovo'");
        }
        else if(dell.isSelected())
        {
            blocks.add("manufacturer.\"mID\" = model.mid");
            blocks.add("manufacturer.\"Name\" = 'dell'");
        }
        else if(otherManufacturer.isSelected())
        {
            blocks.add("manufacturer.\"mID\" = model.mid");
            blocks.add("manufacturer.\"Name\" not in ('Lenovo','Microsoft','Apple','dell')");
        }
        if(chromeOS.isSelected())
        {
            blocks.add("os.\"OSid\" = model.\"OSid\"");
            blocks.add("os.\"Name\" = 'Chrome OS'");
        }
        else if(windows.isSelected() && linux.isSelected())
        {
            blocks.add("os.\"OSid\" = model.\"OSid\"");
            blocks.add( "os.\"Name\" in ('Windows','Linux')");
        }
        else if(windows.isSelected() && macOS.isSelected())
        {
            blocks.add("os.\"OSid\" = model.\"OSid\"");
            blocks.add( "os.\"Name\" in ('Windows','Mac OS')");
        }
        else if(windows.isSelected() && macOS.isSelected() && linux.isSelected())
        {
            blocks.add("os.\"OSid\" = model.\"OSid\"");
            blocks.add( "os.\"Name\" in ('Windows','Mac OS', 'Linux)");
        }
        else if(linux.isSelected())
        {
            blocks.add("os.\"OSid\" = model.\"OSid\"");
            blocks.add("os.\"Name\" = 'Linux'");
        }
        else if(windows.isSelected())
        {
            blocks.add("os.\"OSid\" = model.\"OSid\"");
            blocks.add("os.\"Name\" = 'Windows'");
        }
        else if(macOS.isSelected())
        {
            blocks.add("os.\"OSid\" = model.\"OSid\"");
            blocks.add("os.\"Name\" = 'Mac OS'");
        }
        else if(otherOS.isSelected())
        {
            blocks.add("os.\"OSid\" = model.\"OSid\"");
            blocks.add("os.\"Name\" not in ('Linux','Windows','Mac OS','Chrome OS')");
        }
        if(under500.isSelected())
        {
            blocks.add("model.\"Price\" <= 500");
        }
        if(range500_1000.isSelected())
        {
            blocks.add("model.\"Price\" >= 500 AND model.\"Price\" <= 1000");
        }
        if(range1000_1500.isSelected())
        {
            blocks.add("model.\"Price\" >= 1000 AND model.\"Price\" <= 1500");
        }
        if(range1500_2000.isSelected())
        {
            blocks.add("model.\"Price\" >= 1500 AND model.\"Price\" <= 2000");
        }
        if(over2000.isSelected())
        {
            blocks.add("model.\"Price\" > 2000");
        }
        for(int i = 0; i < blocks.size(); i++)
        {
            if(i < blocks.size()-1)
            {
                query+= blocks.get(i);
                query += " AND ";
            }
            else
            {
                query+= blocks.get(i);
            }

        }
        System.out.println("Query generated: " + query);
        return query;
    }
    public void showALLLaptops(ActionEvent event)
    {
        laptopListView.getItems().addAll(persistenceHandler.getAllLaptop());
    }
}
