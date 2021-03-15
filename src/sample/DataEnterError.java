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

public class DataEnterError {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button DataEnterError;

    @FXML
    void initialize() {
        DataEnterError.setOnAction((event) -> {
            closeWindow(DataEnterError);
            buttonAction("MainMenuAdm.fxml","ООО \"Грузовые детали\"",600, 644);
        });
    }
}
