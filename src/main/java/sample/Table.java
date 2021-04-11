package sample;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import Server.SparePartSaleData;
import Server.UserData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import static CheckersAndEts.CheckerAdmOrUs.isMenuingSignal;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;
import static CheckersAndEts.TransactionsDataInJson.transactionsDataInGson;

public class Table {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<SparePartSaleData> table;

    @FXML
    private TableColumn<SparePartSaleData, String> nameM;

    @FXML
    private TableColumn<SparePartSaleData, String> Category;

    @FXML
    private TableColumn<SparePartSaleData, String> Price;

    @FXML
    private TableColumn<SparePartSaleData, String> Amount;

    @FXML
    private TableColumn<SparePartSaleData, String> Sirname;

    @FXML
    private TableColumn<SparePartSaleData, String> Name;

    @FXML
    private TableColumn<SparePartSaleData, String> Buyer;

    @FXML
    private TableColumn<SparePartSaleData, String> Date;

    @FXML
    private Button tableButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField partNameSearchField;

    @FXML
    private TextField partCategorySearchField;

    @FXML
    private TextField partPriceSearchField;

    @FXML
    private TextField partSirnameSearchField;

    @FXML
    private TextField partBuyerSearchField;

    @FXML
    private TextField partDateSearchField;

    @FXML
    private Button refreshTableButton;

    @FXML
    void initialize() {
        Gson gson=new Gson();
        Type trDataInGsonType = new TypeToken<Set<SparePartSaleData>>(){}.getType();
        Set<SparePartSaleData> trData = gson.fromJson(transactionsDataInGson,trDataInGsonType);
        nameM.setCellValueFactory(new PropertyValueFactory<SparePartSaleData,String>("nameOfPart"));
        Category.setCellValueFactory(new PropertyValueFactory<SparePartSaleData,String>("category"));
        Price.setCellValueFactory(new PropertyValueFactory<SparePartSaleData,String>("price"));
        Amount.setCellValueFactory(new PropertyValueFactory<SparePartSaleData,String>("amount"));
        Sirname.setCellValueFactory(new PropertyValueFactory<SparePartSaleData,String>("sellerSirname"));
        Name.setCellValueFactory(new PropertyValueFactory<SparePartSaleData,String>("sellerName"));
        Buyer.setCellValueFactory(new PropertyValueFactory<SparePartSaleData,String>("buyer"));
        Date.setCellValueFactory(new PropertyValueFactory<SparePartSaleData,String>("date"));
        for(SparePartSaleData a: trData){
            table.getItems().add(a);
        }
        refreshTableButton.setOnAction((event)->{
            String word = "tableView";
            try {
                Main.out.write(word +'\n');
                Main.out.flush();
                String serverWord = Main.in.readLine();
                System.out.println(serverWord);
                String refreshedData;
                refreshedData = Main.in.readLine();
                Set<SparePartSaleData> trDataRefreshed = gson.fromJson(refreshedData,trDataInGsonType);
                clearTable();
                for(SparePartSaleData a: trDataRefreshed){
                    table.getItems().add(a);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        searchButton.setOnAction((event) ->{
            String word = "searchView";
            try {
                Main.out.write(word + '\n');
                Main.out.flush();
                String serverWord = Main.in.readLine();
                System.out.println(serverWord);
                Main.out.write(partNameSearchField.getText() + '\n');
                Main.out.flush();
                Main.out.write(partCategorySearchField.getText() + '\n');
                Main.out.flush();
                Main.out.write(partPriceSearchField.getText() + '\n');
                Main.out.flush();
                Main.out.write(partSirnameSearchField.getText() + '\n');
                Main.out.flush();
                Main.out.write(partBuyerSearchField.getText() + '\n');
                Main.out.flush();
                Main.out.write(partDateSearchField.getText() + '\n');
                Main.out.flush();
                String foundData;
                foundData = Main.in.readLine();
                Set<SparePartSaleData> trDataFound = gson.fromJson(foundData,trDataInGsonType);
                clearTable();
                for(SparePartSaleData a: trDataFound){
                    table.getItems().add(a);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        tableButton.setOnAction((event) -> {
            closeWindow(tableButton);
            if(isMenuingSignal()){
                buttonAction("/FXML/MainMenuAdm.fxml","ООО \"Грузовые детали\"",600, 644);
            }
            if(isMenuingSignal() ==false){
                buttonAction("/FXML/MainMenuUser.fxml","ООО \"Грузовые детали\"",600, 644);
            }
        });
    }
    void clearTable(){
        for ( int i = 0; i<table.getItems().size(); i++) {
            table.getItems().clear();
        }
    }
}
