package servlet;

import model.User;
import service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/admin/updateUser")
public class UpdateUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImp userServiceImp = UserServiceImp.getInstance();
        response.getWriter().println(request.getParameter("id"));
        response.getWriter().println(request.getParameter("name"));
        response.getWriter().println(request.getParameter("surname"));
        response.getWriter().println(request.getParameter("role"));
        Long id = Long.parseLong(request.getParameter("id"));
        String nameNew = request.getParameter("name");
        String passwordNew = request.getParameter("password");
        String roleNew = request.getParameter("role");
        User userNew = new User(nameNew, passwordNew, roleNew);
        userServiceImp.updateUser(id, userNew);
        response.sendRedirect("/admin/allUser");
    }
}
