package DAO;


import model.User;

import java.util.List;

public interface UserDAO {
    boolean addUserDAO(User user);

    boolean delUserDAO(Long id);

    boolean updateUserDAO(Long id, User userNew);

    List<User> allUserDAO();

}
