package Server.DAO;

import Server.SpareData;
import org.springframework.beans.factory.annotation.Autowired;

public class SaveDataToRepo {
    @Autowired
    private SpareDataRepo repo;

    public void save(SpareData data){
        repo.save(data);
    }
}
