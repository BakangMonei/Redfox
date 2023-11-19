package dao;

import java.sql.*;

public class DBCPDataSource {

    ResultSet resultSet;
    Connection conn;
    Statement stmt;
    PreparedStatement preparedStatement;
    private static DatabaseConnection ds = new DatabaseConnection();

    static {
        ds.getConnection("com.mysql.cj.jdbc.Driver");

        // ds.setPassword("");
        // ds.setMinIdle(5);
        // ds.setMaxIdle(10);
        // ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection("com.mysql.cj.jdbc.Driver").createStatement().getConnection();
    }

    private DBCPDataSource(){ }
}
