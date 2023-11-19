package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MovieDAO {
    DatabaseConnection databaseConnection = new DatabaseConnection();

    public MovieDAO() {
    }

    public void registerMovie(int id, String title, String director, String genre1, String genre2, String genre3,
                              String actor1, String actor2, String actor3, String synopsis,
                              String yop, double rate, String imgUrl) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("insert into movie values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        pst.setInt(1, id);
        pst.setString(2, title);
        pst.setString(3, director);
        pst.setString(4, genre1);
        pst.setString(5, genre2);
        pst.setString(6, genre3);
        pst.setString(7, actor1);
        pst.setString(8, actor2);
        pst.setString(9, actor3);
        pst.setString(10, synopsis);
        pst.setString(11, yop);
        pst.setDouble(12, rate);
        pst.setString(13, imgUrl);

        databaseConnection.preparedStatement = pst;
        databaseConnection.preparedStatement.executeUpdate();
    }

    public int searchLastId() throws SQLException {
        int result;
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select id from movie \n order by id desc \n limit 1");
        ResultSet rsGetData = pst.executeQuery();

        if (rsGetData.next()) {
            result = rsGetData.getInt("id");
        } else {
            result = 0;
        }
        return result;
    }

    public ResultSet getMovieList() throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select * from movie");
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    public ResultSet getMovieById(int id) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select * from movie where id = ?");
        pst.setInt(1, id);
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    public int countMovies() throws SQLException {
        int result;
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select count(*) as count_movie from movie");
        ResultSet resultSet = pst.executeQuery();
        if (resultSet.next()) {
            result = resultSet.getInt("count_movie");
        } else {
            result = 0;
        }
        return result;
    }

    public void rateMovie(int clientId, int movieId, double rate) throws SQLException {
        PreparedStatement pst1 = null, pst2 = null;
        pst1 = databaseConnection.connection.prepareStatement("insert into rating values (?,?,?)");
        pst1.setInt(1, clientId);
        pst1.setInt(2, movieId);
        pst1.setDouble(3, rate);

        databaseConnection.preparedStatement = pst1;
        databaseConnection.preparedStatement.executeUpdate();

        pst2 = databaseConnection.connection.prepareStatement("update movie " +
                "set rate = ? " +
                "where id = ?");
        pst2.setDouble(1, calculateRate());
        pst2.setInt(2, movieId);

        databaseConnection.preparedStatement = pst2;
        databaseConnection.preparedStatement.executeUpdate();
    }

    public double calculateRate() throws SQLException {
        double avgRate = 0.0;
        PreparedStatement pst1 = null, pst2 = null;
        double count = 0, sum = 0;
        pst1 = databaseConnection.connection.prepareStatement("select count(*) as count_movie from rating");
        pst2 = databaseConnection.connection.prepareStatement("select sum(rate) as rate_sum from rating");


        ResultSet res1 = pst1.executeQuery();
        if (res1.next()) {
            count = res1.getInt("count_movie");
        } else {
            count = 0;
        }

        ResultSet res2 = pst2.executeQuery();
        if (res2.next()) {
            sum = res2.getInt("rate_sum");
        } else {
            sum = 0;
        }
        avgRate = sum / count;

        return avgRate;
    }

    public ResultSet getTopFive(int clientId) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select * from movie where id not in (select movieid from rating where clientid = ?) order by rate desc limit 5");
        pst.setInt(1, clientId);
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    public ResultSet getLatestMovies() throws SQLException {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDateTime = currentDate.format(format);

        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("SELECT  *\n" +
                "FROM    movie \n" +
                "WHERE   yop >= '2000-01-01' AND\n" +
                "yop   <= ? order by yop desc limit 5");
        pst.setString(1, formatDateTime);
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    public ResultSet clientRatedMovies(int clientId) throws SQLException {
        PreparedStatement pst = null;
        //order by rate desc limit 5
        pst = databaseConnection.connection.prepareStatement("select movieid from rating where clientid = ?");
        pst.setInt(1, clientId);
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

}
