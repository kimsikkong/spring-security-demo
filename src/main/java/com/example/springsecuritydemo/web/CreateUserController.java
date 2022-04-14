package com.example.springsecuritydemo.web;

import com.example.springsecuritydemo.user.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateUserController {

    private final CreateUserService createUserService;

    @Autowired
    public CreateUserController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    @PostMapping(value = "/user")
    public String create(String username, String password, String email) {
        createUserService.create(username, password, email);
        return "/login";
    }
}
