package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet(name = "AdminDashboardServlet", value = "/AdminDashboardServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookie = request.getCookies();
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
