package sample;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import static CheckersAndEts.CheckerOfString.compareLines;
import static CheckersAndEts.CheckerAdmOrUs.isAddingSignalSignal;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;


public class AddAdm {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private Button addButton;



    @FXML
    void initialize() {
        addButton.setOnAction((event) -> {
            if(compareLines(login.getText(),"")||compareLines(password.getText(),"")){
                errorCase();
            }
            else {
                if(isAddingSignalSignal()){
                    String word = "addAdmin";
                    serverCommunicationMethod(word);
                    closeWindow(addButton);
                    buttonAction("/FXML/MainMenuAdm.fxml","ООО \"Грузовые детали1\"",600,644);
                }
                if(isAddingSignalSignal()==false){
                    String word = "addUser";
                    serverCommunicationMethod(word);
                    closeWindow(addButton);
                    buttonAction("/FXML/MainMenuAdm.fxml","ООО \"Грузовые детали0\"",600,644);
                }

            }
        });
    }

    private void serverCommunicationMethod(String word) {
        try {
            Main.out.write(word + '\n');
            Main.out.flush();
            String serverWord = Main.in.readLine();
            System.out.println(serverWord);
            Main.out.write(login.getText() + '\n');
            Main.out.flush();
            Main.out.write(password.getText() + '\n');
            Main.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void errorCase(){
        closeWindow(addButton);
        buttonAction("/FXML/DataEnterError.fxml","Ошибка",470,188);
    }
}
