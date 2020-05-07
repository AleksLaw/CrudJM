package Servlet;

import model.User;
import service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImp userServiceImp = UserServiceImp.getInstance();

        response.getWriter().println(request.getParameter("id"));
        response.getWriter().println(request.getParameter("name"));
        response.getWriter().println(request.getParameter("surname"));

        Long id = Long.parseLong(request.getParameter("id"));

        String nameNew = request.getParameter("name");
        String surnameNew = request.getParameter("surname");
        User userNew = new User(nameNew, surnameNew);


        userServiceImp.updateUser(id, userNew);
        response.sendRedirect("/allUser");
        //     request.getRequestDispatcher("/update.jsp").forward(request, response);


        //        UserService userService = UserService.getInstance();
//        String nameOld = request.getParameter("nameOld");
//        String surnameOld = request.getParameter("surnameOld");
//        String nameNew = request.getParameter("nameNew");
//        String surnameNew = request.getParameter("surnameNew");
//        User userOld = new User(nameOld, surnameOld);
//        User userNew = new User(nameNew, surnameNew);
//
//        if (!nameOld.equals("") && !surnameOld.equals("")
//                && !nameNew.equals("") && !surnameNew.equals("")) {
//            if (userService.updateUser(userOld, userNew)) {
//                request.getRequestDispatcher("/update.jsp").forward(request, response);
//            }
//        } else {
//            response.getWriter().println("USER NOT UPDATE");
//        }
    }


}
