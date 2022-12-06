package com.example.users.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;

public class SecureLoginPassword {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("kkk"));
    }
}
