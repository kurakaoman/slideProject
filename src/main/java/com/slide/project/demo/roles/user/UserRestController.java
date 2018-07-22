package com.slide.project.demo.roles.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/register")
public class UserRestController {

    private  final UserDetailsServiceImpl userDetailsService;

    UserRestController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    @PostMapping("/newUser")
    public Long createUser(@RequestBody User user) {
        return userDetailsService.create(user);
    }


}
