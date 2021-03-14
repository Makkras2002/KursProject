package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static CheckersAndEts.CheckerAdmOrUs.isAddingSignalSignal;
import static CheckersAndEts.CheckerOfString.compareLines;

public class DelAdm {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private Button addButton;

    @FXML
    void initialize() {
        addButton.setOnAction((event) -> {
            if(compareLines(login.getText(),"")||compareLines(password.getText(),"")){
                errorCase();
            }
            else {
                if(isAddingSignalSignal()){
                    Stage stage1 = (Stage) addButton.getScene().getWindow();
                    stage1.close();
                    Stage stage = new Stage();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("MainMenuAdm.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stage.setTitle("ООО \"Грузовые детали1\"");
                    stage.setScene(new Scene(root, 600, 644));
                    stage.show();
                }
                if(isAddingSignalSignal()==false){
                    Stage stage1 = (Stage) addButton.getScene().getWindow();
                    stage1.close();
                    Stage stage = new Stage();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("MainMenuAdm.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stage.setTitle("ООО \"Грузовые детали0\"");
                    stage.setScene(new Scene(root, 600, 644));
                    stage.show();
                }

            }
        });
    }
    public void errorCase(){
        Stage stage1 = (Stage) addButton.getScene().getWindow();
        stage1.close();
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("DataEnterError.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Ошибка");
        stage.setScene(new Scene(root, 470, 188));
        stage.show();
    }

}

