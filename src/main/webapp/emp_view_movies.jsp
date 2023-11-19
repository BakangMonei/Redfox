<%@ page import="dao.AdminDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="dao.MovieDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Movies</title>
    <link rel = "stylesheet" type = "text/css" href = "/style/admin_style.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<div>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col"></th>
            <th scope="col">ID</th>
            <th scope="col">Title</th>
            <th scope="col">Director</th>
            <th scope="col">Actors</th>
            <th scope="col">Year</th>
            <th scope="col">Rating</th>
        </tr>
        </thead>
        <tbody>
        <%
            MovieDAO movieDAO = new MovieDAO();
            ResultSet res = movieDAO.getMovieList();
            while(res.next()){%>


        <tr>
            <th scope="row"></th>
            <td><%=res.getString("id")%></td>
            <td><%=res.getString("title")%></td>
            <td><%=res.getString("director")%></td>
            <td><%=res.getString("actor1")%></td>
            <td><%=res.getString("yop")%></td>
            <td><%=res.getString("rate")%></td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>
