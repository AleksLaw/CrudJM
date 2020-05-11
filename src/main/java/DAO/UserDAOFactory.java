package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserDAOFactory {
    private static String typeDao;
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public UserDAOFactory() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            File file = new File(getClass().getClassLoader().getResource("config.properties").getFile());
            fis = new FileInputStream(file);
            property.load(fis);
            typeDao = property.getProperty("type");
            System.out.println("HOST: " + typeDao);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

        if (typeDao.equals("Hiber")) {
            userDAO = UserDAOHibernate.getInstance();
        }
        if (typeDao.equals("Jdbc")) {
            userDAO = UserDAOJdbc.getInstance();
        }
    }
}