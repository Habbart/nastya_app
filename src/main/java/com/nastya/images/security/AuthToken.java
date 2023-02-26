package com.nastya.images.security;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class AuthToken {
    private String token;

}
