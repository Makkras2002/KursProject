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
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO tr_table VALUES(?,?,?,?,?,?,?,?,?)");
            dataToSave.setId((int) (1+Math.random()*(10000)));
            preparedStatement.setInt(1,dataToSave.getId());
            preparedStatement.setString(2,dataToSave.getNameOfPart());
            preparedStatement.setString(3,dataToSave.getCategory());
            preparedStatement.setString(4,dataToSave.getPrice());
            preparedStatement.setString(5,dataToSave.getAmount());
            preparedStatement.setString(6,dataToSave.getSellerName());
            preparedStatement.setString(7,dataToSave.getSellerSirname());
            preparedStatement.setString(8,dataToSave.getBuyer());
            preparedStatement.setString(9,dataToSave.getDate());
            preparedStatement.executeUpdate();
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
