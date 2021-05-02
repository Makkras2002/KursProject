package sample;

import java.net.URL;
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
        if(Float.parseFloat(methodMark) >= 7.0f){
            conclusion.setText("Средняя эффективность работы предприятия оценена как высокая. Дополнительные меры не требуются.");
        }
        else {
            conclusion.setText("Эффективность работы предприятия не удовлетвлетворительна. Требуются дополнительные меры для оптимизации работы предприятия.");
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
