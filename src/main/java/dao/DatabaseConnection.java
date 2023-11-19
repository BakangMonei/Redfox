package dao;

import java.sql.*;

public class DatabaseConnection {
    public Connection connection;
    public PreparedStatement preparedStatement;
    public Statement statement;

    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/RedfoxDatabase", "root", "");
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(String s) {
        return null;
    }
}