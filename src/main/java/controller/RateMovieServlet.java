package controller;


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

@WebServlet(name = "RateMovieServlet", value = "/RateMovieServlet")
public class RateMovieServlet extends HttpServlet {
    public RateMovieServlet(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = String.valueOf(request.getRequestURL());

        String separator ="_";
        int sepPos = url.indexOf(separator);
        if (sepPos == -1) {
            System.out.println("");
        }
        int movieSelected = Integer.parseInt(url.substring(sepPos + separator.length()));

        Movie movie = new Movie();
        MovieDAO movieDAO = new MovieDAO();

        try {

            ResultSet res = movieDAO.getMovieById(movieSelected);
            if(res.next()){
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

                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("movie", movie);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect(request.getContextPath() + "/movie_details.jsp");
    }
}
