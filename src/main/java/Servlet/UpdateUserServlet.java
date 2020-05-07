package Servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/update")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = UserService.getInstance();
        int id = Integer.parseInt(request.getParameter("name"));

        String nameNew = request.getParameter("nameNew");
        String surnameNew = request.getParameter("surnameNew");
        User userNew = new User(nameNew, surnameNew);



          userService.updateUser(id, userNew);
                request.getRequestDispatcher("/update.jsp").forward(request, response);




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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("doGet  /upda ");
    }
}
