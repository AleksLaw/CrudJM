package service;

import model.User;

import java.util.List;

public interface UserService {

    List<User> allUser();

    boolean addUser(User user);

    boolean delUser(Long id);

    boolean updateUser(Long id, User userNew);

    Long getUserIdByName(String name, String password);

    User getUserById(Long id);
}
