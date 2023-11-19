package controller;


import dao.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

@WebServlet(name = "ViewEmployeesServlet", value = "/ViewEmployeesServlet")
public class ViewEmployeesServlet extends HttpServlet {
    AdminDAO adminDAO = new AdminDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

        getServletContext().getRequestDispatcher("/admin_view_employees.jsp").forward(request, response);
    }
}
