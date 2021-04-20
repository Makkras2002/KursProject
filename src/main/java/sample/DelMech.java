package sample;


import java.io.IOException;
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
    private TextField idField;

    @FXML
    private Button addButton;


    @FXML
    void initialize() {
        addButton.setOnAction((event) -> {
            if(compareLines(name.getText(),"") ||compareLines(idField.getText(),"")){
                errorCase();
                return;
            }
            if(idField.getText().matches("-?([1-9][0-9]*)?")){
                if(Integer.valueOf(idField.getText())<1){
                    errorCase();
                }
                else {
                    String word = "deleteTransaction";
                    try {
                        Main.out.write(word + '\n');
                        Main.out.flush();
                        String serverWord = Main.in.readLine();
                        System.out.println(serverWord);
                        Main.out.write(name.getText() + '\n');
                        Main.out.flush();
                        Main.out.write(idField.getText() + '\n');
                        Main.out.flush();
                        closeWindow(addButton);
                        if(isMenuingSignal()){
                            buttonAction("/FXML/MainMenuAdm.fxml","ООО \"Грузовые детали\"",600, 644);
                        }
                        if(isMenuingSignal() == false){
                            buttonAction("/FXML/MainMenuUser.fxml","ООО \"Грузовые детали\"",600, 644);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
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

