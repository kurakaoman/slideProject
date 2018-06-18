package com.slide.project.demo.roles.commons;

import com.slide.project.demo.roles.customer.CustomerDetailsServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@RestController
public class LoginController {

    private UserServiceImpl userService ;


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

    @GetMapping("/user")
    public ModelAndView showUserPanel(String name, String password){
        ModelAndView model = new ModelAndView();
        model.addObject("User",userService.loadUserByUsername(name));
        if (userService.loadUserByUsername(name).getAuthorities().equals(Collections.singletonList(new SimpleGrantedAuthority("ADMIN_CUSTOMER")))){
            model.setViewName("/page/profilPage/adminPanel.html");
        }else if(userService.loadUserByUsername(name).getAuthorities().equals(Collections.singletonList(new SimpleGrantedAuthority("MANAGER_CUSTOMER")))){
            model.setViewName("/page/profilPage/managerPanel.html");
        }else {
            model.setViewName("/page/profilPage/customerPanel.html");
        }
        return model;
    }

}
