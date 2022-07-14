package com.bakh.practice.dao;

import com.bakh.practice.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bakhmai Begaev
 */
public interface UserDao {

    void createUsersTable();

    void dropUsersTable();

    void add(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();

    void editUser(User user);

    User getUserById(long id);
}
