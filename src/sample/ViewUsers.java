package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import static CheckersAndEts.CheckerAdmOrUs.isMenuingSignal;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;

public class ViewUsers {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> loginColomn;

    @FXML
    private TableColumn<?, ?> passwordColomn;


    @FXML
    void initialize() {
        button.setOnAction((event) -> {
            closeWindow(button);
            buttonAction("MainMenuAdm.fxml","ООО \"Грузовые детали\"",600, 644);
        });
    }
}
