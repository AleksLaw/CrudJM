package service;

import DAO.UserDAOHibernate;
import model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserServiceImp implements UserService {
    private static UserServiceImp userServiceImp;
    private UserDAOHibernate userDAO;
    //  private UserDAOJdbc userDAO;

    public static UserServiceImp getInstance() {
        if (userServiceImp == null) {
            //         userService = new UserService(UserDAOHibernate.getInstance());
            userServiceImp = new UserServiceImp();

        }
        return userServiceImp;
    }

    public UserServiceImp() {
        // userDAO = UserDAOJdbc.getInstance();
        userDAO = UserDAOHibernate.getInstance();
    }

    @Override
    public List<User> allUser() {
        ArrayList<User> list = (ArrayList<User>) userDAO.allUserDAO();
        list.sort(Comparator.comparing(User::getId));
        return list;
    }

    @Override
    public boolean addUser(User user) {
        return userDAO.addUserDAO(user);
    }

    @Override
    public boolean delUser(Long id) {
        return userDAO.delUserDAO(id);
    }

    @Override
    public boolean updateUser(Long id, User userNew) {
        return userDAO.updateUserDAO(id, userNew);
    }

}
