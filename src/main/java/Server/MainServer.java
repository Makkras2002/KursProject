package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.String;

public class MainServer {
    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;
    public static void main(String[] args){
        try {
            server = new ServerSocket(8088);
            System.out.println("Сервер запущен!");
            boolean sign;
            while (true){
                clientSocket = server.accept();
                System.out.println("Клиент подключился!");
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                sign = true;
                while(sign){
                    String word = in.readLine();
                    System.out.println(word);
                    switch (word){
                        case "addTransaction":{
                            out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                            out.flush();
                            String nameOfPart = in.readLine();
                            String category =in.readLine();
                            String price =in.readLine();
                            String sirname =in.readLine();
                            String name =in.readLine();
                            String buyer =in.readLine();
                            String amount =in.readLine();
                            String date =in.readLine();
                            System.out.println("________________");
                            System.out.println(nameOfPart);
                            System.out.println(category);
                            System.out.println(price);
                            System.out.println(sirname +" "+name);
                            System.out.println(buyer);
                            System.out.println(amount);
                            System.out.println(date);
                            System.out.println("________________");
                            break;
                        }
                        case "addAdmin":{
                            out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                            out.flush();
                            String login = in.readLine();
                            String password =in.readLine();
                            AuthorizationBaseController a1 =new AuthorizationBaseController();
                            a1.addAndSerialize(login,password,"AdminBase.dat");
                            break;
                        }
                        case "addUser":{
                            out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                            out.flush();
                            String login = in.readLine();
                            String password =in.readLine();
                            AuthorizationBaseController a1 =new AuthorizationBaseController();
                            a1.addAndSerialize(login,password,"UserBase.dat");
                            break;
                        }
                        case "checkAdminEnter":{
                            out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                            out.flush();
                            String login = in.readLine();
                            String password =in.readLine();
                            AuthorizationBaseController a1 = new AuthorizationBaseController();
                            if(a1.check(login,password,"AdminBase.dat")){
                                out.write("Yes" +"\n");
                                out.flush();
                            }
                            else {
                                out.write("No" +"\n");
                                out.flush();
                            }
                            break;
                        }
                        case "checkUserEnter":{
                            out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                            out.flush();
                            String login = in.readLine();
                            String password =in.readLine();
                            AuthorizationBaseController a1 = new AuthorizationBaseController();
                            if(a1.check(login,password,"UserBase.dat")){
                                out.write("Yes" +"\n");
                                out.flush();
                            }
                            else {
                                out.write("No" +"\n");
                                out.flush();
                            }
                            break;
                        }
                        case "deleteUser":{
                            out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                            out.flush();
                            String login = in.readLine();
                            String password =in.readLine();
                            AuthorizationBaseController a1 = new AuthorizationBaseController();
                            if(a1.deleteAdmin(login,password,"UserBase.dat")){
                                out.write("Yes" +"\n");
                                out.flush();
                            }
                            else {
                                out.write("No" +"\n");
                                out.flush();
                            }
                            break;
                        }
                        case "deleteAdmin":{
                            out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                            out.flush();
                            String login = in.readLine();
                            String password =in.readLine();
                            AuthorizationBaseController a1 = new AuthorizationBaseController();
                            if(a1.deleteAdmin(login,password,"AdminBase.dat")){
                                out.write("Yes" +"\n");
                                out.flush();
                            }
                            else {
                                out.write("No" +"\n");
                                out.flush();
                            }
                            break;
                        }
                        case "viewAdms":{
                            out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                            out.flush();
                            AuthorizationBaseController a1 = new AuthorizationBaseController();
                            String gsonFormatData = a1.ConvertToJson("AdminBase.dat");
                            out.write( gsonFormatData + "\n");
                            out.flush();
                            break;
                        }
                        case "viewUsers":{
                            out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                            out.flush();
                            AuthorizationBaseController a1 = new AuthorizationBaseController();
                            String gsonFormatData = a1.ConvertToJson("UserBase.dat");
                            out.write( gsonFormatData + "\n");
                            out.flush();
                            break;
                        }
                        case "exit":{
                            sign = false;
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                }
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
