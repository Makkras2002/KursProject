package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static CheckersAndEts.CheckerAdmOrUs.isMenuingSignal;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;

public class Method {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button;

    @FXML
    void initialize() {
        button.setOnAction((event) -> {
            closeWindow(button);
            if(isMenuingSignal()){
                buttonAction("/FXML/MainMenuAdm.fxml","ООО \"Грузовые детали\"",600, 644);
            }
            if(isMenuingSignal() ==false){
                buttonAction("/FXML/MainMenuUser.fxml","ООО \"Грузовые детали\"",600, 644);
            }
        });
    }
}
