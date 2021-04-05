package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.*;
import java.net.Socket;

import static javafx.fxml.FXMLLoader.load;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = load(getClass().getResource("/FXML/sample.fxml"));
        primaryStage.setTitle("ООО \"Грузовые детали\"");
        primaryStage.getIcons().add(new Image("/PicturesIconsAndEts/icon.jpg"));
        primaryStage.setScene(new Scene(root, 519, 531));
        primaryStage.show();
    }
    public static Socket clientSocket;
    public static BufferedReader reader;
    public static BufferedReader in;
    public static BufferedWriter out;
    public static void main(String[] args) {
        try {
            try {
                clientSocket = new Socket("localhost", 8088);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                launch(args);
            } finally {
                System.out.println("Клиент был закрыт...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
