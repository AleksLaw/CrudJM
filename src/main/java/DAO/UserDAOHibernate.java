package DAO;


import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import util.DBHelper;

import java.util.List;


public class UserDAOHibernate implements UserDAO {
    protected static UserDAOHibernate userDAOHibernate;
    private static SessionFactory sessionFactory;

    public static UserDAOHibernate getInstance() {
        if (userDAOHibernate == null) {
            userDAOHibernate = new UserDAOHibernate();
            sessionFactory = getSessionFactory();
        }
        return userDAOHibernate;
    }

    UserDAOHibernate() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }


    private static SessionFactory createSessionFactory() {
        DBHelper dbHelper = DBHelper.getInstance();
        Configuration configuration = dbHelper.getConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(builder.build());
    }

    @Override
    @SuppressWarnings("UnusedDeclaration")
    public boolean addUserDAO(User user) {
        int beforeAdd = 0;
        int afterAdd = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        beforeAdd = session.createCriteria(User.class).list().size();
        afterAdd = session.createCriteria(User.class).list().size();
        try {
            session.save(user);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return beforeAdd <= afterAdd;
    }


    @Override
    @SuppressWarnings("UnusedDeclaration")
    public boolean delUserDAO(Long id) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        int beforeAdd = session.createCriteria(User.class).list().size();
        try {
            session.delete(user);
        } catch (Exception e) {
            transaction.rollback();
        }
        transaction.commit();
        int afterAdd = session.createCriteria(User.class).list().size();
        session.close();
        return beforeAdd > afterAdd;
    }

    @Override
    public boolean updateUserDAO(Long id, User userNew) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User userUpdate = session.get(User.class, id);
        userUpdate.setName(userNew.getName());
        userUpdate.setPassword(userNew.getPassword());
        userUpdate.setRole(userNew.getRole());
        int beforeUpdate = session.createCriteria(User.class).list().size();
        try {
            session.update(userUpdate);
        } catch (Exception e) {
            transaction.rollback();
        }
        int afterUpdate = session.createCriteria(User.class).list().size();
        transaction.commit();
        session.close();
        return beforeUpdate == afterUpdate;
    }

    @Override
    @SuppressWarnings("UnusedDeclaration")
    public List<User> allUserDAO() {
        Session session = sessionFactory.openSession();
        List<User> list = (List<User>) session.createCriteria(User.class).list();
        session.close();
        return list;
    }

    @Override
    public Long getUserIdByName(String name, String password) {
        Session session = sessionFactory.openSession();
        List<User> listUser = session.createCriteria(User.class).
                add(Restrictions.eq("name", name)).
                add(Restrictions.eq("password", password)).
                list();
        session.close();
        if (listUser.size() != 0) {
            User userGet = listUser.get(0);
            Long id = userGet.getId();
            return id;
        }
        return null;
    }

    @Override
    @SuppressWarnings("UnusedDeclaration")
    public User getUserById(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }
}
