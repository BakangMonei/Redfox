package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {
    DatabaseConnection databaseConnection = new DatabaseConnection();

    public ClientDAO() {
    }

    public void registerClient(int id, String firstName, String lastName,
                                 String email, String password,
                                 String genre1, String genre2, String genre3) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("insert into client values (?,?,?,?,?,?,?,?)");
        pst.setInt(1, id);
        pst.setString(2, firstName);
        pst.setString(3, lastName);
        pst.setString(4, email);
        pst.setString(5, password);
        pst.setString(6, genre1);
        pst.setString(7, genre2);
        pst.setString(8, genre3);

        databaseConnection.preparedStatement = pst;
        databaseConnection.preparedStatement.executeUpdate();
    }

    public int searchLastId() throws SQLException{
        int result;
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select id from client \n order by id desc \n limit 1");
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
        pst = databaseConnection.connection.prepareStatement("select * from client where email = ? and password = ?");
        pst.setString(1, email);
        pst.setString(2, password);

        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    public ResultSet getEmployeeList() throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select * from client");
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }
}
