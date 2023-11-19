package controller;


import dao.ClientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

@WebServlet(name = "SignUpServlet", value = "/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ClientDAO clientDAO = new ClientDAO();

        response.setContentType("text/html");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String[] genre = request.getParameterValues("genre");
        String[] genreSelected = new String[3];

        for (int x = 0; x < 3; x++){
            if (genre[x]!=null){
                genreSelected[x] = genre[x];
            }
        }

        try {
            if(clientDAO.searchLastId() == 0){
                clientDAO.registerClient(clientDAO.searchLastId() + 1, firstName, lastName, email, password, genreSelected[0], genreSelected[1], genreSelected[2]);
            }else {
                clientDAO.registerClient(clientDAO.searchLastId() + 1, firstName, lastName, email, password, genreSelected[0], genreSelected[1], genreSelected[2]);
            }
            getServletContext().getRequestDispatcher("/login_client.jsp").forward(request, response);

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

        getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
    }
}
