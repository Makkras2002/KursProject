package sample;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static CheckersAndEts.CheckerOfString.compareLines;
import static CheckersAndEts.CheckerAdmOrUs.isMenuingSignal;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;

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
                return;
            }
            if((day.getText()).matches("-?([1-9][0-9]*)?")&&(month.getText()).matches("-?([1-9][0-9]*)?")
                    &&(year.getText()).matches("-?([1-9][0-9]*)?")){
                if(Integer.valueOf(day.getText())<1||Integer.valueOf(day.getText())>31||Integer.valueOf(month.getText())<1||
                        Integer.valueOf(month.getText())>12 ||Integer.valueOf(year.getText())<1970){

                    errorCase();
                }
                else {
                    closeWindow(addButton);
                    if(isMenuingSignal()){
                        buttonAction("/FXML/MainMenuAdm.fxml","ООО \"Грузовые детали\"",600, 644);
                    }
                    if(isMenuingSignal() == false){
                        buttonAction("/FXML/MainMenuUser.fxml","ООО \"Грузовые детали\"",600, 644);
                    }
                }

            }
            else {
                errorCase();
            }
        });
    }
    public void errorCase(){
        closeWindow(addButton);
        buttonAction("/FXML/DataEnterErrorInTheRepeatings.fxml","Ошибка",470, 188);
    }
}

