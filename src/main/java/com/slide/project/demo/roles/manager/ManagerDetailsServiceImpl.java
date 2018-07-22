package com.slide.project.demo.roles.manager;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ManagerDetailsServiceImpl implements UserDetailsService {
    private ManagerRepository managerRepository;

    public ManagerDetailsServiceImpl(ManagerRepository managerRepository){
        this.managerRepository = managerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return managerRepository.findByUsername(username);
    }
    public Manager create01(Manager manager) {
        return managerRepository.save(manager);
    }
}
