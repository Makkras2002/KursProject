package sample;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;

public class AuthError {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AuthError;

    @FXML
    void initialize() {
        AuthError.setOnAction((event) -> {
            closeWindow(AuthError);
            buttonAction("sample.fxml","ООО \"Грузовые детали\"",519, 531);
        });
    }
}
