package servlet;

import service.UserService;
import service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/admin/delUser")
public class DelUserServlet extends HttpServlet {
    private final UserService userService = UserServiceImp.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println(request.getParameter("id"));
        Long id = Long.parseLong(request.getParameter("id"));
        userService.delUser(id);
        response.sendRedirect("/admin/allUser");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
