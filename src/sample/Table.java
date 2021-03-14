package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import static CheckersAndEts.CheckerAdmOrUs.isMenuingSignal;

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
    private Button TableButton;

    @FXML
    void initialize() {
        TableButton.setOnAction((event) -> {
            Stage stage1 = (Stage) TableButton.getScene().getWindow();
            stage1.close();
            Stage stage = new Stage();
            Parent root = null;
            if(isMenuingSignal()){
                try {
                    root = FXMLLoader.load(getClass().getResource("MainMenuAdm.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setTitle("Данные");
                stage.setScene(new Scene(root, 906, 660));
                stage.show();
            }
            if(isMenuingSignal() ==false){
                try {
                    root = FXMLLoader.load(getClass().getResource("MainMenuUser.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setTitle("Данные");
                stage.setScene(new Scene(root, 906, 660));
                stage.show();
            }
        });
    }
}
