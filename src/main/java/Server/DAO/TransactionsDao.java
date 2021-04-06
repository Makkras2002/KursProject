package Server.DAO;

import Server.SparePartSaleData;
import Server.TransactionData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionsDao {
    private static final String URL = "jdbc:postgresql://localhost:5432/TransactionsDataBase";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "19091970Ig";
    private static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void addData(SparePartSaleData dataToSave){
        try {
            Statement statement= connection.createStatement();
            dataToSave.setId((int) (1+Math.random()*(10000)));
            String SQL ="INSERT INTO tr_table VALUES("+dataToSave.getId()+",'"+
                    dataToSave.getNameOfPart()+"','"+dataToSave.getCategory()+"','"+
                    dataToSave.getPrice()+"','"+dataToSave.getAmount()+"','"+
                    dataToSave.getSellerName()+"','"+
                    dataToSave.getSellerSirname()+"','"+dataToSave.getBuyer()+"','"+
                    dataToSave.getDate()+"')";
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<SparePartSaleData> getAll(){
        List<SparePartSaleData> transactionDataList = new ArrayList<>();
        try {
            Statement statement= connection.createStatement();
            String SQL ="SELECT * FROM tr_table";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                SparePartSaleData tempPart =new SparePartSaleData();

                tempPart.setId(resultSet.getInt("transactionId"));
                tempPart.setNameOfPart(resultSet.getString("nameOfPart"));
                tempPart.setCategory(resultSet.getString("category"));
                tempPart.setPrice(resultSet.getString("price"));
                tempPart.setAmount(resultSet.getString("amount"));
                tempPart.setSellerName(resultSet.getString("nameOfSeller"));
                tempPart.setSellerSirname(resultSet.getString("sirnameOfSeller"));
                tempPart.setBuyer(resultSet.getString("buyer"));
                tempPart.setDate(resultSet.getString("date"));

                transactionDataList.add(tempPart);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return transactionDataList;
    }
}
