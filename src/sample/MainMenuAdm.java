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

import static CheckersAndEts.CheckerAdmOrUs.setAddingSignalSignal;
import static CheckersAndEts.CheckerAdmOrUs.setMenuingSignal;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;


public class MainMenuAdm {

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
    private Button AddUSBAdm;

    @FXML
    private Button AddADMBAdm;

    @FXML
    private Button DelUSBAdm;

    @FXML
    private Button DelAdmBAdm;

    @FXML
    private Button Exit;

    @FXML
    void initialize() {
        AddBAdm.setOnAction((event) -> {
            setMenuingSignal(true);
            closeWindow(AddBAdm);
            buttonAction("AddMech.fxml","Добавление данных о заключенной сделке",427, 570);
        });
        DelBAdm.setOnAction((event) -> {
            setMenuingSignal(true);
            closeWindow(DelBAdm);
            buttonAction("DelMech.fxml","Удаление данных о заключенной сделке",427, 570);
        });
        AddADMBAdm.setOnAction((event) -> {
            setAddingSignalSignal(true);
            closeWindow(AddADMBAdm);
            buttonAction("AddAdm.fxml","Добавление администратора",342, 326);
        });
        AddUSBAdm.setOnAction((event) -> {
            setAddingSignalSignal(false);
            closeWindow(AddUSBAdm);
            buttonAction("AddAdm.fxml","Добавление пользователя",342, 326);
        });
        DelAdmBAdm.setOnAction((event) -> {
            setAddingSignalSignal(true);
            closeWindow(DelAdmBAdm);
            buttonAction("DelAdm.fxml","Удаление администратора",342, 326);
        });
        DelUSBAdm.setOnAction((event) -> {
            setAddingSignalSignal(false);
            closeWindow(DelUSBAdm);
            buttonAction("DelAdm.fxml","Удаление пользователя",342, 326);
        });
        AllBAdm.setOnAction((event) -> {
            setMenuingSignal(true);
            closeWindow(AllBAdm);
            buttonAction("Table.fxml","Данные",906, 660);
        });
        MetodBAdm.setOnAction((event) -> {
            setMenuingSignal(true);
            closeWindow(MetodBAdm);
            buttonAction("Method.fxml","Метод",525, 336);
        });
        Exit.setOnAction((event) -> {
            Stage stage1 = (Stage) Exit.getScene().getWindow();
            stage1.close();
        });
    }
}
