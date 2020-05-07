package service;

import DAO.UserDAOHibernate;
import DAO.UserDAOJdbc;
import model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserService {
    private static UserService userService;
    //   private UserDAOHibernate userDAO;
    private UserDAOJdbc userDAO;

    public static UserService getInstance() {
        if (userService == null) {
            //         userService = new UserService(UserDAOHibernate.getInstance());
            userService = new UserService();

        }
        return userService;
    }

    //  public UserService(UserDAOHibernate userDAO) {
    private UserService() {
        userDAO=UserDAOJdbc.getInstance();
    }

    public List<User> allUser() {
        ArrayList<User> list = (ArrayList<User>) userDAO.allUserDAO();
        list.sort(Comparator.comparing(User::getId));
        return list;
    }

    public boolean addUser(User user) {
        return userDAO.addUserDAO(user);
    }

    public boolean delUser(int id) {
        return userDAO.delUserDAO(id);
    }

    public boolean updateUser(User userOld, User userNew) {
        return userDAO.updateUserDAO(userOld, userNew);
    }
public boolean updateUser(int id, User userNew) {
        return userDAO.updateUserDAO(id, userNew);
    }

}
