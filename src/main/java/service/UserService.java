package service;

import model.User;

import java.util.List;

public interface UserService {
    public List<User> allUser() ;

    public boolean addUser(User user);

    public boolean delUser(Long id);

    public boolean updateUser(Long id, User userNew) ;

    Long getUserIdByName(String name, String password) ;

    User getUserById(Long id);
}
