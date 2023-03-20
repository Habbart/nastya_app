package com.nastya.images.dao;

import com.nastya.images.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserDao extends JpaRepository<UserEntity, UUID> {

    UserEntity findByLogin(String login);
}