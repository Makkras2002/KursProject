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

public class Table {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> nameM;

    @FXML
    private TableColumn<?, ?> Category;

    @FXML
    private TableColumn<?, ?> Price;

    @FXML
    private TableColumn<?, ?> Amount;

    @FXML
    private TableColumn<?, ?> Sirname;

    @FXML
    private TableColumn<?, ?> Name;

    @FXML
    private TableColumn<?, ?> Buyer;

    @FXML
    private TableColumn<?, ?> Date;

    @FXML
    private Button tableButton;

    @FXML
    void initialize() {
        tableButton.setOnAction((event) -> {
            closeWindow(tableButton);
            if(isMenuingSignal()){
                buttonAction("/FXML/MainMenuAdm.fxml","ООО \"Грузовые детали\"",600, 644);
            }
            if(isMenuingSignal() ==false){
                buttonAction("/FXML/MainMenuUser.fxml","ООО \"Грузовые детали\"",600, 644);
            }
        });
    }
}
