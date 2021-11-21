package sample;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import Server.SpareData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import static CheckersAndEts.CheckerAdmOrUs.isMenuingSignal;
import static CheckersAndEts.TransactionsDataInJson.methodMark;
import static CheckersAndEts.TransactionsDataInJson.transactionsDataInGson;
import static sample.BaseButton.buttonAction;
import static sample.BaseButton.closeWindow;

public class Method {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button;

    @FXML
    private TextArea mMark;

    @FXML
    private TextArea conclusion;

    @FXML
    private PieChart sphereDiag;

    @FXML
    private PieChart satisfactionSphereDiag;

    @FXML
    void initialize() {
        DecimalFormat df = new DecimalFormat("#.##");
        mMark.setText(df.format(Double.parseDouble(methodMark)));
        boolean signal = true;
        Gson gson=new Gson();
        Type trDataInGsonType = new TypeToken<Set<SpareData>>(){}.getType();
        Set<SpareData> trData = gson.fromJson(transactionsDataInGson,trDataInGsonType);
        Map<String,Integer> pieChartDataMap = new HashMap<>();
        Map<String,Integer> satisfactionChartDataMap = new HashMap<>();
        for (SpareData o :trData){
            if(!pieChartDataMap.containsKey(o.getPart().getCategory())){
                pieChartDataMap.put(o.getPart().getCategory(),1);
            }else {
                int mapValue = pieChartDataMap.get(o.getPart().getCategory());
                pieChartDataMap.remove(o.getPart().getCategory());
                pieChartDataMap.put(o.getPart().getCategory(),++mapValue);
            }

            if(!satisfactionChartDataMap.containsKey("Satisfying")){
                satisfactionChartDataMap.put("Satisfying",1);
            }else if(!satisfactionChartDataMap.containsKey("Not Satisfying")){
                satisfactionChartDataMap.put("Not Satisfying",1);
            }else {
                int satisfactionValue;
                if(Integer.parseInt(o.getMark().getMark()) >= 6){
                    satisfactionValue = satisfactionChartDataMap.get("Satisfying");
                    satisfactionChartDataMap.remove("Satisfying");
                    satisfactionChartDataMap.put("Satisfying",++satisfactionValue);
                }else {
                    satisfactionValue = satisfactionChartDataMap.get("Not Satisfying");
                    satisfactionChartDataMap.remove("Not Satisfying");
                    satisfactionChartDataMap.put("Not Satisfying",++satisfactionValue);
                }
            }
        }
        for(String o : pieChartDataMap.keySet()){
            sphereDiag.getData().add(new PieChart.Data(o,pieChartDataMap.get(o)));
        }
        for(String o : satisfactionChartDataMap.keySet()){
            satisfactionSphereDiag.getData().add(new PieChart.Data(o,satisfactionChartDataMap.get(o)));
        }
        if(Float. parseFloat(methodMark) >= 7.0f){
            conclusion.setText("Средняя эффективность работы предприятия оценена как высокая. " +
                    "Дополнительные меры не требуются.");
            signal = true;
        }
        else {
            conclusion.setText("Эффективность работы предприятия не удовлетвлетворительна. " +
                    "Требуются дополнительные меры для оптимизации работы предприятия.");
            signal = false;
        }
        try {
            FileWriter report = new FileWriter("C:/foulder1.1/report.txt");
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
            report.write("Дата выдачи отчёта: "+ formatForDateNow.format(dateNow)+"\nУровень удовлетворённости " +
                    "клиентов работой оптового магазина - "+ methodMark+".\n");
            if(signal){
                report.write("Вывод: Магазин эффективно и качественно работает с покупателями и проводит сделки.\n" +
                        "Оптимизация не требуется.");
            }else {
                report.write("Вывод: Магазин не достаточно эффективно  работает с покупателями и проводит сделки.\n" +
                        "Требуется оптимизация для увеличения уровня эффективности работы магазина.");
            }
            report.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        button.setOnAction((event) -> {
            closeWindow(button);
            if(isMenuingSignal()){
                buttonAction("/FXML/MainMenuAdm.fxml","ООО \"Грузовые детали\"",600, 644);
            }
            if(isMenuingSignal() ==false){
                buttonAction("/FXML/MainMenuUser.fxml","ООО \"Грузовые детали\"",600, 644);
            }
        });
    }
}
