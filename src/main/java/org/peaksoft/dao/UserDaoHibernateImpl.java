package org.peaksoft.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.peaksoft.model.User;
import org.peaksoft.util.Util;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        String sql = " CREATE TABLE IF NOT EXISTS users  " +
                "(id BIGSERIAL PRIMARY KEY ," +
                " name VARCHAR (55) NOT NULL," +
                " last_name VARCHAR (55) NOT NULL," +
                " age INT2 NOT NULL)";
        Session session = Util.hibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery(sql).executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Added succesfully");

    }

    @Override
    public void dropUsersTable() {
        String sql = " DROP TABLE users";
        Session session = Util.hibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery(sql).executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in User");
    }


    @Override
    public void saveUser(String name, String lastName, byte age) {
        SessionFactory sessionFactory = Util.hibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        session.save(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated!");


    }

    @Override
    public void removeUserById(long id) {
        SessionFactory sessionFactory = Util.hibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.hibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> user = session.createQuery(
                "FROM User").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded " + user.size() + " user");
        return user;


    }


    @Override
    public void cleanUsersTable() {
        Session session = Util.hibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM User ").executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in User");
    }

}
