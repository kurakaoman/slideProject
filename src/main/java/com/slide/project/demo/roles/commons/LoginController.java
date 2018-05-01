package com.slide.project.demo.roles.commons;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/demo/slide/project")
    public String getCredentials(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String result = String.join("",authentication.getAuthorities().stream().map(a -> a.getAuthority()).toArray(String[]::new));
        return result;
    }
    @PostMapping("/auth/login")
    public boolean login() {
        return true;
    }

    @GetMapping("auth/check")
    public void checkAuth() {}
}
