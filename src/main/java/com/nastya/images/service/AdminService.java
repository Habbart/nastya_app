package com.nastya.images.service;


import com.nastya.images.dao.UserDao;
import com.nastya.images.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private UserDao userDao;

    public UserEntity findByLogin(String userName) {
        return userDao.findByLogin(userName);
    }
}
