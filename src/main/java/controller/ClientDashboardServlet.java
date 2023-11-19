package controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ClientDashboardServlet", value = "/ClientDashboardServlet")
public class ClientDashboardServlet extends HttpServlet {
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

        //getServletContext().getRequestDispatcher("/admin_dashboard.jsp").forward(request, response);

        if(request.getParameter("addEmployeeBtn") != null){
            System.out.println("Add Employee Clicked");
        }else if(request.getParameter("removeEmployeeBtn") != null) {
            System.out.println("Remove Employee Clicked");
        }else if(request.getParameter("viewEmployeesBtn") != null){
            System.out.println("View Employees Clicked");
        }
    }
}
