package Servlet;

import service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delUser")
public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImp userServiceImp = UserServiceImp.getInstance();
        response.getWriter().println(request.getParameter("id"));
//        response.getWriter().println(request.getAttributeNames());

        Long id = Long.parseLong(request.getParameter("id"));
//response.getWriter().println(id+" "+ request.getParameter("name"));
        userServiceImp.delUser(id);
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
