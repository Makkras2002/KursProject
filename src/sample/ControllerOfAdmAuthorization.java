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
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;

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
                    closeWindow(authorizationAdmButton);
                    buttonAction("MainMenuAdm.fxml","ООО \"Грузовые детали\"",600, 644);
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
                    closeWindow(authorizationAdmButton);
                    buttonAction("MainMenuUser.fxml","ООО \"Грузовые детали\"",600, 644);
                }
                else {
                    errorCase();
                }
            }
        });
    }
    public void errorCase(){
        closeWindow(authorizationAdmButton);
        buttonAction("AuthError.fxml","Ошибка авторизации",247, 188);
    }
}

