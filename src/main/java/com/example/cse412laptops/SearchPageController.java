package com.example.cse412laptops;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.ArrayList;

public class SearchPageController {

    // manufacturer checkboxes
    @FXML
    private CheckBox microsoft;

    @FXML
    private CheckBox Lenovo;

    @FXML
    private CheckBox apple;

    @FXML
    private CheckBox otherManufacturer;

    @FXML
    private CheckBox dell;

    // OS checkboxes
    @FXML
    private CheckBox windows;

    @FXML
    private CheckBox linux;

    @FXML
    private CheckBox macOS;

    @FXML
    private CheckBox chromeOS;

    @FXML
    private CheckBox otherOS;

    // price checkboxes
    @FXML
    private CheckBox under500;

    @FXML
    private CheckBox over2000;

    @FXML
    private CheckBox range1000_1500;

    @FXML
    private CheckBox range1500_2000;

    @FXML
    private CheckBox range500_1000;

    @FXML
    private Button searchButton;

    @FXML
    public void searchBtnClick(ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        String q = genQuery();

        // check for empty selection
        if(q.equals(""))
        {
            m.resultScene(persistenceHandler.getAllLaptop());
        }
        else
        {
            // get specific query results
            m.resultScene(persistenceHandler.specificQuery(q));
        }
    }

    IPersistenceHandler persistenceHandler = dbHandler.getInstance();

    public String genQuery()
    {
        String query = "SELECT DISTINCT * FROM model, os, manufacturer WHERE ";
        ArrayList<String> blocks = new ArrayList<String>(100);

        // create array for each category of selections
        ArrayList<String> manufacturerSelection = new ArrayList<String>(100);
        ArrayList<String> osSelection = new ArrayList<String>(100);
        ArrayList<String> priceSelection = new ArrayList<String>(100);

        // get all manufacturer selections
        if(microsoft.isSelected())
        {
            manufacturerSelection.add("manufacturer.\"mID\" = model.mid AND manufacturer.\"Name\" = 'Microsoft'");
        }

        if(apple.isSelected())
        {
            manufacturerSelection.add("manufacturer.\"mID\" = model.mid AND manufacturer.\"Name\" = 'Apple'");
        }

        if(Lenovo.isSelected())
        {
            manufacturerSelection.add("manufacturer.\"mID\" = model.mid AND manufacturer.\"Name\" = 'Lenovo'");
        }

        if(dell.isSelected())
        {
            manufacturerSelection.add("manufacturer.\"mID\" = model.mid AND manufacturer.\"Name\" = 'Dell'");
        }

        if(otherManufacturer.isSelected())
        {
            manufacturerSelection.add("manufacturer.\"mID\" = model.mid AND manufacturer.\"Name\" not in ('Lenovo','Microsoft','Apple','Dell')");
        }

        // get all OS selections
        if(chromeOS.isSelected())
        {
            osSelection.add("os.\"OSid\" = model.\"Osid\" AND os.\"Name\" = 'Chrome OS'");
        }

        if(linux.isSelected())
        {
            osSelection.add("os.\"OSid\" = model.\"Osid\" AND os.\"Name\" = 'Linux'");
        }

        if(windows.isSelected())
        {
            osSelection.add("os.\"OSid\" = model.\"Osid\" AND os.\"Name\" = 'Windows'");
        }

        if(macOS.isSelected())
        {
            osSelection.add("os.\"OSid\" = model.\"Osid\" AND os.\"Name\" = 'Mac OS'");
        }

        if(otherOS.isSelected())
        {
            osSelection.add("os.\"OSid\" = model.\"Osid\" AND os.\"Name\" not in ('Linux','Windows','Mac OS','Chrome OS')");
        }

        // get all price selections
        if(under500.isSelected())
        {
            priceSelection.add("model.\"Price\" <= 500");
        }

        if(range500_1000.isSelected())
        {
            priceSelection.add("model.\"Price\" >= 500 AND model.\"Price\" <= 1000");
        }

        if(range1000_1500.isSelected())
        {
            priceSelection.add("model.\"Price\" >= 1000 AND model.\"Price\" <= 1500");
        }

        if(range1500_2000.isSelected())
        {
            priceSelection.add("model.\"Price\" >= 1500 AND model.\"Price\" <= 2000");
        }

        if(over2000.isSelected())
        {
            priceSelection.add("model.\"Price\" > 2000");
        }

        // if no filter is selected, display all models
        if(!Lenovo.isSelected() && !apple.isSelected() && !chromeOS.isSelected() && !dell.isSelected() && !linux.isSelected() && !macOS.isSelected() && !microsoft.isSelected() && !otherManufacturer.isSelected() && !otherOS.isSelected() && !over2000.isSelected() && !range1000_1500.isSelected() && !range1500_2000.isSelected() && !range500_1000.isSelected() && !under500.isSelected() && !windows.isSelected())
        {
            return "";
        }

        // build string for all manufacturer selections
        String manufacturerQuery = "";
        if(manufacturerSelection.size() > 1)
        {
            // if there is more than one selection, add OR statements
            manufacturerQuery += "(";
            for(int i = 0; i < manufacturerSelection.size(); i++)
            {
                if(i < manufacturerSelection.size()-1)
                {
                    manufacturerQuery+= manufacturerSelection.get(i);
                    manufacturerQuery += " OR ";
                }
                else
                {
                    manufacturerQuery+= manufacturerSelection.get(i);
                    manufacturerQuery += ")";
                }
            }
        }
        else if(manufacturerSelection.size() == 1)
        {
            // for only one selection, add query
            manufacturerQuery += manufacturerSelection.get(0);
        }

        // build string for all OS selections
        String osQueryString = "";
        if(osSelection.size() > 1)
        {
            // if there is more than one selection, add OR statements
            osQueryString += "(";
            for(int i = 0; i < osSelection.size(); i++)
            {
                if(i < osSelection.size()-1)
                {
                    osQueryString+= osSelection.get(i);
                    osQueryString += " OR ";
                }
                else
                {
                    osQueryString+= osSelection.get(i);
                    osQueryString += ")";
                }
            }
        }
        else if (osSelection.size() == 1)
        {
            // for only one selection, add query
            osQueryString += osSelection.get(0);
        }

        // build string for all price selections
        String priceQuery = "";
        if(priceSelection.size() > 1)
        {
            // if there is more than one selection, add OR statements
            priceQuery += "(";
            for(int i = 0; i < priceSelection.size(); i++)
            {
                if(i < priceSelection.size()-1)
                {
                    priceQuery+= priceSelection.get(i);
                    priceQuery += " OR ";
                }
                else
                {
                    priceQuery+= priceSelection.get(i);
                    priceQuery += ")";
                }
            }
        }
        else if (priceSelection.size() == 1)
        {
            // for only one selection, add query
            priceQuery += priceSelection.get(0);
        }

        // if there is any manufacturer selection, add the string to the blocks add
        if(manufacturerQuery != "")
        {
            blocks.add(manufacturerQuery);
        }

        // if there is any OS selection, add the string to the blocks array
        if(osQueryString != "")
        {
            blocks.add(osQueryString);
        }

        // if there is any price selection, add the string to the blocks array
        if(priceQuery != "")
        {
            blocks.add(priceQuery);
        }

        // build the final query
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
}
