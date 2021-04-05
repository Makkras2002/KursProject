package Server;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class AuthorizationBaseController {
    private Set<UserData> baseOdAdmins = new HashSet<>();
    public void addAndSerialize(String login,String password,String file){
        UserData newData = new UserData(login,password);
        deserialize(file);
        baseOdAdmins.add(newData);
        serialize(file);
    }
    public boolean check(String login,String password,String file){
        UserData checkData = new UserData(login,password);
        deserialize(file);
        if(baseOdAdmins.contains(checkData)){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean deleteAdmin(String login,String password,String file){
        UserData delData = new UserData(login,password);
        deserialize(file);
        if(baseOdAdmins.contains(delData)){
            baseOdAdmins.remove(delData);
            serialize(file);
            return true;
        }
        else {
            return false;
        }
    }
    public String ConvertToJson(String file){
        deserialize(file);
        Gson gson = new Gson();
        String gsonAdmSet = gson.toJson(baseOdAdmins);
        return gsonAdmSet;
    }
    private void deserialize(String file){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
        {
            baseOdAdmins=((HashSet<UserData>)ois.readObject());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    private void serialize(String file){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)))
        {
            oos.writeObject(baseOdAdmins);
            System.out.println("Данные записаны в файл!");
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
