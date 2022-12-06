package com.example.users.service;


import com.example.users.model.User;

import java.util.List;

public interface UserService {
    User getByID(Long username);

    User getByUsername(String username);

    void save(User user);

    void deleteUser(Long username);

    List<User> getAll();
}
