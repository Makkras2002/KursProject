package sample;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import static CheckersAndEts.CheckerAdmOrUs.isMenuingSignal;
import static CheckersAndEts.TransactionsDataInJson.methodMark;
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
    void initialize() {
        mMark.setText(methodMark);
        boolean signal = true;
        if(Float.parseFloat(methodMark) >= 7.0f){
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
