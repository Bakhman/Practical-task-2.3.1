package com.bakh.practice.dao;


import com.bakh.practice.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * @author Bakhmai Begaev
 */
@Repository
public class UserDaoImpl implements UserDao{

    private EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createUsersTable() {
        String query = "CREATE TABLE IF NOT EXISTS users (" +
                "id       BIGINT          NOT NULL AUTO_INCREMENT, " +
                "name     VARCHAR(255)  NOT NULL, " +
                "lastName VARCHAR(255)  NOT NULL, " +
                "age      TINYINT      NOT NULL, PRIMARY KEY (id));";

        entityManager.getTransaction().begin();
        entityManager.createNativeQuery(query).executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public void dropUsersTable() {
        String query = "DROP TABLE IF EXISTS users";
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery(query).executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public void add(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeUserById(long id) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from User where id = :id")
                .setParameter("id", id)
                .executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        entityManager.getTransaction().begin();
        List<User> userList = entityManager.createQuery("select i from User i")
                .getResultList();
        entityManager.getTransaction().commit();
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from User")
                        .executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public void editUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public User getUserById(long id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("Can't find User for such ID" + id);
        }
        entityManager.getTransaction().commit();
        return user;
    }
}
