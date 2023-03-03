package com.nastya.images.dao;

import com.nastya.images.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserDao extends JpaRepository<User, UUID> {

    User findByLogin(String login);
}