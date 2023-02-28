package com.nastya.images.dao;

import com.nastya.images.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByLogin(String login);
}