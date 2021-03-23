package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static CheckersAndEts.CheckerAdmOrUs.setMenuingSignal;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;


public class MainMenuUser {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addInfo;

    @FXML
    private Button delInfo;

    @FXML
    private Button viewAll;

    @FXML
    private Button doMethod;

    @FXML
    private Button exit;

    @FXML
    void initialize() {
        addInfo.setOnAction((event) -> {
            setMenuingSignal(false);
            closeWindow(addInfo);
            buttonAction("AddMech.fxml","Добавление данных о заключенной сделке",427, 570);
        });
        delInfo.setOnAction((event) -> {
            setMenuingSignal(false);
            closeWindow(delInfo);
            buttonAction("DelMech.fxml","Удаление данных о заключенной сделке",427, 570);
        });
        viewAll.setOnAction((event) -> {
            setMenuingSignal(false);
            closeWindow(viewAll);
            buttonAction("Table.fxml","Данные",906, 660);
        });
        doMethod.setOnAction((event) -> {
            setMenuingSignal(false);
            closeWindow(doMethod);
            buttonAction("Method.fxml","Метод",525, 336);
        });
        exit.setOnAction((event) -> {
            closeWindow(exit);
        });
    }
}
