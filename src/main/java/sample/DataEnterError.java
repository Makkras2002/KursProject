package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;

public class DataEnterError {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button dataEnterError;

    @FXML
    void initialize() {
        dataEnterError.setOnAction((event) -> {
            closeWindow(dataEnterError);
            buttonAction("/FXML/MainMenuAdm.fxml","ООО \"Грузовые детали\"",600, 644);
        });
    }
}
