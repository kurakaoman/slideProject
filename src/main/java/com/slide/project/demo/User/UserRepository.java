package com.slide.project.demo.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    UserDetails findByUsername(String username);
}
