package Servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/delUser")
public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = UserService.getInstance();
//        response.getWriter().println(request.getParameter("name"));
//        response.getWriter().println(request.getAttributeNames());

        int id = Integer.parseInt(request.getParameter("name"));
//response.getWriter().println(id+" "+ request.getParameter("name"));
        userService.delUser(id);
//        List<User> lists=userService.allUser();
//        request.setAttribute("list", lists);
   //    request.getRequestDispatcher("/allUser").forward(request, response);
        response.sendRedirect("/allUser");

//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        User user = new User(name, surname);
//
//        if (!name.equals("") && !surname.equals("")) {
//            if (userService.delUser(user)) {
//                request.getRequestDispatcher("/delete.jsp").forward(request, response);
//            }
//        } else {
//            response.getWriter().println("USER NOT DELETED");
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
    }
}
