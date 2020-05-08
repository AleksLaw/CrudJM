package Servlet;

import model.User;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImp userServiceImp = UserServiceImp.getInstance();
        HttpSession session = request.getSession();
        String name = request.getParameter("login");
        String password = request.getParameter("password");
        Long id = userServiceImp.getUserIdByName(name, password);


        if (session.getAttribute("login") != null || session.getAttribute("password") != null||id==0 ) {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        } else if (id != 0){
            User user = userServiceImp.getUserById(id);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            response.sendRedirect("/admin/allUser");
          //  request.getRequestDispatcher("/admin/allUser").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.getWriter().println("get");
       // request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}
