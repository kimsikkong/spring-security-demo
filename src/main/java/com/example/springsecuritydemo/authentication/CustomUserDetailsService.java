package com.example.springsecuritydemo.authentication;

import com.example.springsecuritydemo.user.LoadUserService;
import com.example.springsecuritydemo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final LoadUserService loadUserService;

    @Autowired
    public CustomUserDetailsService(LoadUserService loadUserService) {
        this.loadUserService = loadUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = loadUserService.loadUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Could not find user with given username. username : " + username));
        return new CustomUserDetails(user);
    }
}
