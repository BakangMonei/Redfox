<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="bean.Movie" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="css/style.css">
    <title>Movie Selection List</title>
</head>
<body>
<%
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    Movie mb=new Movie();
    try {
        String url = "jdbc:mysql://localhost:3306/RedfoxAssignment";
        String user = "root";
        String pass = "";
        con = DriverManager.getConnection(url, user, pass);
    }
    catch(Exception e)
    {
        out.println(e);
    }
    String sql ="SELECT moviename from movie";
    st=con.createStatement();
    rs = st.executeQuery(sql);
%>
<form action="seatLayout.jsp">
    <div class="container">
        <div id="login-box">
            <div class="left">
                <h1>Select Movie Name</h1>
                <select name="movie">
                    <%
                        while(rs.next())
                        {
                    %>
                    <option value="<%= rs.getString("moviename")%>"><%= rs.getString("moviename") %></option>
                    <%
                        }
                    %>
                </select>
                <input type="submit" value="Go" />
</form>
</div>
</div>
</body>
</html>