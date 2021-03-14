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
            Stage stage1 = (Stage) AddBAdm.getScene().getWindow();
            stage1.close();
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("AddMech.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("Добавление данных о заклюенной сделке");
            stage.setScene(new Scene(root, 427, 570));
            stage.show();
        });
        DelBAdm.setOnAction((event) -> {
            setMenuingSignal(true);
            Stage stage1 = (Stage) DelBAdm.getScene().getWindow();
            stage1.close();
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("DelMech.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("Добавление данных о заклюенной сделке");
            stage.setScene(new Scene(root, 427, 570));
            stage.show();
        });
        AddADMBAdm.setOnAction((event) -> {
            setAddingSignalSignal(true);
            Stage stage1 = (Stage) AddADMBAdm.getScene().getWindow();
            stage1.close();
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("AddAdm.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("Добавление администратора");
            stage.setScene(new Scene(root, 342, 326));
            stage.show();
        });
        AddUSBAdm.setOnAction((event) -> {
            setAddingSignalSignal(false);
            Stage stage1 = (Stage) AddUSBAdm.getScene().getWindow();
            stage1.close();
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("AddAdm.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("Добавление пользователя");
            stage.setScene(new Scene(root, 342, 326));
            stage.show();
        });
        DelAdmBAdm.setOnAction((event) -> {
            setAddingSignalSignal(true);
            Stage stage1 = (Stage) DelAdmBAdm.getScene().getWindow();
            stage1.close();
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("DelAdm.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("Удаление администратора");
            stage.setScene(new Scene(root, 342, 326));
            stage.show();
        });
        DelUSBAdm.setOnAction((event) -> {
            setAddingSignalSignal(false);
            Stage stage1 = (Stage) DelUSBAdm.getScene().getWindow();
            stage1.close();
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("DelAdm.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("Удаление пользователя");
            stage.setScene(new Scene(root, 342, 326));
            stage.show();
        });
        AllBAdm.setOnAction((event) -> {
            setMenuingSignal(true);
            Stage stage1 = (Stage) AllBAdm.getScene().getWindow();
            stage1.close();
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Table.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("Данные");
            stage.setScene(new Scene(root, 906, 660));
            stage.show();
        });
        MetodBAdm.setOnAction((event) -> {
            setMenuingSignal(true);
            Stage stage1 = (Stage) MetodBAdm.getScene().getWindow();
            stage1.close();
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Method.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("Метод");
            stage.setScene(new Scene(root, 525, 336));
            stage.show();
        });
        Exit.setOnAction((event) -> {
            Stage stage1 = (Stage) Exit.getScene().getWindow();
            stage1.close();
        });
    }
}
