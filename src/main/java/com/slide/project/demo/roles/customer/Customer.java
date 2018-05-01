package com.slide.project.demo.roles.customer;

import com.slide.project.demo.common.Address;
import com.slide.project.demo.icerink.Icerink;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table
public class Customer implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String emailaddress;
    private int age;
    private List<Icerink> icerinkList;
    private List<Icerink> favoritesIcerink;
    private String password;
    private Address location;

    public Address getLocation() {
        return location;
    }
    public Customer(){}

    public Customer(String name, String surname, String emailaddress, int age, List<Icerink> icerinkList, List<Icerink> favoritesIcerink, String password) {
        this.name = name;
        this.surname = surname;
        this.emailaddress = emailaddress;
        this.age = age;
        this.icerinkList = icerinkList;
        this.favoritesIcerink = favoritesIcerink;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Icerink> getIcerinkList() {
        return icerinkList;
    }

    public void setIcerinkList(List<Icerink> icerinkList) {
        this.icerinkList = icerinkList;
    }

    public List<Icerink> getFavoritesIcerink() {
        return favoritesIcerink;
    }

    public void setFavoritesIcerink(List<Icerink> favoritesIcerink) {
        this.favoritesIcerink = favoritesIcerink;
    }

    @Override
    public String getUsername() {
        return name;
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
