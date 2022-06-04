package org.peaksoft.service;

import org.peaksoft.dao.UserDaoJdbcImpl;
import org.peaksoft.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();

    public void createUsersTable() {
        userDaoJdbc.createUsersTable();

    }

    public void dropUsersTable() {
        userDaoJdbc.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {

        return userDaoJdbc.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoJdbc.cleanUsersTable();
    }
}