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

import static CheckersAndEts.CheckerOfString.compareLines;
import static CheckersAndEts.CheckerAdmOrUs.isMenuingSignal;

public class DelMech {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name;

    @FXML
    private Button addButton;

    @FXML
    private TextField day;

    @FXML
    private TextField month;

    @FXML
    private TextField year;

    @FXML
    void initialize() {
        addButton.setOnAction((event) -> {
            if(compareLines(name.getText(),"")||compareLines(day.getText(),"")
                    ||compareLines(month.getText(),"")||compareLines(year.getText(),"")){
                errorCase();
            }
            if((day.getText()).matches("-?([1-9][0-9]*)?")&&(month.getText()).matches("-?([1-9][0-9]*)?")
                    &&(year.getText()).matches("-?([1-9][0-9]*)?")){
                if(Integer.valueOf(day.getText())<1||Integer.valueOf(day.getText())>31||Integer.valueOf(month.getText())<1||
                        Integer.valueOf(month.getText())>12 ||Integer.valueOf(year.getText())<1970){

                    errorCase();
                }
                else {
                    Stage stage1 = (Stage) addButton.getScene().getWindow();
                    stage1.close();
                    Stage stage = new Stage();
                    Parent root = null;
                    if(isMenuingSignal()){
                        try {
                            root = FXMLLoader.load(getClass().getResource("MainMenuAdm.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        stage.setTitle("ООО \"Грузовые детали\"");
                        stage.setScene(new Scene(root, 600, 644));
                        stage.show();
                    }
                    if(isMenuingSignal() == false){
                        try {
                            root = FXMLLoader.load(getClass().getResource("MainMenuUser.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        stage.setTitle("ООО \"Грузовые детали\"");
                        stage.setScene(new Scene(root, 600, 644));
                        stage.show();
                    }
                }

            }
            else {
                errorCase();
            }
        });
    }
    public void errorCase(){
        Stage stage1 = (Stage) addButton.getScene().getWindow();
        stage1.close();
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("DataEnterErrorInTheRepeatings.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Ошибка");
        stage.setScene(new Scene(root, 470, 188));
        stage.show();
    }
}

