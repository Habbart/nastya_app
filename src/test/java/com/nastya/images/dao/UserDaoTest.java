package com.nastya.images.dao;

import com.nastya.images.entity.Role;
import com.nastya.images.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.AllOf.allOf;


@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;


    @Test
    void saveTest() {
        User user = createUser(1);
        User actual = userDao.save(user);
//        System.err.println(actual);

        assertThat(actual, allOf(
                notNullValue(),
                allOf(
                        hasProperty("name", is("name1")),
                        hasProperty("login", is("login1")),
                        hasProperty("password", is("password1")),
                        hasProperty("role", allOf(
                                hasProperty("name", is("role1"))
                        ))
                )
        ));
    }


    private User createUser(int i) {
        User user = new User();
        user.setName("name" + i);
        user.setLogin("login" + i);
        user.setPassword("password" + i);
        Role role = new Role();
        role.setName("role" + 1);
        Role save = roleDao.save(role);
        user.setRole(save);
        return user;
    }


}