package com.slide.project.demo.roles.commons;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    UserDetails findByUsername(String username);
}
