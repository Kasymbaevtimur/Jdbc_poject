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
        userDaoJdbc.saveUser("Karim", "Benzema", (byte) 34);
        userDaoJdbc.saveUser("Luka", "Modric", (byte) 36);
        userDaoJdbc.saveUser("Toni", "Kroos", (byte) 32);
        userDaoJdbc.saveUser("Federico", "Valverde", (byte) 23);
        userDaoJdbc.saveUser("Eduardo", "Camavinga", (byte) 19);
    }

    public void removeUserById(long id) {
        userDaoJdbc.removeUserById(2);
    }

    public List<User> getAllUsers() {

        return userDaoJdbc.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoJdbc.cleanUsersTable();
    }
}