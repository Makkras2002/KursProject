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

public class DataEnterError {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button DataEnterError;

    @FXML
    void initialize() {
        DataEnterError.setOnAction((event) -> {
            Stage stage1 = (Stage) DataEnterError.getScene().getWindow();
            stage1.close();
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("MainMenuAdm.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("ООО \"Грузовые детали\"");
            stage.setScene(new Scene(root, 600, 644));
            stage.show();
        });
    }
}
