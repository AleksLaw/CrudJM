package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserDAOFactory {
    private String typeDao;
    private DAOmaker dAOmaker;
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
            this.typeDao = property.getProperty("type");
            System.out.println("HOST: " + typeDao);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        dAOmaker = getdAOmaker(typeDao);
        userDAO = dAOmaker.createDAO();
    }

    public DAOmaker getdAOmaker(String maker) {
        DAOmaker daOmaker = null;
        if (maker.equals("Hiber")) {
            daOmaker = new UserDAOHibernateMaker();
        }
        if (maker.equals("Jdbc")) {
            daOmaker = new UserDAOJDBCMaker();
        }
        return daOmaker;
    }
}

interface DAOmaker {
    UserDAO createDAO();
}

class UserDAOHibernateMaker implements DAOmaker {

    @Override
    public UserDAO createDAO() {
        return UserDAOHibernate.getInstance();
    }
}

class UserDAOJDBCMaker implements DAOmaker {

    @Override
    public UserDAO createDAO() {
        return UserDAOJdbc.getInstance();
    }
}