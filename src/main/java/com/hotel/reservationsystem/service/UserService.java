package com.hotel.reservationsystem.service;

import com.hotel.reservationsystem.entity.User;

import java.util.List;

public interface UserService {
    User register(User user);
    User updateUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    List<User> getAllUsers();
    User findUserByEmail(String email);
}
