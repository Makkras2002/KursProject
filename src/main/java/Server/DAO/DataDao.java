package Server.DAO;

import Server.utils.HibernateUtil;
import Server.SpareData;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DataDao {
    public void savaData(SpareData spareData){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(spareData);
        transaction.commit();
        session.close();
    }
    public List<SpareData> getAll(){
        String hql = "from SpareData ";
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<SpareData> cars = session.createQuery(hql).getResultList();
        return cars;
    }
    public void deleteData(SpareData data){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(data);
        transaction.commit();
        session.close();
    }
}
