package Servlet;

import model.User;
import service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/allUser")
public class AllUserServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        UserServiceImp userServiceImp = UserServiceImp.getInstance();
//        List<User> lists= userServiceImp.allUser();
//        request.setAttribute("list", lists);
//        request.getRequestDispatcher("//test.jsp").forward(request, response);
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImp userServiceImp = UserServiceImp.getInstance();
        List<User> lists= userServiceImp.allUser();
        request.setAttribute("lists", lists);
        request.getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
    }
}
