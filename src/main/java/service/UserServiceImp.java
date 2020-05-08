package service;

import DAO.UserDAO;
import DAO.UserDAOFactory;
import model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserServiceImp implements UserService {
    private static UserServiceImp userServiceImp;
    private UserDAO userDAO;

    public static UserServiceImp getInstance() {
        if (userServiceImp == null) {
            userServiceImp = new UserServiceImp();
        }
        return userServiceImp;
    }

    public UserServiceImp() {
        userDAO = new UserDAOFactory().getUserDAO();
    }

    @Override
    public List<User> allUser() {
        ArrayList<User> list = (ArrayList<User>) userDAO.allUserDAO();
        list.sort(Comparator.comparing(User::getId));
        return list;
    }

    @Override
    public boolean addUser(User user) {
        if (!validateUserIsEmpty(user)) {
            return false;
        }
        if (userDAO.getUserIdByName(user.getName(), user.getPassword()) != null ) {
            return false;
        }
        return userDAO.addUserDAO(user);
    }

    @Override
    public boolean delUser(Long id) {

        return userDAO.delUserDAO(id);
    }

    @Override
    public boolean updateUser(Long id, User userNew) {
        if (!validateUserIsEmpty(userNew)) {
            return false;
        }
        return userDAO.updateUserDAO(id, userNew);
    }

    public boolean validateUserIsEmpty(User userNew) {
        if ("".equals(userNew.getName()) || "".equals(userNew.getPassword()) || "".equals(userNew.getRole())) {
            return false;
        }
        return userNew.getName() != null && userNew.getPassword() != null && userNew.getRole() != null;
    }

    @Override
    public Long getUserIdByName(String name, String password) {
        return userDAO.getUserIdByName(name, password);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

}
