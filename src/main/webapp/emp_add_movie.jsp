<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Movie</title>
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
    <div class="container py-5 h-100">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-12 col-lg-9 col-xl-7">
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Add Movie Form</h3>

                        <form action="AddMovieServlet" method="post">
                            <div class="row">
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <input name="title" type="text" id="title" class="form-control form-control-lg" />
                                        <label class="form-label" for="title">Movie Title</label>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <input name="director" type="text" id="director" class="form-control form-control-lg" />
                                        <label class="form-label" for="director">Movie Director</label>
                                    </div>
                                </div>
                            </div>

                            <div class="row mb-4">
                                <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
                                    <input type="checkbox" class="btn-check" id="action" autocomplete="off" name="genre" value="Action">
                                    <label class="btn btn-outline-primary" for="action">Action</label>

                                    <input type="checkbox" class="btn-check" id="horror" autocomplete="off" name="genre" value="Horror">
                                    <label class="btn btn-outline-primary" for="horror">Horror</label>

                                    <input type="checkbox" class="btn-check" id="animation" autocomplete="off" name="genre" value="Animation">
                                    <label class="btn btn-outline-primary" for="animation">Animation</label>

                                    <input type="checkbox" class="btn-check" id="romance" autocomplete="off" name="genre" value="Romance">
                                    <label class="btn btn-outline-primary" for="romance">Romance</label>
                                </div>
                            </div>

                            <div class="row mb-4">
                                <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
                                    <input type="checkbox" class="btn-check" id="adventure" autocomplete="off" name="genre" value="Adventure">
                                    <label class="btn btn-outline-primary" for="adventure">Adventure</label>

                                    <input type="checkbox" class="btn-check" id="comedy" autocomplete="off" name="genre" value="Comedy">
                                    <label class="btn btn-outline-primary" for="comedy">Comedy</label>

                                    <input type="checkbox" class="btn-check" id="scifi" autocomplete="off" name="genre" value="Sci-fi">
                                    <label class="btn btn-outline-primary" for="scifi">Sci-Fi</label>

                                    <input type="checkbox" class="btn-check" id="fantasy" autocomplete="off" name="genre" value="Fantasy">
                                    <label class="btn btn-outline-primary" for="fantasy">Fantasy</label>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-4 mb-4 pb-2">
                                    <div class="form-outline">
                                        <input name="actor1" type="text" id="actor1" class="form-control form-control-lg" />
                                        <label class="form-label" for="actor1">Actor 1</label>
                                    </div>
                                </div>
                                <div class="col-md-4 mb-4 pb-2">

                                    <div class="form-outline">
                                        <input name="actor2" type="text" id="actor2" class="form-control form-control-lg" />
                                        <label class="form-label" for="actor2">Actor 2</label>
                                    </div>
                                </div>
                                <div class="col-md-4 mb-4 pb-2">

                                    <div class="form-outline">
                                        <input name="actor3" type="text" id="actor3" class="form-control form-control-lg" />
                                        <label class="form-label" for="actor3">Actor 3</label>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="mb-4 pb-2">
                                    <label for="synopsis" class="form-label">Synopsis</label>
                                    <textarea class="form-control" id="synopsis" name="synopsis" rows="3"></textarea>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 mb-4 d-flex align-items-center">
                                    <div class="form-outline datepicker w-100">
                                        <input name="yop" type="text" class="form-control form-control-lg" id="yop" />
                                        <label for="yop" class="form-label">Year Of Production</label>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-4 d-flex align-items-center">
                                    <div class="form-outline datepicker w-100">
                                        <input name="imgurl" type="text" class="form-control form-control-lg" id="imgurl" />
                                        <label for="imgurl" class="form-label">Image URL</label>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 mb-4 d-flex align-items-center">
                                    <input class="btn btn-primary btn-lg" type="submit" value="Submit" />
                                </div>

                                <div class="col-md-6 mb-4 d-flex align-items-center">
                                    <input class="btn btn-primary btn-lg" type="submit" value="Back" />
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
