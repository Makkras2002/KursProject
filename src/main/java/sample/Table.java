package sample;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import CheckersAndEts.CarcassForTabel;
import Server.SpareData;
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
    private TableView<CarcassForTabel> table;

    @FXML
    private TableColumn<CarcassForTabel,Integer> idColomn;

    @FXML
    private TableColumn<CarcassForTabel, String> nameM;

    @FXML
    private TableColumn<CarcassForTabel, String> Category;

    @FXML
    private TableColumn<CarcassForTabel, String> Price;

    @FXML
    private TableColumn<CarcassForTabel, String> Amount;

    @FXML
    private TableColumn<CarcassForTabel, String> Sirname;

    @FXML
    private TableColumn<CarcassForTabel, String> Name;

    @FXML
    private TableColumn<CarcassForTabel, String> Buyer;

    @FXML
    private TableColumn<CarcassForTabel, String> Date;

    @FXML
    private Button tableButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField partIdSearchField;

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
        Type trDataInGsonType = new TypeToken<Set<SpareData>>(){}.getType();
        Set<SpareData> trData = gson.fromJson(transactionsDataInGson,trDataInGsonType);
        Set<CarcassForTabel> viewSet = new HashSet<>();
        for(SpareData a: trData){
            viewSet.add(new CarcassForTabel((int) (long)a.getData_id(),a.getPart().getName(),a.getPart().getCategory(),
                    a.getPart().getPrice(),a.getAmount(),a.getSeller().getSirname(),
                    a.getSeller().getName(),a.getBuyer(),a.getDate()));
        }
        idColomn.setCellValueFactory(new PropertyValueFactory<CarcassForTabel,Integer>("id"));
        nameM.setCellValueFactory(new PropertyValueFactory<CarcassForTabel,String>("nameOfPart"));
        Category.setCellValueFactory(new PropertyValueFactory<CarcassForTabel,String>("category"));
        Price.setCellValueFactory(new PropertyValueFactory<CarcassForTabel,String>("price"));
        Amount.setCellValueFactory(new PropertyValueFactory<CarcassForTabel,String>("amount"));
        Sirname.setCellValueFactory(new PropertyValueFactory<CarcassForTabel,String>("sellerSirname"));
        Name.setCellValueFactory(new PropertyValueFactory<CarcassForTabel,String>("sellerName"));
        Buyer.setCellValueFactory(new PropertyValueFactory<CarcassForTabel,String>("buyer"));
        Date.setCellValueFactory(new PropertyValueFactory<CarcassForTabel,String>("date"));
        for(CarcassForTabel a: viewSet){
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
                Set<SpareData> trDataRefreshed = gson.fromJson(refreshedData,trDataInGsonType);
                clearTable();
                viewSet.clear();
                for(SpareData a: trDataRefreshed){
                    viewSet.add(new CarcassForTabel((int) (long)a.getData_id(),a.getPart().getName(),a.getPart().getCategory(),
                            a.getPart().getPrice(),a.getAmount(),a.getSeller().getSirname(),
                            a.getSeller().getName(),a.getBuyer(),a.getDate()));
                }
                for(CarcassForTabel a: viewSet){
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
                Main.out.write(partIdSearchField.getText() + '\n');
                Main.out.flush();
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
                Set<SpareData> trDataFound = gson.fromJson(foundData,trDataInGsonType);
                clearTable();
                viewSet.clear();
                for(SpareData a: trDataFound){
                    viewSet.add(new CarcassForTabel((int) (long)a.getData_id(),a.getPart().getName(),a.getPart().getCategory(),
                            a.getPart().getPrice(),a.getAmount(),a.getSeller().getSirname(),
                            a.getSeller().getName(),a.getBuyer(),a.getDate()));
                }
                for(CarcassForTabel a: viewSet){
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
