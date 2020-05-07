package Servlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(value = "/")
public class StartServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.sendRedirect("/allUser");
       // response.sendRedirect("/test.jsp");
    }
}