<jsp:useBean id="client" scope="session" type="bean.Client"/>
<%@ page import="dao.MovieDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="bean.Movie" %>
<%@ page import="bean.Client" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Top IMDb</title>

    <link rel = "stylesheet" type = "text/css" href = "/client_style.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
          crossorigin="anonymous"></script>
</head>
<body>
<section class="vh-100 gradient-custom">
    <jsp:include page="includes/client-nav.jsp" />
    <main>

        <div class="album py-5 bg-dark d-flex justify-content-center">
            <div class="container">
                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-6 ms-3">
                    <%
                        MovieDAO movieDAO = new MovieDAO();
                        ArrayList<Movie> movieList = new ArrayList<Movie>();
                        Movie movie = new Movie();

                        int count = 5;
                        int idNum = 1;
                        String str;

                        ResultSet resultSet = null;

                        while (count!=0){
                            resultSet = movieDAO.getTopFive(idNum);
                            while (resultSet.next()){
                                movie.setId(resultSet.getInt("id"));
                                movie.setTitle(resultSet.getString("title"));
                                movie.setDirector(resultSet.getString("director"));
                                movie.setGenre1(resultSet.getString("genre1"));
                                movie.setGenre2(resultSet.getString("genre2"));
                                movie.setGenre3(resultSet.getString("genre3"));
                                movie.setActor1(resultSet.getString("actor1"));
                                movie.setActor2(resultSet.getString("actor2"));
                                movie.setActor3(resultSet.getString("actor3"));
                                movie.setSynopsis(resultSet.getString("synopsis"));
                                movie.setYear(resultSet.getString("yop"));
                                movie.setImgUrl(resultSet.getString("imgurl"));
                                movie.setRate(resultSet.getDouble("rate"));

                                System.out.println(movie.getId());
                            }
                            idNum++;
                            String name = String.valueOf(movie.getId());
                    %>

                    <div class="card p-0 mx-1 my-2 border-0 bg-dark" style="width: 212px">
                        <%String href = "/RateTourServlet/" + name;%>
                        <a href="<%=href%>"  class="btn btn-fix text-left px-2" id="<%=movie.getId()%>">
                        <img src="<%=movie.getImgUrl()%>"
                             class="card-img-top card-img rounded img-responsive"
                             alt="..."
                             width="192px"
                             height="303"
                             style="object-fit: cover"
                        >
                        <div class="card-body">
                            <p class="card-text fw-semibold text-white"><%=movie.getTitle()%></p>
                        </div>
                            <%
                                HttpSession httpSession = request.getSession();
                                httpSession.setAttribute("movie", movie);
                            %>
                        </a>
                    </div>
                    <%
                            count--;
                        }
                    %>
                </div>
            </div>
        </div>
    </main>
</section>
<script src="/docs/5.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>
