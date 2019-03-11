package com.ronalds.inventory_project.service;

import com.ronalds.inventory_project.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User saveUser(User user);

}
