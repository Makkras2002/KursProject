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

public class AuthError {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AuthError;

    @FXML
    void initialize() {
        AuthError.setOnAction((event) -> {
            Stage stage1 = (Stage) AuthError.getScene().getWindow();
            stage1.close();
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("ООО \"Грузовые детали\"");
            stage.setScene(new Scene(root, 519, 531));
            stage.show();
        });
    }
}
