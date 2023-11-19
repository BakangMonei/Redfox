package controller;


import dao.AdminDAO;
import dao.MovieDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;


@WebServlet(name = "AddMovieServlet", value = "/AddMovieServlet")
public class AddMovieServlet extends HttpServlet {
    MovieDAO movieDAO = new MovieDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String director = request.getParameter("director");
        String actor1 = request.getParameter("actor1");
        String actor2 = request.getParameter("actor2");
        String actor3 = request.getParameter("actor3");
        String synopsis = request.getParameter("synopsis");
        String yop = request.getParameter("yop");
        String imgUrl = request.getParameter("imgurl");

        try {
            String[] genreSelected = new String[3];
            String[] genreArray = request.getParameterValues("genre");
            int genreCount = genreArray.length;

            for (int x = 0; x < genreCount; x++){
                if (genreArray[x]!=null && x < 3){
                    genreSelected[x] = genreArray[x];
                }
            }

            if(movieDAO.searchLastId() == 0){
                movieDAO.registerMovie(movieDAO.searchLastId() + 1, title, director, genreSelected[0], genreSelected[1], genreSelected[2], actor1, actor2, actor3, synopsis, String.valueOf(yop), 0.0, imgUrl);
            }else {
                movieDAO.registerMovie(movieDAO.searchLastId() + 1, title, director, genreSelected[0], genreSelected[1], genreSelected[2], actor1, actor2, actor3, synopsis, String.valueOf(yop), 0.0, imgUrl);
            }
            getServletContext().getRequestDispatcher("/emp_add_movie.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * Forward req and res
         * getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
         *
         * Redirect to another URL
         * Eg 1 - response.sendRedirect("https://www.google.com/");
         * Eg 2 - response.sendRedirect("/#");
         */

        getServletContext().getRequestDispatcher("/admin_add_employee.jsp").forward(request, response);
    }

    private static char[] generatePassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));


        for(int i = 4; i< length ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;
    }
}
