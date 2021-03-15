package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class BaseButton {
    public static void closeWindow(Button b1){
        Button addButton = b1;
        Stage stage1 = (Stage) addButton.getScene().getWindow();
        stage1.close();
    }
    public static void buttonAction(String fxmlPath,String title, double width, double height){
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(BaseButton.class.getResource(fxmlPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle(title);
        stage.setScene(new Scene(root, width, height));
        stage.show();
    }
}
