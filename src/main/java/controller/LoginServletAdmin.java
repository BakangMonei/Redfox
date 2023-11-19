package controller;


import dao.AdminDAO;
import dao.MainDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginServletAdmin", value = "/LoginServletAdmin")
public class LoginServletAdmin extends HttpServlet {
    MainDatabase adminDao = new MainDatabase();

    public LoginServletAdmin(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter pw=response.getWriter();
        response.setContentType("text/html");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            if(adminDao.verifyAdminLogin(email, password).next()){
                Cookie loginCk = new Cookie("email", email);
                loginCk.setMaxAge(60*5);
                response.addCookie(loginCk);
                response.sendRedirect(request.getContextPath() + "/admin_dashboard.jsp");
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
