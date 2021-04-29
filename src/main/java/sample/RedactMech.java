package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


import static CheckersAndEts.CheckerAdmOrUs.isMenuingSignal;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;

public class RedactMech {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField IDMech;

    @FXML
    private TextField nameMech;

    @FXML
    private TextField category;

    @FXML
    private TextField price;

    @FXML
    private TextField sirname;

    @FXML
    private TextField name;

    @FXML
    private TextField buyer;

    @FXML
    private TextField amount;

    @FXML
    private Button addButton;

    @FXML
    private TextField day;

    @FXML
    private TextField month;

    @FXML
    private TextField year;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    void initialize() {
        ObservableList<String> choiceB = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");
        choiceBox.setItems(choiceB);
        addButton.setOnAction((event) -> {
            if(IDMech.getText().equals("") || IDMech.getText().length() > 5){
                errorCase();
            }
            else{
                if(((price.getText()).matches("-?([1-9][0-9]*)?")||price.getText().equals(""))&&((amount.getText()).matches("-?([1-9][0-9]*)?")||amount.getText().equals(""))
                        &&((day.getText()).matches("-?([1-9][0-9]*)?")||day.getText().equals(""))&&((month.getText()).matches("-?([1-9][0-9]*)?")||month.getText().equals(""))
                        &&((year.getText()).matches("-?([1-9][0-9]*)?")||year.getText().equals(""))&&(IDMech.getText()).matches("-?([1-9][0-9]*)?")){
                    boolean errSignal = true;
                    if(!price.getText().equals("")){
                        if(Integer.parseInt(price.getText())<1){
                            errSignal = false;
                            errorCase();
                        }
                    }
                    if(!day.getText().equals("")){
                        if(Integer.parseInt(day.getText())<1 ||Integer.parseInt(day.getText())>31
                                || month.getText().equals("") || year.getText().equals("")){
                            errSignal = false;
                            errorCase();
                        }
                    }
                    if(!month.getText().equals("")){
                        if(Integer.parseInt(month.getText())<1 ||Integer.parseInt(month.getText())>12
                                ||day.getText().equals("") || year.getText().equals("")){
                            errSignal = false;
                            errorCase();
                        }
                    }
                    if(!year.getText().equals("")){
                        if(Integer.parseInt(year.getText())<1970
                                ||day.getText().equals("") ||month.getText().equals("")){
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
                        &&((day.getText()).matches("-?([1-9][0-9]*)?")||day.getText().equals(""))&&((month.getText()).matches("-?([1-9][0-9]*)?")||month.getText().equals(""))
                        &&((year.getText()).matches("-?([1-9][0-9]*)?")||year.getText().equals(""))&&(IDMech.getText()).matches("-?([1-9][0-9]*)?"))) {
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
            Main.out.write(word +'\n');
            Main.out.flush();
            String serverWord = Main.in.readLine();
            System.out.println(serverWord);
            Main.out.write(IDMech.getText() +'\n');
            Main.out.flush();
            Main.out.write(nameMech.getText() +'\n');
            Main.out.flush();
            Main.out.write(category.getText() + '\n');
            Main.out.flush();
            Main.out.write(price.getText() + '\n');
            Main.out.flush();
            Main.out.write(sirname.getText() + '\n');
            Main.out.flush();
            Main.out.write(name.getText() + '\n');
            Main.out.flush();
            Main.out.write(buyer.getText() + '\n');
            Main.out.flush();
            Main.out.write(amount.getText() + '\n');
            Main.out.flush();
            Main.out.write(day.getText() +"."+month.getText() +"."+year.getText() + '\n');
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
}
