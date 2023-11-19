package dao;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    DatabaseConnection databaseConnection = new DatabaseConnection();

    public AdminDAO() {
    }

    public void registerEmployee(int id, String firstName, String lastName,
                                 String email, String password,
                                 int phone, String address) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("insert into employee values (?,?,?,?,?,?,?)");
        pst.setInt(1, id);
        pst.setString(2, firstName);
        pst.setString(3, lastName);
        pst.setString(4, email);
        pst.setString(5, password);
        pst.setInt(6, phone);
        pst.setString(7, address);

        databaseConnection.preparedStatement = pst;
        databaseConnection.preparedStatement.executeUpdate();
    }

    public int searchLastId() throws SQLException{
        int result;
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select id from employee \n order by id desc \n limit 1");
        ResultSet rsGetData = pst.executeQuery();

        if(rsGetData.next()){
            result = rsGetData.getInt("id");
        }else {
            result = 0;
        }
        return result;
    }

    public ResultSet verifyLogin(String email, String password) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select * from admin where email = ? and password = ?");
        pst.setString(1, email);
        pst.setString(2, password);

        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    public ResultSet getEmployeeList() throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select * from employee");
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }
}
