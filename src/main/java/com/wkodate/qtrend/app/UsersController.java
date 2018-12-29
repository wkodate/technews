package com.wkodate.qtrend.app;

import com.wkodate.qtrend.domain.model.User;
import com.wkodate.qtrend.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.findOne(id);
    }

}
