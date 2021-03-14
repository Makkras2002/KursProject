package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static CheckersAndEts.CheckerOfString.compareLines;
import static CheckersAndEts.CheckerAdmOrUs.isSignal;

public class ControllerOfAdmAuthorization {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField passwordAdminTextField;

    @FXML
    private TextField loginAdminTextField;

    @FXML
    private Button authorizationAdmButton;

    @FXML
    void initialize() {
        authorizationAdmButton.setOnAction((event) -> {
            if(isSignal()){
                boolean sign1;
                boolean sign2;
                sign1 = compareLines(loginAdminTextField.getText(),"asd");
                sign2 = compareLines(passwordAdminTextField.getText(),"123");
                if(sign1 && sign2){
                    Stage stage1 = (Stage) authorizationAdmButton.getScene().getWindow();
                    stage1.close();
                    Stage stage = new Stage();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("MainMenuAdm.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stage.setTitle("ООО \"Грузовые детали\"");
                    stage.setScene(new Scene(root, 600, 644));
                    stage.show();
                }
                else {
                    errorCase();
                }
            }
            if(isSignal() == false){
                boolean sign1;
                boolean sign2;
                sign1 = compareLines(loginAdminTextField.getText(),"kekw");
                sign2 = compareLines(passwordAdminTextField.getText(),"101");
                if(sign1 && sign2){
                    Stage stage1 = (Stage) authorizationAdmButton.getScene().getWindow();
                    stage1.close();
                    Stage stage = new Stage();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("MainMenuUser.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stage.setTitle("ООО \"Грузовые детали\"");
                    stage.setScene(new Scene(root, 600, 644));
                    stage.show();
                }
                else {
                    errorCase();
                }
            }
        });
    }
    public void errorCase(){
        Stage stage1 = (Stage) authorizationAdmButton.getScene().getWindow();
        stage1.close();
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("AuthError.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Ошибка авторизации");
        stage.setScene(new Scene(root, 247, 188));
        stage.show();
    }
}

