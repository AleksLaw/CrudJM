package servlet;

import model.User;
import service.UserService;
import service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/admin/updateUser")
public class UpdateUserServlet extends HttpServlet {
    private final UserService userService = UserServiceImp.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String nameNew = request.getParameter("name");
        String passwordNew = request.getParameter("password");
        String roleNew = request.getParameter("role");
        User userNew = new User(nameNew, passwordNew, roleNew);
        userService.updateUser(id, userNew);
        response.sendRedirect("/admin/allUser");
    }
}
