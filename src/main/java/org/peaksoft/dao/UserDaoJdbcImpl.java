package org.peaksoft.dao;

import org.peaksoft.model.User;
import org.peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {
            String SQL = " CREATE TABLE IF NOT EXISTS users  " +
                    "(id BIGSERIAL PRIMARY KEY ," +
                    " name VARCHAR (55) NOT NULL," +
                    " lastName VARCHAR (55) NOT NULL," +
                    " age INT2 NOT NULL)";
            statement.executeUpdate(SQL);
            System.out.println("Table is succesfully created");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void dropUsersTable() {
        String sql = " DROP TABLE users";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            String SQL = " insert into users(name,lastName,age) values(?,?,?)";
            Connection connection = Util.connection();
            PreparedStatement prep = connection.prepareStatement(SQL);
            prep.setString(1, name);
            prep.setString(2, lastName);
            prep.setByte(3, age);
            prep.executeUpdate();
            System.out.println(" Succesfully added  " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM users WHERE id=?;";
        try (Connection connection = Util.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> list = new ArrayList<>();
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    public void cleanUsersTable() {
        String sql = " TRUNCATE TABLE  users";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
