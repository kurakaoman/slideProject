package com.slide.project.demo.roles.admin;

import com.slide.project.demo.roles.customer.Customer;
import com.slide.project.demo.roles.manager.Manager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.security.PublicKey;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
public class Admin implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "admin")
    private Set<Customer> customerList;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "admin")
    private List<Manager> managerList;

    public Admin(){

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

    public long getId() {
        return id;
    }

    public Set<Customer> getCustomerList() {return customerList;}

    public List<Manager> getManagerList() {return managerList;}

    public void setCustomerList(Set<Customer> customerList) {
        this.customerList = customerList;
    }

    public void setManagerList(List<Manager> managerList) {
        this.managerList = managerList;
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
