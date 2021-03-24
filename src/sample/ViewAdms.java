package sample;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import Server.UserData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
        Type userDataInGsonType = new TypeToken<Set<UserData>>(){}.getType();
        Set<UserData> admData = gson.fromJson(userDataInGson,userDataInGsonType);
        loginColomn.setCellValueFactory(new PropertyValueFactory<UserData,String>("login"));
        passwordColomn.setCellValueFactory(new PropertyValueFactory<UserData,String>("password"));
        for(UserData us : admData){
            table.getItems().add(us);
        }
        button.setOnAction((event) -> {
            closeWindow(button);
            buttonAction("MainMenuAdm.fxml","ООО \"Грузовые детали\"",600, 644);
        });
    }
}

