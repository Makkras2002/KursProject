package sample;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;

public class AuthError {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authError;

    @FXML
    void initialize() {
        authError.setOnAction((event) -> {
            closeWindow(authError);
            buttonAction("/FXML/sample.fxml","ООО \"Грузовые детали\"",519, 531);
        });
    }
}
