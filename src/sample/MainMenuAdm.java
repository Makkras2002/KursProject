package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static CheckersAndEts.CheckerAdmOrUs.setAddingSignalSignal;
import static CheckersAndEts.CheckerAdmOrUs.setMenuingSignal;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;


public class MainMenuAdm {

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
    private Button addUser;

    @FXML
    private Button addAdmin;

    @FXML
    private Button delUser;

    @FXML
    private Button delAdmin;

    @FXML
    private Button exit;

    @FXML
    private Button viewAdms;

    @FXML
    private Button viewUsers;

    public static String userDataInGson;

    @FXML
    void initialize() {
        addInfo.setOnAction((event) -> {
            setMenuingSignal(true);
            closeWindow(addInfo);
            buttonAction("AddMech.fxml","Добавление данных о заключенной сделке",427, 570);
        });
        delInfo.setOnAction((event) -> {
            setMenuingSignal(true);
            closeWindow(delInfo);
            buttonAction("DelMech.fxml","Удаление данных о заключенной сделке",427, 570);
        });
        addAdmin.setOnAction((event) -> {
            setAddingSignalSignal(true);
            closeWindow(addAdmin);
            buttonAction("AddAdm.fxml","Добавление администратора",342, 326);
        });
        addUser.setOnAction((event) -> {
            setAddingSignalSignal(false);
            closeWindow(addUser);
            buttonAction("AddAdm.fxml","Добавление пользователя",342, 326);
        });
        delAdmin.setOnAction((event) -> {
            setAddingSignalSignal(true);
            closeWindow(delAdmin);
            buttonAction("DelAdm.fxml","Удаление администратора",342, 326);
        });
        delUser.setOnAction((event) -> {
            setAddingSignalSignal(false);
            closeWindow(delUser);
            buttonAction("DelAdm.fxml","Удаление пользователя",342, 326);
        });
        viewAll.setOnAction((event) -> {
            setMenuingSignal(true);
            closeWindow(viewAll);
            buttonAction("Table.fxml","Данные",906, 660);
        });
        doMethod.setOnAction((event) -> {
            setMenuingSignal(true);
            closeWindow(doMethod);
            buttonAction("Method.fxml","Метод",525, 336);
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
        viewAdms.setOnAction((event) -> {
            closeWindow(viewAdms);
            String word = "viewAdms";
            try {
                Main.out.write(word +'\n');
                Main.out.flush();
                String serverWord = Main.in.readLine();
                System.out.println(serverWord);
                userDataInGson = Main.in.readLine();
                buttonAction("ViewAdms.fxml","Администраторы",511, 488);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        viewUsers.setOnAction((event) -> {
            closeWindow(viewAdms);
            buttonAction("ViewUsers.fxml","Пользователи",511, 488);
        });
    }
}
