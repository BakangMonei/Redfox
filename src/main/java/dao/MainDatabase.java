package dao;

import java.sql.*;
import java.time.*;
import java.time.format.*;

public class MainDatabase {
    // Calling the connection
    DatabaseConnection databaseConnection = new DatabaseConnection();

    // Super Constructor
    public MainDatabase() {
        super();
    }

    /******************************** ADMINISTRATOR  **********************************************************/
    // Admin LoggingIn
    public ResultSet verifyAdminLogin(String email, String password) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select * from admin where email = ? and password = ?");
        pst.setString(1, email);
        pst.setString(2, password);


        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    // Adding Employee
    public void registerEmployee(int id, String firstName, String lastName, String email, String password,
                                 int phone, String address, String gender, String username, String omang)
            throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("insert into employee values (?,?,?,?,?,?,?,?,?,?)");
        pst.setInt(1, id); //
        pst.setString(2, firstName); //
        pst.setString(3, lastName); //
        pst.setString(4, email); //
        pst.setString(5, password);//
        pst.setInt(6, phone);//
        pst.setString(7, gender);//
        pst.setString(8, username); //
        pst.setString(9, omang);//
        pst.setString(10, address); //

        databaseConnection.preparedStatement = pst;
        databaseConnection.preparedStatement.executeUpdate();
    }

    // Getting employee list from database
    public ResultSet getEmployeeList() throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select * from employee");
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    // Getting student list from database
    public ResultSet getStudentList() throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select * from student");
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    /******************************** STUDENTS  **********************************************************/
    // Student LoggingIn
    public ResultSet verifyClientLogin(String email, String password) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select * from Client where email = ? and password = ?");
        pst.setString(1, email);
        pst.setString(2, password);

        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    // Adding Student by Admin & registration by new student & Employee
    public void registerClient(int id, String firstName, String lastName, String email, String password, String option1, String option2, String option3) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("insert into Client values (?,?,?,?,?,?,?,?)");
        pst.setInt(1, id);
        pst.setString(2, firstName);
        pst.setString(3, lastName);
        pst.setString(4, email);
        pst.setString(5, password);
        pst.setString(6, option1);
        pst.setString(7, option2);
        pst.setString(8, option3);


        databaseConnection.preparedStatement = pst;
        databaseConnection.preparedStatement.executeUpdate();
    }

    public void rClient(int id, String firstName, String lastName, String email, String password, String username) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("insert into Client values (?,?,?,?,?,?)");
        pst.setInt(1, id);
        pst.setString(2, firstName);
        pst.setString(3, lastName);
        pst.setString(4, email);
        pst.setString(5, password);
        pst.setString(6, username);


        databaseConnection.preparedStatement = pst;
        databaseConnection.preparedStatement.executeUpdate();
    }

    // Searching student by id
    public int searchClientLastId() throws SQLException {
        int result;
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select id from Client \n order by id desc \n limit 1");
        ResultSet rsGetData = pst.executeQuery();

        if (rsGetData.next()) {
            result = rsGetData.getInt("id");
        } else {
            result = 0;
        }
        return result;
    }

    /******************************** EMPLOYEE  **********************************************************/
    // Employee LoggingIn
    public ResultSet verifyEmployeeLogin(String email, String password) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select * from employee where email = ? and password = ?");
        pst.setString(1, email);
        pst.setString(2, password);

        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    // Searching Employee by id
    public int searchEmployeeLastId() throws SQLException {
        int result;
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select id from employee \n order by id desc \n limit 1");
        ResultSet rsGetData = pst.executeQuery();

        if (rsGetData.next()) {
            result = rsGetData.getInt("id");
        } else {
            result = 0;
        }
        return result;
    }

    /******************************** Institutes  **********************************************************/
    // Adding Institute
    public void registerInstitute(int id, String universityName, String Location) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("insert into universities values (?,?,?)");
        pst.setInt(1, id);
        pst.setString(2, universityName);
        pst.setString(3, Location);
        databaseConnection.preparedStatement = pst;
        databaseConnection.preparedStatement.executeUpdate();

    }

    // Searching Institute by id
    public int searchInstituteLastId() throws SQLException {
        int result;
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select id from universities \n order by id desc \n limit 1");
        ResultSet rsGetData = pst.executeQuery();

        if (rsGetData.next()) {
            result = rsGetData.getInt("id");
        } else {
            result = 0;
        }
        return result;
    }

    public ResultSet getInstituteById(int id) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select * from universities where id = ?");
        pst.setInt(1, id);
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    // Getting Institutes list from database
    public ResultSet getInstituteList() throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select * from universities");
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    // Counting institutions
    public int countInstitute() throws SQLException {
        int result;
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select count(*) as count_institute from universities");
        ResultSet resultSet = pst.executeQuery();
        if (resultSet.next()) {
            result = resultSet.getInt("count_institute");
        } else {
            result = 0;
        }
        return result;
    }

    /******************************** Courses  **********************************************************/
    // Selecting course by years taken
    public ResultSet getLatestProgram() throws SQLException {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDateTime = currentDate.format(format);

        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("SELECT  *\n" +
                "FROM    course \n" +
                "WHERE   yop >= '2000-01-01' AND\n" +
                "yop   <= ? order by yop desc limit 5");
        pst.setString(1, formatDateTime);
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    // Getting top5 courses
    public ResultSet getTopFive(int ClientId) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select * from program where id not in (select programid from rating where Clientid = ?) order by rate desc limit 5");
        pst.setInt(1, ClientId);
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    // Getting rated courses by certain student
    public ResultSet clientRatedPrograms(int ClientId) throws SQLException {
        PreparedStatement pst = null;
        //order by rate desc limit 5
        pst = databaseConnection.connection.prepareStatement("select programid from rating where Clientid = ?");
        pst.setInt(1, ClientId);
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    // Rating Courses
    public double calculateRate() throws SQLException {
        double avgRate = 0.0;
        PreparedStatement pst1 = null, pst2 = null;
        double count = 0, sum = 0;
        pst1 = databaseConnection.connection.prepareStatement("select count(*) as count_program from rating");
        pst2 = databaseConnection.connection.prepareStatement("select sum(rate) as rate_sum from rating");


        ResultSet res1 = pst1.executeQuery();
        if (res1.next()) {
            count = res1.getInt("count_program");
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

    // Rating Course
    public void rateCourse(int ClientId, int programId, double rate) throws SQLException {
        PreparedStatement pst1 = null, pst2 = null;
        pst1 = databaseConnection.connection.prepareStatement("insert into rating values (?,?,?)");
        pst1.setInt(1, ClientId);
        pst1.setInt(2, programId);
        pst1.setDouble(3, rate);

        databaseConnection.preparedStatement = pst1;
        databaseConnection.preparedStatement.executeUpdate();

        pst2 = databaseConnection.connection.prepareStatement("update universities " +
                "set rate = ? " +
                "where id = ?");
        pst2.setDouble(1, calculateRate());
        pst2.setInt(2, programId);

        databaseConnection.preparedStatement = pst2;
        databaseConnection.preparedStatement.executeUpdate();
    }

    // Getting course by ID
    public ResultSet getCourseById(int id) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select * from course where id = ?");
        pst.setInt(1, id);
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    /******************************** Grades  **********************************************************/

    // Adding to Database
    public void registerMarks(String email, int id,
                              String Subject1, int m1,
                              String Subject2, int m2,
                              String Subject3, int m3,
                              String Subject4, int m4,
                              String Subject5, int m5,
                              String Subject6, int m6,
                              String Subject7, int m7,
                              String Subject8, int m8) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("insert into Clientmarks values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        pst.setString(1, email);
        pst.setInt(2, id);

        pst.setString(3, Subject1);
        pst.setInt(4, m1);

        pst.setString(5, Subject2);
        pst.setInt(6, m2);

        pst.setString(7, Subject3);
        pst.setInt(8, m3);

        pst.setString(9, Subject4);
        pst.setInt(10, m4);

        pst.setString(11, Subject5);
        pst.setInt(12, m5);

        pst.setString(13, Subject6);
        pst.setInt(14, m6);

        pst.setString(15, Subject7);
        pst.setInt(16, m7);

        pst.setString(17, Subject8);
        pst.setInt(18, m8);

        databaseConnection.preparedStatement = pst;
        databaseConnection.preparedStatement.executeUpdate();
    }

    // Calculating Average for marks
    public double calculateAverage() throws SQLException {
        double avgMark = 0.0;
        PreparedStatement pst1 = null, pst2 = null;
        double count = 0, sum = 0;
        pst1 = databaseConnection.connection.prepareStatement("select count(mark1, mark2, mark3, mark4, mark5, mark6, mark7, mark8) as total_marks from stumarks");
        pst2 = databaseConnection.connection.prepareStatement("select sum(totalMarks) as marksClient from Clientmarks");

        ResultSet res1 = pst1.executeQuery();
        if (res1.next()) {
            count = res1.getInt("total_marks");
        } else {
            count = 0;
        }
        ResultSet res2 = pst2.executeQuery();
        if (res2.next()) {
            sum = res2.getInt("marksStudent");
        } else {
            sum = 0;
        }
        avgMark = sum / count;
        return avgMark;
    }

    // Getting from Database
    public ResultSet getClientGradeList() throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select * from Clientmarks");
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    public ResultSet getPointList() throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select * from Clientmarks");
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }

    // Deleting accounts
    public void deleteeStudendefwght(String emailOrId) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null, pst = null;


        pst = databaseConnection.connection.prepareStatement("Delete From Client and Clientmarks where email = ? OR id = ?");
        String query = "DELETE FROM student and stumarks WHERE email = ? OR id = ?";

        databaseConnection.preparedStatement = pst;
        databaseConnection.preparedStatement.executeUpdate();

    }

    public ResultSet deleteClient(String emailOrId) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("Delete From Client where email = ? OR id = ?");
        ResultSet resultSet = pst.executeQuery();
        return resultSet;
    }
    /**********************/
    public void registerEmployeeeeee(int id, String firstName,
                                     String lastName, String email,
                                     String password, int phone,
                                     String gender, String username, String omang,
                                     String address) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("insert into employee values (?,?,?,?,?,?,?,?,?,?)");
        pst.setInt(1, id); //
        pst.setString(2, firstName); //
        pst.setString(3, lastName); //
        pst.setString(4, email); //
        pst.setString(5, password);//
        pst.setInt(6, phone);//
        pst.setString(7, gender);//
        pst.setString(8, username); //
        pst.setString(9, omang);//
        pst.setString(10, address); //

        databaseConnection.preparedStatement = pst;
        databaseConnection.preparedStatement.executeUpdate();
    }

    // Make payment to the database
    public void makePayment(int id, String email, String username, int cardN, int cvc, int expiryDate, int amount) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("insert into payment values (?,?,?,?,?,?,?)");
        pst.setInt(1, id);
        pst.setString(2, email);
        pst.setString(3, username);
        pst.setInt(4, cardN);
        pst.setInt(5, cvc);
        pst.setInt(6, expiryDate);
        pst.setInt(7,amount);

        databaseConnection.preparedStatement = pst;
        databaseConnection.preparedStatement.executeUpdate();
    }

    public int searchDoPaymentLastId() throws SQLException {
        int result;
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select id from dopayment \n order by id desc \n limit 1");
        ResultSet rsGetData = pst.executeQuery();

        if (rsGetData.next()) {
            result = rsGetData.getInt("id");
        } else {
            result = 0;
        }
        return result;
    }

    public int searchPaymentLastId() throws SQLException {
        int result;
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("select id from payment \n order by id desc \n limit 1");
        ResultSet rsGetData = pst.executeQuery();

        if (rsGetData.next()) {
            result = rsGetData.getInt("id");
        } else {
            result = 0;
        }
        return result;
    }

    /*public void doPayment(int id, String payMethod, String email, String username, String cardN, String expiryDate, String cvv) throws SQLException{
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("insert into dopayment values (?,?,?,?,?,?,?)");
        pst.setInt(1, id);
        pst.setString(2, payMethod);
        pst.setString(3, email);
        pst.setString(4, username);
        pst.setString(5, cardN);
        pst.setString(6, expiryDate);
        pst.setString(7, cvv);

        databaseConnection.preparedStatement = pst;
        databaseConnection.preparedStatement.executeUpdate();
    }*/


    public void doPayment(int id, String payMethod, String email, String username, String cardN, String expiryDate, String cvv) throws SQLException {
        PreparedStatement pst = null;
        pst = databaseConnection.connection.prepareStatement("insert into payment values (?,?,?,?,?,?,?)");
        pst.setInt(1, id);
        pst.setString(2, payMethod);
        pst.setString(3, email);
        pst.setString(4, username);
        pst.setString(5, cardN);
        pst.setString(6, expiryDate);
        pst.setString(7, cvv);

        databaseConnection.preparedStatement = pst;
        databaseConnection.preparedStatement.executeUpdate();
    }
}