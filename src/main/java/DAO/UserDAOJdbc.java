package DAO;


import model.User;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDAOJdbc implements UserDAO {
    private Connection connection;
    private static UserDAOJdbc userDAOJdbc;

    private UserDAOJdbc() {
        DBHelper dbHelper = DBHelper.getInstance();
        this.connection = dbHelper.getConnection();
    }

    public static UserDAOJdbc getInstance() {
        if (userDAOJdbc == null) {
            userDAOJdbc = new UserDAOJdbc();
        }
        return userDAOJdbc;
    }

    @Override
    public List<User> allUserDAO() {
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement prstm = connection.prepareStatement("select * from testdb.users");
            ResultSet result = prstm.executeQuery();
            while (result.next()) {
                Long tmpId = result.getLong(1);
                String tmpName = result.getString(2);
                String tmpPass = result.getString(3);
                User tmpUser = new User(tmpId, tmpName, tmpPass);
                list.add(tmpUser);
            }
            result.close();
            prstm.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public int count() {
        int i = 0;
        try {
            Statement statement = connection.
                    createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "select * from testdb.users";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.last();
            i = resultSet.getRow();
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean addUserDAO(User user) {
        int beforeAdd = count();
        try {
            PreparedStatement prstm = connection.prepareStatement(
                    "insert into testdb.users (name, surname)  values (?,?)");
            prstm.setString(1, user.getName());
            prstm.setString(2, user.getSurname());
            prstm.executeUpdate();
            prstm.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        int afterAdd = count();
        return beforeAdd <= afterAdd;
    }

    @Override
    public boolean delUserDAO(Long id) {
        int beforeDel = count();
        try {
            PreparedStatement prstm = connection.prepareStatement(
                    "select * from testdb.users where id = ? ",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            prstm.setLong(1, id);
            ResultSet result = prstm.executeQuery();
            result.next();
            result.deleteRow();
            result.close();
            prstm.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        int afterDel = count();
        return beforeDel > afterDel;
    }

    @Override
    public boolean updateUserDAO(Long id, User userNew) {
        int beforeUpdate = count();
        int afterUpdate = 0;
        try {
            PreparedStatement prstm = connection.prepareStatement(
                    "UPDATE  testdb.users SET name=?, surname=? WHERE id = ?;");
            prstm.setString(1, userNew.getName());
            prstm.setString(2, userNew.getSurname());
            prstm.setLong(3, id);
            afterUpdate = count();
            prstm.executeUpdate();
            prstm.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return beforeUpdate == afterUpdate;
    }

    public void createTable() throws SQLException {
        PreparedStatement prstm = connection.prepareStatement
                (
                        "create table if not exists users " +
                                "(id bigint auto_increment, name varchar(256)" +
                                ", surname varchar(256), primary key (id))"
                );
        prstm.executeUpdate();
        prstm.close();
    }

    public void dropTable() throws SQLException {
        PreparedStatement prstm = connection.prepareStatement(
                "DROP TABLE IF EXISTS users");
        prstm.executeUpdate();
        prstm.close();
    }
}
