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
    <title>Dashboard</title>
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
<section class="vh-100 gradient-custom">
    <jsp:include page="includes/client-nav.jsp" />
    <main>
        <div>
            <div id="carouselExampleInterval" class="carousel carousel-dark slide" data-bs-ride="carousel">
                <div class="carousel-inner">

                    <%
                        HttpSession sess = request.getSession();
                        ArrayList<Movie> movieList = new ArrayList<Movie>();

                        Movie movie = new Movie();
                        MovieDAO movieDAO = new MovieDAO();

                        try {
                            ResultSet resRec = movieDAO.getLatestMovies();
                            while(resRec.next()){
                                Movie recMovie = new Movie();

                                recMovie.setId(resRec.getInt("id"));
                                recMovie.setTitle(resRec.getString("title"));
                                recMovie.setDirector(resRec.getString("director"));
                                recMovie.setGenre1(resRec.getString("genre1"));
                                recMovie.setGenre2(resRec.getString("genre2"));
                                recMovie.setGenre3(resRec.getString("genre3"));
                                recMovie.setActor1(resRec.getString("actor1"));
                                recMovie.setActor2(resRec.getString("actor2"));
                                recMovie.setActor3(resRec.getString("actor3"));
                                recMovie.setSynopsis(resRec.getString("synopsis"));
                                recMovie.setYear(resRec.getString("yop"));
                                recMovie.setRate(resRec.getDouble("rate"));
                                recMovie.setImgUrl(resRec.getString("imgurl"));

                                movieList.add(recMovie);
                            }
                            %>
                    <div class="carousel-item active" data-bs-interval="5000"  style="height: 600px">
                        <img src="<%=movieList.get(0).getImgUrl()%>" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block text-white">
                            <h5><%=movieList.get(0).getTitle()%></h5>
                            <p><%=movieList.get(0).getSynopsis()%></p>
                        </div>
                    </div>
                    <div class="carousel-item" data-bs-interval="5000"  style="height: 600px">
                        <img src="<%=movieList.get(1).getImgUrl()%>" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block text-white">
                            <h5><%=movieList.get(1).getTitle()%></h5>
                            <p><%=movieList.get(1).getSynopsis()%></p>
                        </div>
                    </div>
                    <div class="carousel-item" data-bs-interval="5000"  style="height: 600px">
                        <img src="<%=movieList.get(2).getImgUrl()%>" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block text-white">
                            <h5><%=movieList.get(2).getTitle()%></h5>
                            <p><%=movieList.get(2).getSynopsis()%></p>
                        </div>
                    </div>
                    <div class="carousel-item" data-bs-interval="5000"  style="height: 600px">
                        <img src="<%=movieList.get(3).getImgUrl()%>" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block text-white">
                            <h5><%=movieList.get(3).getTitle()%></h5>
                            <p><%=movieList.get(3).getSynopsis()%></p>
                        </div>
                    </div>
                    <div class="carousel-item" data-bs-interval="5000"  style="height: 600px">
                        <img src="<%=movieList.get(4).getImgUrl()%>" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block text-white">
                            <h5><%=movieList.get(4).getTitle()%></h5>
                            <p><%=movieList.get(4).getSynopsis()%></p>
                        </div>
                    </div>
                    <%

                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        %>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>

        <div class="album py-5 bg-dark d-flex justify-content-center">
            <div class="container">
                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-6 ms-3">
                    <%
                        int count = movieDAO.countMovies();
                        int idNum = 1;
                        String str = "movie_";

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
                                movie.setImgUrl(resultSet.getString("imgurl"));
                                movie.setRate(resultSet.getDouble("rate"));
                            }
                            idNum++;
                            String name = str + movie.getId();
                    %>

                    <div class="card p-0 mx-1 my-2 border-0 bg-dark" style="width: 212px">
                        <%String href = "RateTourServlet/" + name;%>
                        <a href="<%=href%>"  class="btn btn-fix text-left px-2" id="<%=movieList.get(0)%>">
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
