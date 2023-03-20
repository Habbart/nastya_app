package com.nastya.images.dao;

import com.nastya.images.entity.RoleEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserEntityDaoTest {
    @Autowired
    private RoleDao roleDao;


    @Test
    void saveTest() {

        RoleEntity role = new RoleEntity();
        role.setName("role233");

        RoleEntity role2 = roleDao.save(role);

        System.out.println(role2);
    }
}