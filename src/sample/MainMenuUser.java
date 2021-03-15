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

import static CheckersAndEts.CheckerAdmOrUs.setMenuingSignal;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;


public class MainMenuUser {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddBAdm;

    @FXML
    private Button DelBAdm;

    @FXML
    private Button AllBAdm;

    @FXML
    private Button MetodBAdm;

    @FXML
    private Button Exit;

    @FXML
    void initialize() {
        AddBAdm.setOnAction((event) -> {
            setMenuingSignal(false);
            closeWindow(AddBAdm);
            buttonAction("AddMech.fxml","Добавление данных о заключенной сделке",427, 570);
        });
        DelBAdm.setOnAction((event) -> {
            setMenuingSignal(false);
            closeWindow(DelBAdm);
            buttonAction("DelMech.fxml","Удаление данных о заключенной сделке",427, 570);
        });
        AllBAdm.setOnAction((event) -> {
            setMenuingSignal(false);
            closeWindow(AllBAdm);
            buttonAction("Table.fxml","Данные",906, 660);
        });
        MetodBAdm.setOnAction((event) -> {
            setMenuingSignal(false);
            closeWindow(MetodBAdm);
            buttonAction("Method.fxml","Метод",525, 336);
        });
        Exit.setOnAction((event) -> {
            Stage stage1 = (Stage) Exit.getScene().getWindow();
            stage1.close();
        });
    }
}
