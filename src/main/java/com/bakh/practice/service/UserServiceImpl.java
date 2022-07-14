package com.bakh.practice.service;

import com.bakh.practice.config.JavaConfig;
import com.bakh.practice.dao.UserDaoImpl;
import com.bakh.practice.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Bakhmai Begaev
 */
@Component
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    UserDaoImpl userDao = new UserDaoImpl(new JavaConfig().em());

    @Override
    public void createUsersTable() {
        userDao.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    @Override
    public void add(User user){userDao.add(user);}

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }

    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }
}
