package sample;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import Server.SpareData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static CheckersAndEts.CheckerOfString.compareLines;
import static CheckersAndEts.CheckerAdmOrUs.isMenuingSignal;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;

public class AddMech {

    @FXML
    private TextField amount;

    @FXML
    private Button addButton;

    @FXML
    private DatePicker date;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private ComboBox<String> nameMech;

    @FXML
    private ComboBox<String> category;

    @FXML
    private TextField price;

    @FXML
    private ComboBox<String> sirname;

    @FXML
    private ComboBox<String> name;

    @FXML
    private ComboBox<String> buyer;


    @FXML
    void initialize() {
        Set<SpareData> dataSet = getInfo();
        List<String> nameMechList = new ArrayList<>();
        List<String> categoryList = new ArrayList<>();
        List<String> sirnameList= new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        List<String> buyerList = new ArrayList<>();
        for(SpareData data : dataSet){
            if(!nameMechList.contains(data.getPart().getName())){
                nameMechList.add(data.getPart().getName());
            }
            if(!categoryList.contains(data.getPart().getCategory())){
                categoryList.add(data.getPart().getCategory());
            }
            if(!sirnameList.contains(data.getSeller().getSirname())){
                sirnameList.add(data.getSeller().getSirname());
            }
            if(!nameList.contains(data.getSeller().getName())){
                nameList.add(data.getSeller().getName());
            }
            if(!buyerList.contains(data.getBuyer().getBuyer_name())){
                buyerList.add(data.getBuyer().getBuyer_name());
            }
        }
        ObservableList<String> nameMechObsList = FXCollections.observableArrayList(nameMechList);
        ObservableList<String> categoryObsList = FXCollections.observableArrayList(categoryList);
        ObservableList<String> sirnameObsList = FXCollections.observableArrayList(sirnameList);
        ObservableList<String> nameObsList = FXCollections.observableArrayList(nameList);
        ObservableList<String> buyerObsList = FXCollections.observableArrayList(buyerList);
        nameMech.setItems(nameMechObsList);
        category.setItems(categoryObsList);
        sirname.setItems(sirnameObsList);
        name.setItems(nameObsList);
        buyer.setItems(buyerObsList);
        ObservableList<String> choiceB = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");
        choiceBox.setItems(choiceB);
        addButton.setOnAction((event) -> {
            if(name.getValue()==null||nameMech.getValue()==null||category.getValue()==null||compareLines(price.getText(),"")
                    ||sirname.getValue()==null||buyer.getValue()==null
                    ||compareLines(amount.getText(),"")||choiceBox.getValue()== null||date.getValue()==null){

                errorCase();
            }
            else{
                if((price.getText()).matches("-?([1-9][0-9]*)?")&&(amount.getText()).matches("-?([1-9][0-9]*)?")){
                    if(Integer.valueOf(price.getText())<1||Integer.valueOf(amount.getText())<1){
                        errorCase();
                    }
                    else {
                        if(isMenuingSignal()){
                            servMessagePattern();
                            closeWindow(addButton);
                            buttonAction("/FXML/MainMenuAdm.fxml","ООО \"Грузовые детали0\"",600,644);
                        }
                        if(isMenuingSignal()==false){
                            servMessagePattern();
                            closeWindow(addButton);
                            buttonAction("/FXML/MainMenuUser.fxml","ООО \"Грузовые детали0\"",600,644);
                        }

                    }

                }
                if(!((price.getText()).matches("-?([1-9][0-9]*)?")&&(amount.getText()).matches("-?([1-9][0-9]*)?"))) {
                    errorCase();
                }
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
    private void servMessagePattern() {
        String word = "addTransaction";
        try {
            String[] resData = new String[3];
            resData =  date.getValue().toString().split("-");
            Main.out.write(word +'\n');
            Main.out.flush();
            String serverWord = Main.in.readLine();
            System.out.println(serverWord);
            Main.out.write(nameMech.getValue() +'\n');
            Main.out.flush();
            Main.out.write(category.getValue() + '\n');
            Main.out.flush();
            Main.out.write(price.getText() + '\n');
            Main.out.flush();
            Main.out.write(sirname.getValue() + '\n');
            Main.out.flush();
            Main.out.write(name.getValue() + '\n');
            Main.out.flush();
            Main.out.write(buyer.getValue() + '\n');
            Main.out.flush();
            Main.out.write(amount.getText() + '\n');
            Main.out.flush();
            Main.out.write(resData[2] +"."+resData[1] +"."+resData[0] + '\n');
            Main.out.flush();
            Main.out.write(choiceBox.getValue() +'\n');
            Main.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
