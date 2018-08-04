package com.slide.project.demo.roles.manager;

import com.slide.project.demo.icerink.Icerink;
import com.slide.project.demo.roles.admin.Admin;
import com.slide.project.demo.roles.customer.Customer;
import com.slide.project.demo.roles.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Entity
public class Manager implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int managerId;
    private String username;
    private String password;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "manager")
    private List<Icerink> icerinkList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id",unique = true)
    private Admin admin;
    //@ManyToMany(fetch = FetchType.EAGER)
    @OneToOne
    private User user;

    public Manager(){}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_MANAGER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public List<Icerink> getIcerinkList() {return icerinkList;}

    public void setIcerinkList(List<Icerink> icerinkList) { this.icerinkList = icerinkList; }

    public Admin getAdmin() {
        return admin;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
