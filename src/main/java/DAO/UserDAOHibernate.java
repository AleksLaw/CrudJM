package DAO;


import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import util.DBHelper;

import java.util.List;


public class UserDAOHibernate implements UserDAO {
    private UserDAOHibernate userDAOHibernate;
    private SessionFactory sessionFactory;

    public UserDAOHibernate getInstance() {
        if (userDAOHibernate == null) {
            userDAOHibernate = new UserDAOHibernate();
            sessionFactory = getSessionFactory();
        }
        return userDAOHibernate;
    }

    private UserDAOHibernate() {
    }

    public SessionFactory getSessionFactory() {
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
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int beforeAdd = session.createCriteria(User.class).list().size();
        session.save(user);
        int afterAdd = session.createCriteria(User.class).list().size();
        transaction.commit();
        session.close();
        return beforeAdd <= afterAdd;
    }

    @Override
    @SuppressWarnings("UnusedDeclaration")
    public boolean delUserDAO(User user) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Long id = findUserDAO(user);
        User user1 = session.load(User.class, id);
        int beforeAdd = session.createCriteria(User.class).list().size();
        session.delete(user1);
        int afterAdd = session.createCriteria(User.class).list().size();
        transaction.commit();
        session.close();
        return beforeAdd > afterAdd;
    }

    @Override
    @SuppressWarnings("UnusedDeclaration")
    public boolean updateUserDAO(User userOld, User userNew) {
        Session session = sessionFactory.openSession();
        List<User> listUser = session.createCriteria(User.class).
                add(Restrictions.eq("name", userOld.getName())).
                add(Restrictions.eq("surname", userOld.getSurname())).
                list();
        User userGet = listUser.get(0);
        Transaction transaction = session.beginTransaction();
        User userUpdate = session.load(User.class, userGet.getId());
        userUpdate.setName(userNew.getName());
        userUpdate.setSurname(userNew.getSurname());
        int beforeUpdate = session.createCriteria(User.class).list().size();
        session.update(userUpdate);
        int afterUpdate = session.createCriteria(User.class).list().size();
        transaction.commit();
        session.close();
        return beforeUpdate == afterUpdate;

    }

    @SuppressWarnings("UnusedDeclaration")
    public Long findUserDAO(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> listUser = session.createCriteria(User.class).
                add(Restrictions.eq("name", user.getName())).
                add(Restrictions.eq("surname", user.getSurname())).
                list();

        transaction.commit();
        session.close();
        if (listUser.size() != 0) {
            User userGet = listUser.get(0);
            Long id = userGet.getId();
            return id;
        }
        return null;
    }

    @SuppressWarnings("UnusedDeclaration")
    public User getUserByIdDAO(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    @SuppressWarnings("UnusedDeclaration")
    public List<User> allUserDAO() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = (List<User>) session.createCriteria(User.class).list();
        transaction.commit();
        session.close();
        return list;
    }
}
