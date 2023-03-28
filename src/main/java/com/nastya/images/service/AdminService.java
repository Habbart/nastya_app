package com.nastya.images.service;


import com.nastya.images.repository.UserRepository;
import com.nastya.images.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private UserRepository userRepository;

    public UserEntity findByLogin(String userName) {
        return userRepository.findByLogin(userName);
    }
}
