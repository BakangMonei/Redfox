<%@ page import="dao.MovieDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="bean.Movie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rate Tour</title>

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
        <div class="album py-5 bg-light mt-5 d-flex justify-content-center">
            <div class="container">
                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-5 ms-3">
                    <%
                        MovieDAO movieDAO = new MovieDAO();
                        Movie movie = new Movie();
                        int count = movieDAO.countMovies();
                        int idNum = 1;
                        int starPos = 1;

                        ResultSet resultSet = null;
                    %>
                    <%
                        while (count!=0){
                            resultSet = movieDAO.getMovieById(idNum);
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
                                movie.setRate(resultSet.getDouble("rate"));
                                movie.setImgUrl(resultSet.getString("imgurl"));
                            }
                            idNum++;
                    %>

                    <div class="card my-4 mx-2 border-0 shadow crd" style="width: 258px">
                        <img src="<%=movie.getImgUrl()%>"
                             class="card-img-top rounded img-responsive"
                             alt="..."
                             width="232px"
                             height="343"
                             style="object-fit: cover"
                        >
                        <div class="card-body">
                            <p class="card-text fw-semibold"><%=movie.getTitle()%></p>
                        </div>
                        <%
                            HttpSession httpSession = request.getSession();
                            httpSession.setAttribute("movie", movie);
                        %>
                        <form action="/rating" method="post">
                            <fieldset class="rating">
                                <input type="radio" id="star5<%=starPos%>" name="rating" value="5" />
                                <label for="star5<%=starPos%>">5 stars</label>
                                <input type="radio" id="star4<%=starPos%>" name="rating" value="4" />
                                <label for="star4<%=starPos%>">4 stars</label>
                                <input type="radio" id="star3<%=starPos%>" name="rating" value="3" />
                                <label for="star3<%=starPos%>">3 stars</label>
                                <input type="radio" id="star2<%=starPos%>" name="rating" value="2" />
                                <label for="star2<%=starPos%>">2 stars</label>
                                <input type="radio" id="star1<%=starPos%>" name="rating" value="1" />
                                <label for="star1<%=starPos%>">1 star</label>
                            </fieldset>
                            <%
                                starPos++;
                            %>
                            <button class="btn btn-primary btn-lg px-5" type="submit" name="ratebtn" value="<%=movie.getId()%>">Rate</button>
                        </form>
                    </div>
                    <%
                            count--;
                        }
                    %>
                </div>
            </div>
        </div>

    </main>

    <footer class="text-muted py-5">
        <div class="container">
            <p class="float-end mb-1">
                <a href="#">Back to top</a>
            </p>
            <p class="mb-1">Album example is © Bootstrap, but please download and customize it for yourself!</p>
            <p class="mb-0">New to Bootstrap? <a href="/">Visit the homepage</a> or read our <a href="/docs/5.2/getting-started/introduction/">getting started guide</a>.</p>
        </div>
    </footer>

</section>
<script src="/docs/5.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>
