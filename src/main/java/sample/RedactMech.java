package sample;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.*;


import static CheckersAndEts.CheckerAdmOrUs.isMenuingSignal;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;

public class RedactMech {

    @FXML
    private TextField price;

    @FXML
    private TextField amount;

    @FXML
    private Button addButton;

    @FXML
    private DatePicker date;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TextField IDMech;

    @FXML
    private ComboBox<String> nameMech;

    @FXML
    private ComboBox<String> category;

    @FXML
    private ComboBox<String> sirname;

    @FXML
    private ComboBox<String> name;

    @FXML
    private ComboBox<String> buyer;

    @FXML
    private Button findToRedButton;

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
        findToRedButton.setOnAction((event)->{
            boolean isFound = false;
            for(SpareData data : dataSet){
                if(data.getData_id().toString().equals(IDMech.getText())){
                    price.setDisable(false);
                    amount.setDisable(false);
                    date.setDisable(false);
                    choiceBox.setDisable(false);
                    nameMech.setDisable(false);
                    category.setDisable(false);
                    sirname.setDisable(false);
                    name.setDisable(false);
                    buyer.setDisable(false);
                    price.setText(data.getPart().getPrice());
                    amount.setText(data.getAmount());
                    String[] dDate = data.getDate().split("\\.");
                    date.setValue(LocalDate.of(Integer.parseInt(dDate[2]),Integer.parseInt(dDate[1]),Integer.parseInt(dDate[0])));
                    nameMech.setValue(data.getPart().getName());
                    category.setValue(data.getPart().getCategory());
                    sirname.setValue(data.getSeller().getSirname());
                    name.setValue(data.getSeller().getName());
                    buyer.setValue(data.getBuyer().getBuyer_name());
                    choiceBox.setValue(data.getMark().getMark());
                    isFound =true;
                }
            }
            if(!isFound){
                price.setText("");
                price.setDisable(true);
                amount.setText("");
                amount.setDisable(true);
                date.setDisable(true);
                choiceBox.setValue("");
                choiceBox.setDisable(true);
                nameMech.setValue("");
                nameMech.setDisable(true);
                category.setValue("");
                category.setDisable(true);
                sirname.setValue("");
                sirname.setDisable(true);
                name.setValue("");
                name.setDisable(true);
                buyer.setValue("");
                buyer.setDisable(true);
            }
        });
        addButton.setOnAction((event) -> {
            if(IDMech.getText().equals("") || IDMech.getText().length() > 5){
                errorCase();
            }
            else{
                if(((price.getText()).matches("-?([1-9][0-9]*)?")||price.getText().equals(""))&&((amount.getText()).matches("-?([1-9][0-9]*)?")||amount.getText().equals(""))
                        &&(IDMech.getText()).matches("-?([1-9][0-9]*)?")){
                    boolean errSignal = true;
                    if(!price.getText().equals("")){
                        if(Integer.parseInt(price.getText())<1){
                            errSignal = false;
                            errorCase();
                        }
                    }
                    if(Integer.parseInt(IDMech.getText())<1){
                        errSignal = false;
                        errorCase();
                    }
                    if(errSignal){
                        if(isMenuingSignal()){
                            String finalRes = servMessagePattern();
                            if(finalRes.equals("No")){
                                errorCase();
                            }
                            else {
                                closeWindow(addButton);
                                buttonAction("/FXML/MainMenuAdm.fxml","ООО \"Грузовые детали0\"",600,644);
                            }
                        }
                        if(isMenuingSignal()==false){
                            String finalRes =servMessagePattern();
                            if(finalRes.equals("No")){
                                errorCase();
                            }
                            else {
                                closeWindow(addButton);
                                buttonAction("/FXML/MainMenuUser.fxml","ООО \"Грузовые детали0\"",600,644);
                            }
                        }
                    }


                }
                if(!(((price.getText()).matches("-?([1-9][0-9]*)?")||price.getText().equals(""))&&((amount.getText()).matches("-?([1-9][0-9]*)?")||amount.getText().equals(""))
                        &&(IDMech.getText()).matches("-?([1-9][0-9]*)?"))) {
                    errorCase();
                }
            }

        });
    }
    public void errorCase(){
        closeWindow(addButton);
        buttonAction("/FXML/DataEnterErrorInTheRepeatings.fxml","Ошибка",470, 188);
    }
    public String servMessagePattern() {
        String word = "RedactTransaction";
        String result = "No";
        try {
            String[] resData = new String[3];
            if(date.getValue() ==null){
                resData[0] ="";
                resData[1] ="";
                resData[2] ="";
            }else {
                resData =  date.getValue().toString().split("-");
            }
            Main.out.write(word +'\n');
            Main.out.flush();
            String serverWord = Main.in.readLine();
            System.out.println(serverWord);
            Main.out.write(IDMech.getText() +'\n');
            Main.out.flush();
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
            result = Main.in.readLine();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
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
