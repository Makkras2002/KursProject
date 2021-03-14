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
            Stage stage1 = (Stage) enterAsAdmin.getScene().getWindow();
            stage1.close();
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("LoginAdm.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("Авторизация");
            stage.setScene(new Scene(root, 306, 323));
            stage.show();
        });
        enterAsUser.setOnAction((event) -> {
            setSignal(false);
            Stage stage1 = (Stage) enterAsUser.getScene().getWindow();
            stage1.close();
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("LoginAdm.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("Авторизация");
            stage.setScene(new Scene(root, 306, 323));
            stage.show();
        });
    }
}


