package com.spirng_demo.services.interfaces;

import com.spirng_demo.entities.User;

public interface UserService {
    void registerUser(User user);
    User findUserByUsername(String username);
}
