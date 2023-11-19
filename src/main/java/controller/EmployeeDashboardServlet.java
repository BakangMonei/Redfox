package controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "EmployeeDashboardServlet", urlPatterns = "/EmployeeDashboardServlet")
public class EmployeeDashboardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        String n = (String) session.getValue("email");
        System.out.println("Name: " + n);

        if(request.getParameter("addEmployeeBtn") != null){
            System.out.println("Add Employee Clicked");
        }else if(request.getParameter("removeEmployeeBtn") != null) {
            System.out.println("Remove Employee Clicked");
        }else if(request.getParameter("viewEmployeesBtn") != null){
            System.out.println("View Employees Clicked");
        }
    }
}
