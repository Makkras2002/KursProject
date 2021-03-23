package sample;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import Server.UserData;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;
import static sample.MainMenuAdm.userDataInGson;

public class ViewAdms {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button;

    @FXML
    private TableView<UserData> table;

    @FXML
    private TableColumn<UserData,String> loginColomn;

    @FXML
    private TableColumn<UserData,String> passwordColomn;

    @FXML
    void initialize() {
        Gson gson=new Gson();
        System.out.println(userDataInGson);
        Set<UserData> admData = gson.fromJson(userDataInGson,Set.class);
        for(UserData us : admData){
            System.out.println("Login - " + us.getLogin() +"\n" +"Password - " + us.getPassword() +"\n"+"________");
        }
//        ObservableList<UserData> data = FXCollections.observableArrayList();

//        data = gson.fromJson(userDataInGson, data.getClass());
//        loginColomn.setCellValueFactory(new PropertyValueFactory<UserData,String>("login"));
//        passwordColomn.setCellValueFactory(new PropertyValueFactory<UserData,String>("password"));
//        table.setItems(data);
        button.setOnAction((event) -> {
            closeWindow(button);
            buttonAction("MainMenuAdm.fxml","ООО \"Грузовые детали\"",600, 644);
        });
    }
}

