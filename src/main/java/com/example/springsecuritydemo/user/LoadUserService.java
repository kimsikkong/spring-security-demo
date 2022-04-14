package com.example.springsecuritydemo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoadUserService {

    private final UserRepository userRepository;

    @Autowired
    public LoadUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
