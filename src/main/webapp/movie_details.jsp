<jsp:useBean id="movie" scope="session" type="bean.Movie"/>
<jsp:useBean id="client" scope="session" type="bean.Client"/>
<%@ page import="dao.MovieDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movie</title>

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
            <div class="container mt-5">
                <div class="row justify-content-center">
                    <div class="col-md-7 col-lg-4 mb-5 mb-lg-0 wow fadeIn">
                        <div class="card border-0 shadow">
                            <img src="${movie.imgUrl}"
                                 alt="..."
                            >
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="ps-lg-1-6 ps-xl-5">
                            <div class="mb-2 wow fadeIn">
                                <div class="text-start mb-1-6 wow fadeIn">
                                    <h3 class="h1 mb-0 text-primary">${movie.title}</h3>
                                </div>
                                <p>${movie.synopsis}</p>
                            </div>
                            <div class="mb-2 wow fadeIn">
                                <div class="text-start mb-1-6 wow fadeIn">
                                    <h4 class="mb-0 text-primary">Directors</h4>
                                    <p>${movie.director}</p>
                                </div>
                            </div>
                            <div class="mb-2 wow fadeIn">
                                <div class="text-start mb-1-6 wow fadeIn">
                                    <h4 class="mb-0 text-primary">Main Actors</h4>
                                    <p>${movie.actor1}, ${movie.actor2}, ${movie.actor3}, etc.</p>
                                </div>
                            </div>
                            <div class="mb-5 wow fadeIn">
                                <div class="text-start mb-1-6 wow fadeIn">
                                    <h4 class="mb-0 text-primary">Genre</h4>
                                </div>
                                <div class="row mt-n4">
                                    <div class="col-sm-6 col-xl-4 mt-4">
                                        <div class="card text-center border-0 rounded-3">
                                            <div class="card-body">
                                                <i class="ti-bookmark-alt icon-box medium rounded-3 mb-4"></i>
                                                <div class="card">
                                                    <div class="card-body movie_details_card rounded">
                                                        <h3 class="h5 mb-3">${movie.genre1}</h3>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-xl-4 mt-4">
                                        <div class="card text-center border-0 rounded-3">
                                            <div class="card-body">
                                                <i class="ti-pencil-alt icon-box medium rounded-3 mb-4"></i>
                                                <div class="card">
                                                    <div class="card-body movie_details_card rounded">
                                                        <h3 class="h5 mb-3">${movie.genre2}</h3>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-xl-4 mt-4">
                                        <div class="card text-center border-0 rounded-3">
                                            <div class="card-body">
                                                <i class="ti-medall-alt icon-box medium rounded-3 mb-4"></i>
                                                <div class="card">
                                                    <div class="card-body movie_details_card rounded">
                                                        <h3 class="h5 mb-3">${movie.genre3}</h3>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</section>
<script src="/docs/5.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>
