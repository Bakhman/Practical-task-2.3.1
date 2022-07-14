package com.bakh.practice;

import com.bakh.practice.config.JavaConfig;
import com.bakh.practice.model.User;
import com.bakh.practice.service.UserServiceImpl;

import javax.persistence.EntityManager;


/**
 * @author Bakhmai Begaev
 */
public class TestUser {
    public static void main(String[] args) {

        //jpaExample();
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.createUsersTable();
//        User user = new User("Robin", "Hood", (byte) 29);
//        User user1 = new User("Jon", "Doe", (byte) 33);
//        User user2 = new User("Alan", "Wake", (byte) 49);
//        User user3 = new User("Arnold", "Schwarzenegger", (byte) 74);
//        userService.add(user);
//        userService.add(user1);
//        userService.add(user2);
//        userService.add(user3);

//        User user = userService.getUserById(2L);
//        user.setName("Bakhmai");
//        user.setLastName("Begaev");
//        user.setAge((byte) 48);
//        userService.editUser(user);
//        userService.removeUserById(2L);
//        userService.getAllUsers().forEach(user -> System.out.println(user));
//        userService.cleanUsersTable();
//        userService.dropUsersTable();


    }

    private static void jpaExample() {
        EntityManager em = new JavaConfig().em();
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        em.getTransaction().begin();

        //EntityManager em = emf.createEntityManager();
        //em.createNativeQuery(query).executeUpdate();
        em.getTransaction().commit();

        /*em.getTransaction().begin();
        em.createNativeQuery("delete from users where id = 2").executeUpdate();



        User user = new User("Robin","Hood",(byte) 29);
        em.persist(user);
        System.out.println(user);

        em.getTransaction().commit();

        //em.close();

        //em = emf.createEntityManager();
        List<User> userList = em.createQuery("select i from User i")
                .getResultList();
        userList.forEach(p1 -> System.out.println(p1));*/

        em.close();
    }


}
