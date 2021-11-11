package Server;

import Server.DAO.DataDao;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader in;
    private BufferedWriter out;
    public ClientHandler(Socket socket)
    {
        clientSocket = socket;
    }

    @Override
    public void run()
    {
        try {
            boolean sign;
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
                                new Seller(sirname,name),new Buyer(buyer),date,new Mark(mark));
                        DataDao dataDao = new DataDao();
                        dataDao.savaData(spareData);
                        break;
                    }
                    case "RedactTransaction":{
                        out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                        out.flush();
                        String id = in.readLine();
                        String nameOfPart = in.readLine();
                        String category =in.readLine();
                        String price =in.readLine();
                        String sirname =in.readLine();
                        String name =in.readLine();
                        String buyer =in.readLine();
                        String amount =in.readLine();
                        String date =in.readLine();
                        String mark =in.readLine();
                        List<SpareData> allData = new ArrayList<>();
                        SpareData dataToRedact =new SpareData();
                        dataToRedact.setData_id(-1);
                        DataDao dataDao = new DataDao();
                        allData = dataDao.getAll();
                        for(SpareData a :allData){
                            if(a.getData_id() == Integer.parseInt(id)){
                                dataToRedact = a;
                                break;
                            }
                        }
                        if(dataToRedact.getData_id() != -1){
                            if(!nameOfPart.equals("null")){
                                dataToRedact.getPart().setName(nameOfPart);
                            }
                            if(!category.equals("null")){
                                dataToRedact.getPart().setCategory(category);
                            }
                            if(!price.equals("")){
                                dataToRedact.getPart().setPrice(price);
                            }
                            if(!sirname.equals("null")){
                                dataToRedact.getSeller().setSirname(sirname);
                            }
                            if(!name.equals("null")){
                                dataToRedact.getSeller().setName(name);
                            }
                            if(!buyer.equals("null")){
                                dataToRedact.getBuyer().setBuyer_name(buyer);
                            }
                            if(!amount.equals("")){
                                dataToRedact.setAmount(amount);
                            }
                            if(!date.equals("..")){
                                dataToRedact.setDate(date);
                            }
                            if(!mark.equals("null")){
                                dataToRedact.getMark().setMark(mark);
                            }
                            dataDao.updateData(dataToRedact);
                            out.write("Yes"  + "\n");
                            out.flush();
                        }
                        else {
                            out.write("No"  + "\n");
                            out.flush();
                        }
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
                        String priceMin =in.readLine();
                        String price =in.readLine();
                        String sirname =in.readLine();
                        String buyer =in.readLine();
                        String date =in.readLine();
                        String mark =in.readLine();
                        if(price.equals("")){
                            price ="0";
                        }
                        if(priceMin.equals("")){
                            priceMin = "0";
                        }
                        DataDao baseInf = new DataDao();
                        List<SpareData> databaseInfoList;
                        databaseInfoList = baseInf.getAll();
                        List<SpareData> searchResultList = new ArrayList<>();
                        String s;
                        for(SpareData b : databaseInfoList){
                            if(((s = String.valueOf(b.getData_id())).equals(partId) ||partId.equals(""))&&((b.getPart().getName().contains(nameOfPart)&&nameOfPart.length()>1)||nameOfPart.equals(""))&&
                                    ((b.getPart().getCategory().contains(category)&&category.length()>1)||category.equals(""))&&
                                    (Integer.parseInt(b.getPart().getPrice())<=Integer.parseInt(price)||price.equals("0"))&&
                                    (Integer.parseInt(b.getPart().getPrice())>=Integer.parseInt(priceMin)||priceMin.equals("0"))&&
                                    ((b.getSeller().getSirname().contains(sirname)&&sirname.length()>1)||sirname.equals(""))&&
                                    ((b.getBuyer().getBuyer_name().contains(buyer)&&buyer.length()>1)||buyer.equals(""))&&
                                    (b.getDate().equals(date)||date.equals(""))&&(b.getMark().getMark().equals(mark)||mark.equals("")||mark.equals("-"))){
                                searchResultList.add(b);
                            }
                        }
                        Gson gson = new Gson();
                        String gsonFormatData = gson.toJson(searchResultList);
                        out.write( gsonFormatData + "\n");
                        out.flush();
                        break;
                    }
                    case "sortView":{
                        out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                        out.flush();
                        String param = in.readLine();
                        DataDao baseInf = new DataDao();
                        List<SpareData> databaseInfoList = new ArrayList<>();
                        databaseInfoList = baseInf.getAll();
                        sortDataArray(databaseInfoList,param);
                        Gson gson = new Gson();
                        String gsonFormatData = gson.toJson(databaseInfoList);
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
                    case "doMethod":{
                        out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                        out.flush();
                        Gson gson = new Gson();
                        DataDao baseInf = new DataDao();
                        List<SpareData> databaseInfoList = new ArrayList<>();
                        databaseInfoList = baseInf.getAll();
                        float tempCounter =0f;
                        float Sum = 0f;
                        for (SpareData a : databaseInfoList){
                            Sum+=Float.parseFloat(a.getMark().getMark());
                            tempCounter++;
                        }
//                            String result = String.format("%.2f",Sum/tempCounter);
                        String result = String.valueOf(Sum/tempCounter);
                        out.write(result  + "\n");
                        out.flush();
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
                        a1.addAndSerialize(login,password,"Files/AdminBase.dat");
                        break;
                    }
                    case "addUser":{
                        out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                        out.flush();
                        String login = in.readLine();
                        String password =in.readLine();
                        AuthorizationBaseController a1 =new AuthorizationBaseController();
                        a1.addAndSerialize(login,password,"Files/UserBase.dat");
                        break;
                    }
                    case "checkAdminEnter":{
                        out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                        out.flush();
                        String login = in.readLine();
                        String password =in.readLine();
                        AuthorizationBaseController a1 = new AuthorizationBaseController();
                        if(a1.check(login,password,"Files/AdminBase.dat")){
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
                        if(a1.check(login,password,"Files/UserBase.dat")){
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
                        if(a1.deleteAdmin(login,password,"Files/UserBase.dat")){
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
                        if(a1.deleteAdmin(login,password,"Files/AdminBase.dat")){
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
                        String gsonFormatData = a1.ConvertToJson("Files/AdminBase.dat");
                        out.write( gsonFormatData + "\n");
                        out.flush();
                        break;
                    }
                    case "viewUsers":{
                        out.write("Привет, это Сервер! Подтверждаю, вы выбрали : " + word + "\n");
                        out.flush();
                        AuthorizationBaseController a1 = new AuthorizationBaseController();
                        String gsonFormatData = a1.ConvertToJson("Files/UserBase.dat");
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static List<SpareData> sortDataArray(List<SpareData> data,String param){
        int i=0;
        boolean sign = true;
        SpareData temp1  = new SpareData();
        SpareData temp2 = new SpareData();
        while (sign){
            i = 0;
            sign = false;
            while (i<data.size()-1){
                if(param.equals("по ID")){
                    if(data.get(i).getData_id() >data.get(i+1).getData_id()){
                        temp1 = data.get(i);
                        temp2 = data.get(i+1);
                        data.set(i,temp2);
                        data.set(i+1,temp1);
                        sign = true;
                    }
                }else if (param.equals("по цене")){
                    if(Integer.parseInt(data.get(i).getPart().getPrice()) >Integer.parseInt(data.get(i+1).getPart().getPrice())){
                        temp1 = data.get(i);
                        temp2 = data.get(i+1);
                        data.set(i,temp2);
                        data.set(i+1,temp1);
                        sign = true;
                    }
                }else if (param.equals("по количеству")){
                    if(Integer.parseInt(data.get(i).getAmount()) >Integer.parseInt(data.get(i+1).getAmount())){
                        temp1 = data.get(i);
                        temp2 = data.get(i+1);
                        data.set(i,temp2);
                        data.set(i+1,temp1);
                        sign = true;
                    }
                }
                i++;
            }
        }
        return data;
    }
}
