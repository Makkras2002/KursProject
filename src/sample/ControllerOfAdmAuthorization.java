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
                String word = "checkAdminEnter";
                String checkResult;
                checkResult = serverCommunicationPattern(word);
                if(checkResult.equals("Yes")){
                    closeWindow(authorizationAdmButton);
                    buttonAction("MainMenuAdm.fxml","ООО \"Грузовые детали\"",600, 644);
                }
                else {
                    errorCase();
                }
            }
            if(isSignal() == false){
                String word = "checkUserEnter";
                String checkResult;
                checkResult = serverCommunicationPattern(word);
                if(checkResult.equals("Yes")){
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
    private String serverCommunicationPattern(String word){
        String checkResult = "No";
        try {
            Main.out.write(word +'\n');
            Main.out.flush();
            String serverWord = Main.in.readLine();
            System.out.println(serverWord);
            Main.out.write(loginAdminTextField.getText() +'\n');
            Main.out.flush();
            Main.out.write(passwordAdminTextField.getText() + '\n');
            Main.out.flush();
            checkResult = Main.in.readLine();
            System.out.println(checkResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return checkResult;
    }
}

