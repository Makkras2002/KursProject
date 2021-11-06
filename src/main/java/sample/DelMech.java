package sample;


import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import Server.SpareData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private ComboBox<String> name;

    @FXML
    private TextField idField;

    @FXML
    private Button addButton;


    @FXML
    void initialize() {
        Set<SpareData> dataSet = getInfo();
        List<String> nameMechList = new ArrayList<>();
        for(SpareData data : dataSet){
            if(!nameMechList.contains(data.getPart().getName())){
                nameMechList.add(data.getPart().getName());
            }
        }
        ObservableList<String> nameMechObsList = FXCollections.observableArrayList(nameMechList);
        name.setItems(nameMechObsList);
        addButton.setOnAction((event) -> {
            if(name.getValue()==null ||compareLines(idField.getText(),"")){
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
                        Main.out.write(name.getValue() + '\n');
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
    private void errorCase(){
        closeWindow(addButton);
        buttonAction("/FXML/DataEnterErrorInTheRepeatings.fxml","Ошибка",470, 188);
    }
    private Set<SpareData> getInfo(){
        Gson gson=new Gson();
        Type trDataInGsonType = new TypeToken<Set<SpareData>>(){}.getType();
        String word = "tableView";
        Set<SpareData> trData = null;
        try {
            Main.out.write(word +'\n');
            Main.out.flush();
            String serverWord = Main.in.readLine();
            System.out.println(serverWord);
            String dataInGson = Main.in.readLine();
            trData = gson.fromJson(dataInGson,trDataInGsonType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trData;
    }
}

