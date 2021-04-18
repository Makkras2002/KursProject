package Server.DAO;

import Server.SpareData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpareDataRepo extends CrudRepository<SpareData, Integer> {
}
