package controller;

import bean.Client;
import bean.Movie;
import dao.ClientDAO;
import dao.MovieDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServletClient", value = "/LoginServletClient")
public class LoginServletClient extends HttpServlet {
    ClientDAO clientDAO = new ClientDAO();
    MovieDAO movieDAO = new MovieDAO();

    int movieCount = 0;

    public LoginServletClient(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Client client = new Client();
        int ratedMoviesCount = 0;

        ResultSet res;
        String message = "Wrong credentials";
        response.setContentType("text/html");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            res = clientDAO.verifyLogin(email, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if(res.next()){
                client.setId(res.getInt(1));
                client.setFirstname(res.getString(2));
                client.setLastname(res.getString(3));
                client.setEmail(res.getString(4));
                client.setPassword(res.getString(5));
                client.setGenre1(res.getString(6));
                client.setGenre2(res.getString(7));
                client.setGenre3(res.getString(8));

                movieCount = movieDAO.countMovies();
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("client", client);


                ResultSet resRec = movieDAO.getLatestMovies();
                while (resRec.next()){
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
                }

                response.sendRedirect(request.getContextPath() + "/client_dashboard.jsp");
            }else{
                request.setAttribute("message",message);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            //getServletContext().getRequestDispatcher("/login_admin.jsp").forward(request, response);

            throw new RuntimeException(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("the GET req has been made");
    }
}
