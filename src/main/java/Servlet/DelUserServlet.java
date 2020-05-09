package Servlet;

import service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/admin/delUser")
public class DelUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImp userServiceImp = UserServiceImp.getInstance();
        response.getWriter().println(request.getParameter("id"));
        Long id = Long.parseLong(request.getParameter("id"));
        userServiceImp.delUser(id);
        response.sendRedirect("/admin/allUser");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
    }
}
