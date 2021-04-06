package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static CheckersAndEts.CheckerAdmOrUs.setMenuingSignal;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;


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
    private Button exit;

    @FXML
    void initialize() {
        addInfo.setOnAction((event) -> {
            setMenuingSignal(false);
            closeWindow(addInfo);
            buttonAction("/FXML/AddMech.fxml","Добавление данных о заключенной сделке",427, 570);
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
                buttonAction("/FXML/Table.fxml","Данные",906, 660);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        doMethod.setOnAction((event) -> {
            setMenuingSignal(false);
            closeWindow(doMethod);
            buttonAction("/FXML/Method.fxml","Метод",525, 336);
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
