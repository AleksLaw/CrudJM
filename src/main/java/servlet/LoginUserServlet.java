package servlet;

import model.User;
import service.UserService;
import service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/loginUser")
public class LoginUserServlet extends HttpServlet {
    private final UserService userService = UserServiceImp.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("login");
        String password = request.getParameter("password");
        Long id = null;
        if (session.getAttribute("login") != null || session.getAttribute("password") != null) {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        try {
            id = userService.getUserIdByName(name, password);
            User user = userService.getUserById(id);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            response.sendRedirect("/admin/allUser");
        } catch (Exception e) {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
