package controller;

import bean.Client;
import bean.Movie;
import dao.MovieDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "Rating", value = "/Rating")
public class Rating extends HttpServlet {
    public Rating(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        MovieDAO movieDAO = new MovieDAO();
        Movie movie = new Movie();
        ResultSet res = null;

        double clientRate = Double.parseDouble(request.getParameter("rating"));
        String movieId = request.getParameter("ratebtn");
        Client client = (Client) httpSession.getAttribute("client");

        try {
            res = movieDAO.getMovieById(Integer.parseInt(movieId));

            while (res.next()){
                movie.setId(res.getInt("id"));
                movie.setTitle(res.getString("title"));
                movie.setDirector(res.getString("director"));
                movie.setGenre1(res.getString("genre1"));
                movie.setGenre2(res.getString("genre2"));
                movie.setGenre3(res.getString("genre3"));
                movie.setActor1(res.getString("actor1"));
                movie.setActor2(res.getString("actor2"));
                movie.setActor3(res.getString("actor3"));
                movie.setSynopsis(res.getString("synopsis"));
                movie.setYear(res.getString("yop"));
                movie.setRate(res.getDouble("rate"));
                movie.setImgUrl(res.getString("imgurl"));

                httpSession = request.getSession();
                httpSession.setAttribute("movie", movie);
            }

            movieDAO.rateMovie(client.getId(), movie.getId(), clientRate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
