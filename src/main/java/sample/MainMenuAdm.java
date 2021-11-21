package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static CheckersAndEts.CheckerAdmOrUs.setAddingSignalSignal;
import static CheckersAndEts.CheckerAdmOrUs.setMenuingSignal;
import static CheckersAndEts.TransactionsDataInJson.methodMark;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;
import static CheckersAndEts.TransactionsDataInJson.transactionsDataInGson;


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

    @FXML
    private Button redactInfo;

    public static String userDataInGson;

    @FXML
    void initialize() {
        redactInfo.setOnAction((event) -> {
            setMenuingSignal(true);
            closeWindow(redactInfo);
            buttonAction("/FXML/RedactMech.fxml","Изменение данных о заключенной сделке",581, 620);
        });
        addInfo.setOnAction((event) -> {
            setMenuingSignal(true);
            closeWindow(addInfo);
            buttonAction("/FXML/AddMech.fxml","Добавление данных о заключенной сделке",427, 620);
        });
        delInfo.setOnAction((event) -> {
            setMenuingSignal(true);
            closeWindow(delInfo);
            buttonAction("/FXML/DelMech.fxml","Удаление данных о заключенной сделке",427, 570);
        });
        addAdmin.setOnAction((event) -> {
            setAddingSignalSignal(true);
            closeWindow(addAdmin);
            buttonAction("/FXML/AddAdm.fxml","Добавление администратора",342, 326);
        });
        addUser.setOnAction((event) -> {
            setAddingSignalSignal(false);
            closeWindow(addUser);
            buttonAction("/FXML/AddAdm.fxml","Добавление пользователя",342, 326);
        });
        delAdmin.setOnAction((event) -> {
            setAddingSignalSignal(true);
            closeWindow(delAdmin);
            buttonAction("/FXML/DelAdm.fxml","Удаление администратора",342, 326);
        });
        delUser.setOnAction((event) -> {
            setAddingSignalSignal(false);
            closeWindow(delUser);
            buttonAction("/FXML/DelAdm.fxml","Удаление пользователя",342, 326);
        });
        viewAll.setOnAction((event) -> {
            setMenuingSignal(true);
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
            setMenuingSignal(true);
            closeWindow(doMethod);
            String word = "doMethod";
            try {
                Main.out.write(word +'\n');
                Main.out.flush();
                String serverWord = Main.in.readLine();
                System.out.println(serverWord);
                methodMark = Main.in.readLine();
                transactionsDataInGson = Main.in.readLine();
                buttonAction("/FXML/Method.fxml","Метод",860, 773);
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
        viewAdms.setOnAction((event) -> {
            closeWindow(viewAdms);
            String word = "viewAdms";
            try {
                Main.out.write(word +'\n');
                Main.out.flush();
                String serverWord = Main.in.readLine();
                System.out.println(serverWord);
                userDataInGson = Main.in.readLine();
                buttonAction("/FXML/ViewAdms.fxml","Администраторы",511, 488);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        viewUsers.setOnAction((event) -> {
            closeWindow(viewAdms);
            String word = "viewUsers";
            try {
                Main.out.write(word +'\n');
                Main.out.flush();
                String serverWord = Main.in.readLine();
                System.out.println(serverWord);
                userDataInGson = Main.in.readLine();
                buttonAction("/FXML/ViewUsers.fxml","Пользователи",511, 488);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
