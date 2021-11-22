package sample;

import Server.SpareData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import static CheckersAndEts.TransactionsDataInJson.methodMark;
import static CheckersAndEts.TransactionsDataInJson.transactionsDataInGson;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;

public class StatInRange {

    @FXML
    private Button showStatButton;

    @FXML
    private DatePicker startDiap;

    @FXML
    private DatePicker endDiap;

    @FXML
    void initialize(){
        showStatButton.setOnAction((event)->{
            boolean hasStart = true;
            boolean hasEnd = true;
            String[] startData = new String[3];
            String[] endData = new String[3];
            if(startDiap.getValue() == null){
                hasStart = false;
            }else {
                System.out.println(startDiap.getValue());
                startData =  startDiap.getValue().toString().split("-");
            }
            if(endDiap.getValue() ==null){
                hasEnd = false;
            }else {
                System.out.println(endDiap.getValue());
                endData =  endDiap.getValue().toString().split("-");
            }
            closeWindow(showStatButton);
            String word = "doMethod";
            try {
                Main.out.write(word +'\n');
                Main.out.flush();
                String serverWord = Main.in.readLine();
                System.out.println(serverWord);
                methodMark = Main.in.readLine();
                transactionsDataInGson = Main.in.readLine();
                Gson gson=new Gson();
                Type trDataInGsonType = new TypeToken<Set<SpareData>>(){}.getType();
                Set<SpareData> trData = gson.fromJson(transactionsDataInGson,trDataInGsonType);
                Set<SpareData> filteredDataSet = new HashSet<>();
                boolean legitToAdd;
                String[] dataFromSet = new String[3];
                for(SpareData data: trData){
                    legitToAdd = true;
                    dataFromSet = data.getDate().split("\\.");
                    if(hasStart){
                        if(Integer.parseInt(dataFromSet[2]) < Integer.parseInt(startData[0])){
                            legitToAdd =false;
                        }else if(Integer.parseInt(dataFromSet[2]) == Integer.parseInt(startData[0])){
                            if(Integer.parseInt(dataFromSet[1]) < Integer.parseInt(startData[1])){
                                legitToAdd =false;
                            }else if(Integer.parseInt(dataFromSet[1]) == Integer.parseInt(startData[1])){
                                if(Integer.parseInt(dataFromSet[0]) < Integer.parseInt(startData[2])){
                                    legitToAdd =false;
                                }
                            }
                        }
                    }
                    if(hasEnd){
                        if(Integer.parseInt(dataFromSet[2]) > Integer.parseInt(endData[0])){
                            legitToAdd =false;
                        }else if(Integer.parseInt(dataFromSet[2]) == Integer.parseInt(endData[0])){
                            if(Integer.parseInt(dataFromSet[1]) > Integer.parseInt(endData[1])){
                                legitToAdd =false;
                            }else if(Integer.parseInt(dataFromSet[1]) == Integer.parseInt(endData[1])){
                                if(Integer.parseInt(dataFromSet[0]) > Integer.parseInt(endData[2])){
                                    legitToAdd =false;
                                }
                            }
                        }
                    }
                    if(legitToAdd){
                        filteredDataSet.add(data);
                    }
                }
                if(filteredDataSet.size() == 0){
                    buttonAction("/FXML/DataEnterErrorInTheRepeatings.fxml","Ошибка",470, 188);
                }else {
                    methodMark ="";
                    double newMark = 0;
                    for(SpareData fData : filteredDataSet){
                        newMark+= Double.parseDouble(fData.getMark().getMark());
                    }
                    newMark/=filteredDataSet.size();
                    methodMark = Double.valueOf(newMark).toString();
                    transactionsDataInGson = gson.toJson(filteredDataSet);
                    buttonAction("/FXML/Method.fxml","Метод",860, 773);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

