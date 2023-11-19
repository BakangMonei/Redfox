package controller;

import dao.MainDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @Author: Monei Bakang Mothuti
 * @Date: Tuesday September 2023
 * @Time: 1:45 PM
 */
@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    MainDatabase DB = new MainDatabase();
    public LoginServlet(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw=response.getWriter();
        response.setContentType("text/html");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            if(DB.verifyAdminLogin(email, password).next()){
                Cookie loginCk = new Cookie("email", email);
                loginCk.setMaxAge(60*5);
                response.addCookie(loginCk);
                response.sendRedirect(request.getContextPath() + "/admin_dashboard.jsp");
            }
            else if(DB.verifyEmployeeLogin(email, password).next()){
                Cookie loginCk = new Cookie("email", email);
                loginCk.setMaxAge(60*5);
                response.addCookie(loginCk);
                response.sendRedirect(request.getContextPath() + "/employee_dashboard.jsp");
            }
            else if(DB.verifyClientLogin(email, password).next()){
                Cookie loginCk = new Cookie("email", email);
                loginCk.setMaxAge(60*5);
                response.addCookie(loginCk);
                response.sendRedirect(request.getContextPath() + "/client_dashboard.jsp");
            }
            else{
                response.sendRedirect(request.getContextPath() + "/try.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
