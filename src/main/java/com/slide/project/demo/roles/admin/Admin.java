package com.slide.project.demo.roles.admin;

import com.slide.project.demo.roles.customer.Customer;
import com.slide.project.demo.roles.manager.Manager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.security.PublicKey;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Entity
public class Admin implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private List<Customer> customerList;
    private List<Manager> managerList;

    public Admin(){

    }

    public Admin(String username, String password, List<Customer> customerList, List<Manager> managerList) {
        this.username = username;
        this.password = password;
        this.customerList = customerList;
        this.managerList = managerList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public List<Manager> getManagerList() {
        return managerList;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
