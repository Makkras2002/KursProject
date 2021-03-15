package sample;

import java.awt.event.MouseEvent;
import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static CheckersAndEts.CheckerAdmOrUs.setSignal;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enterAsAdmin;

    @FXML
    private Button enterAsUser;

    @FXML
    void initialize() {
        enterAsAdmin.setOnAction((event) -> {
            setSignal(true);
            closeWindow(enterAsAdmin);
            buttonAction("LoginAdm.fxml","Авторизация",306, 323);
        });
        enterAsUser.setOnAction((event) -> {
            setSignal(false);
            closeWindow(enterAsUser);
            buttonAction("LoginAdm.fxml","Авторизация",306, 323);
        });
    }
}


