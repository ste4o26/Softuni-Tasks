package com.spirng_demo.services;

import com.spirng_demo.entities.User;
import com.spirng_demo.repositories.UserRepository;
import com.spirng_demo.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        User fetchedUser = this.userRepository.getByUsername(user.getUsername());

        if (fetchedUser != null) {
            throw new IllegalArgumentException(String.format("User with username: %s already exits!", user.getUsername()));
        }

        this.userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        User user = this.userRepository.getByUsername(username);
        if(user == null){
            throw new IllegalArgumentException(String.format("Could not find user with username: %s", username));
        }

        return user;
    }
}
