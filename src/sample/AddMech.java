package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static CheckersAndEts.CheckerOfString.compareLines;
import static CheckersAndEts.CheckerAdmOrUs.isMenuingSignal;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;

public class AddMech {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    void initialize() {
        addButton.setOnAction((event) -> {
            if(compareLines(name.getText(),"")||compareLines(nameMech.getText(),"")||compareLines(category.getText(),"")||compareLines(price.getText(),"")
                    ||compareLines(sirname.getText(),"")||compareLines(buyer.getText(),"")
                    ||compareLines(amount.getText(),"")||compareLines(day.getText(),"")
                    ||compareLines(month.getText(),"")||compareLines(year.getText(),"")){

                errorCase();
            }
            else{
                if((price.getText()).matches("-?([1-9][0-9]*)?")&&(amount.getText()).matches("-?([1-9][0-9]*)?")
                        &&(day.getText()).matches("-?([1-9][0-9]*)?")&&(month.getText()).matches("-?([1-9][0-9]*)?")
                        &&(year.getText()).matches("-?([1-9][0-9]*)?")){
                    if(Integer.valueOf(price.getText())<1||
                            Integer.valueOf(day.getText())<1||Integer.valueOf(day.getText())>31||Integer.valueOf(month.getText())<1||
                            Integer.valueOf(month.getText())>12 ||Integer.valueOf(year.getText())<1970||Integer.valueOf(amount.getText())<1){

                        errorCase();
                    }
                    else {
                        if(isMenuingSignal()){
                            servMessagePattern();
                            closeWindow(addButton);
                            buttonAction("MainMenuAdm.fxml","ООО \"Грузовые детали0\"",600,644);
                        }
                        if(isMenuingSignal()==false){
                            servMessagePattern();
                            closeWindow(addButton);
                            buttonAction("MainMenuUser.fxml","ООО \"Грузовые детали0\"",600,644);
                        }

                    }

                }
                if(!((price.getText()).matches("-?([1-9][0-9]*)?")&&(amount.getText()).matches("-?([1-9][0-9]*)?")
                        &&(day.getText()).matches("-?([1-9][0-9]*)?")&&(month.getText()).matches("-?([1-9][0-9]*)?")
                        &&(year.getText()).matches("-?([1-9][0-9]*)?"))) {
                    errorCase();
                }
            }

        });
    }
    public void errorCase(){
        closeWindow(addButton);
        buttonAction("DataEnterErrorInTheRepeatings.fxml","Ошибка",470, 188);
    }
    public void servMessagePattern() {
        String word = "addTransaction";
        try {
            Main.out.write(word +'\n');
            Main.out.flush();
            String serverWord = Main.in.readLine();
            System.out.println(serverWord);
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
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
