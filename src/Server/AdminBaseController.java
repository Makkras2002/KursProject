package Server;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class AdminBaseController {
    private Set<UserData> baseOdAdmins = new HashSet<>();
    public void addAndSerialize(String login,String password){
        UserData newData = new UserData(login,password);
        deserialize();
        baseOdAdmins.add(newData);
        serialize();
    }
    public boolean check(String login,String password){
        UserData checkData = new UserData(login,password);
        deserialize();
        if(baseOdAdmins.contains(checkData)){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean deleteAdmin(String login,String password){
        UserData delData = new UserData(login,password);
        deserialize();
        if(baseOdAdmins.contains(delData)){
            baseOdAdmins.remove(delData);
            serialize();
            return true;
        }
        else {
            return false;
        }
    }
    public String ConvertToJson(){
        deserialize();
        Gson gson = new Gson();
        String gsonAdmSet = gson.toJson(baseOdAdmins);
        return gsonAdmSet;
    }
    private void deserialize(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("AdminBase.dat")))
        {
            baseOdAdmins=((HashSet<UserData>)ois.readObject());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    private void serialize(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("AdminBase.dat")))
        {
            oos.writeObject(baseOdAdmins);
            System.out.println("Данные записаны в файл!");
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
