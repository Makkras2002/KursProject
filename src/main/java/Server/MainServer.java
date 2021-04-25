package Server;

import Server.DAO.DataDao;
import com.google.gson.Gson;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;



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
                            String mark =in.readLine();
                            SpareData spareData = new SpareData(new SparePart(nameOfPart,category,price),amount,
                                    new Seller(sirname,name),buyer,date,mark);
                            DataDao dataDao = new DataDao();
                            dataDao.savaData(spareData);
                            break;
                        }
                        case "deleteTransaction":{
                            out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                            out.flush();
                            String name = in.readLine();
                            String id = in.readLine();
                            DataDao baseInf = new DataDao();
                            List<SpareData> databaseInfoList = new ArrayList<>();
                            databaseInfoList = baseInf.getAll();
                            SpareData dataToDelete = new SpareData();
                            String s;
                            for (SpareData a: databaseInfoList){
                                if(a.getPart().getName().equals(name)
                                        && (s = String.valueOf(a.getData_id())).equals(id)){
                                    dataToDelete = a;
                                    break;
                                }
                            }
                            baseInf.deleteData(dataToDelete);
                            break;
                        }
                        case "searchView":{
                            out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                            out.flush();
                            String partId = in.readLine();
                            String nameOfPart = in.readLine();
                            String category =in.readLine();
                            String price =in.readLine();
                            String sirname =in.readLine();
                            String buyer =in.readLine();
                            String date =in.readLine();
                            String mark =in.readLine();
                            DataDao baseInf = new DataDao();
                            List<SpareData> databaseInfoList;
                            databaseInfoList = baseInf.getAll();
                            List<SpareData> searchResultList = new ArrayList<>();
                            String s;
                            for(SpareData b : databaseInfoList){
                                if(((s = String.valueOf(b.getData_id())).equals(partId) ||partId.equals(""))&&((b.getPart().getName().contains(nameOfPart)&&nameOfPart.length()>1)||nameOfPart.equals(""))&&
                                        ((b.getPart().getCategory().contains(category)&&category.length()>1)||category.equals(""))&&
                                        (b.getPart().getPrice().equals(price)||price.equals(""))&&
                                        ((b.getSeller().getSirname().contains(sirname)&&sirname.length()>1)||sirname.equals(""))&&
                                        ((b.getBuyer().contains(buyer)&&buyer.length()>1)||buyer.equals(""))&&
                                        (b.getDate().equals(date)||date.equals(""))&&(b.getMark().equals(mark)||mark==null||mark.equals("-"))){
                                    searchResultList.add(b);
                                }
                            }
                            Gson gson = new Gson();
                            String gsonFormatData = gson.toJson(searchResultList);
                            out.write( gsonFormatData + "\n");
                            out.flush();
                            break;
                        }
                        case "tableView":{
                            out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                            out.flush();
                            DataDao baseInf = new DataDao();
                            List<SpareData> databaseInfoList = new ArrayList<>();
                            databaseInfoList = baseInf.getAll();
                            Gson gson = new Gson();
                            String gsonFormatData = gson.toJson(databaseInfoList);
                            out.write( gsonFormatData + "\n");
                            out.flush();
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
