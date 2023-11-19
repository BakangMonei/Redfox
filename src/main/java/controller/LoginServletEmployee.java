package controller;


import dao.AdminDAO;
import dao.EmployeeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginServletEmployee", value = "/LoginServletEmployee")
public class LoginServletEmployee extends HttpServlet {
    EmployeeDAO employeeDAO = new EmployeeDAO();

    public LoginServletEmployee(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        String userID = new String("ABCD");
        String userIDKey = new String("userID");

        response.setContentType("text/html");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            if(employeeDAO.verifyLogin(email, password).next()){
                if(session.isNew()){
                    session.setAttribute(userIDKey, userID);
                }else {
                    userID = (String) session.getAttribute(userIDKey);
                }
                System.out.println("EMPLOYEE ID: " + session.getId());
                response.sendRedirect(request.getContextPath() + "/employee_dashboard.jsp");
                System.out.println("Employee");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("the GET req has been made");
    }
}
