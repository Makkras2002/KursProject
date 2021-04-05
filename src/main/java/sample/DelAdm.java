package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static CheckersAndEts.CheckerAdmOrUs.isAddingSignalSignal;
import static CheckersAndEts.CheckerOfString.compareLines;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;

public class DelAdm {

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
                    String word = "deleteAdmin";
                    serverCommunicationMethod(word);
                }
                if(isAddingSignalSignal()==false){
                    String word = "deleteUser";
                    serverCommunicationMethod(word);
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
            String delRes = Main.in.readLine();
            System.out.println(delRes);
            if (delRes.equals("No")) {
                errorCase();
            } else {
                closeWindow(addButton);
                buttonAction("/FXML/MainMenuAdm.fxml", "ООО \"Грузовые детали\"", 600, 644);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void errorCase(){
        closeWindow(addButton);
        buttonAction("/FXML/DataEnterError.fxml","Ошибка",470, 188);
    }

}

