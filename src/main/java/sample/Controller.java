package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
            buttonAction("/FXML/LoginAdm.fxml","Авторизация",306, 323);
        });
        enterAsUser.setOnAction((event) -> {
            setSignal(false);
            closeWindow(enterAsUser);
            buttonAction("/FXML/LoginAdm.fxml","Авторизация",306, 323);
        });
    }
}


