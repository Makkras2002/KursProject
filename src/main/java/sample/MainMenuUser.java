package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static CheckersAndEts.CheckerAdmOrUs.setMenuingSignal;
import static CheckersAndEts.TransactionsDataInJson.methodMark;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;
import static CheckersAndEts.TransactionsDataInJson.transactionsDataInGson;


public class MainMenuUser {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addInfo;

    @FXML
    private Button delInfo;

    @FXML
    private Button viewAll;

    @FXML
    private Button doMethod;

    @FXML
    private Button redactInfo;

    @FXML
    private Button exit;


    @FXML
    void initialize() {
        addInfo.setOnAction((event) -> {
            setMenuingSignal(false);
            closeWindow(addInfo);
            buttonAction("/FXML/AddMech.fxml","Добавление данных о заключенной сделке",427, 620);
        });
        redactInfo.setOnAction((event) -> {
            setMenuingSignal(false);
            closeWindow(redactInfo);
            buttonAction("/FXML/RedactMech.fxml","Изменение данных о заключенной сделке",581, 620);
        });
        delInfo.setOnAction((event) -> {
            setMenuingSignal(false);
            closeWindow(delInfo);
            buttonAction("/FXML/DelMech.fxml","Удаление данных о заключенной сделке",427, 570);
        });
        viewAll.setOnAction((event) -> {
            setMenuingSignal(false);
            closeWindow(viewAll);
            String word = "tableView";
            try {
                Main.out.write(word +'\n');
                Main.out.flush();
                String serverWord = Main.in.readLine();
                System.out.println(serverWord);
                transactionsDataInGson = Main.in.readLine();
                buttonAction("/FXML/Table.fxml","Данные",1337, 700);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        doMethod.setOnAction((event) -> {
            setMenuingSignal(false);
            closeWindow(doMethod);
            String word = "doMethod";
            try {
                Main.out.write(word +'\n');
                Main.out.flush();
                String serverWord = Main.in.readLine();
                System.out.println(serverWord);
                methodMark = Main.in.readLine();
                transactionsDataInGson = Main.in.readLine();
                buttonAction("/FXML/Method.fxml","Метод",729, 719);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        exit.setOnAction((event) -> {
            String word = "exit";
            try {
                Main.out.write(word +'\n');
                Main.out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            closeWindow(exit);
        });
    }
}
