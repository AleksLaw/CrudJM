package DAO;


import model.User;

import java.util.List;

public interface UserDAO {
    boolean addUserDAO(User user);

    boolean delUserDAO(User user);

    boolean updateUserDAO(User userOld, User userNew);

    List<User> allUserDAO();

}
