package com.demo.user.service.service;

import com.demo.user.service.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(String userId);

}
