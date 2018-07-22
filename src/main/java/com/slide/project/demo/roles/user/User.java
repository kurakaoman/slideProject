package com.slide.project.demo.roles.user;

import com.slide.project.demo.roles.admin.Admin;
import com.slide.project.demo.roles.customer.Customer;
import com.slide.project.demo.roles.manager.Manager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String phoneNumber;
    private Admin admin;
    private Customer customer;
    private Manager manager;

    public User(){

    }

    public User(String username,String password,String phoneNumber,Admin admin,Customer customer,Manager manager){
        this.username =username;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.admin=admin;
        this.customer=customer;
        this.manager=manager;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public long getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
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

    public static class Builder{
        //required
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String username;
        private String password;
        //optional
        private String phoneNumber;
        private Admin admin;
        private Customer customer;
        private Manager manager;

        public Builder(String username,String password){
            this.username = username;
            this.password = password;
        }
        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder admin(Admin admin){
            this.admin=admin;
            return this;
        }
        public Builder customer(Customer customer){
            this.customer = customer;
            return this;
        }
        public Builder manager(Manager manager){
            this.manager = manager;
            return this;
        }
        public  User build(){
            return new User(username,password,phoneNumber,admin,customer,manager);

        }
    }
    private User(Builder builder){
        this.username = builder.username;
        this.password = builder.password;
        this.phoneNumber = builder.phoneNumber;
        this.customer = builder.customer;
        this.manager = builder.manager;
        this.admin = builder.admin;
    }

    @Override
    public String toString(){
        return "User{"+ System.lineSeparator() +
                "username: " +username + System.lineSeparator() +
                "password: ****" + System.lineSeparator() +
                "phoneNumber: " + phoneNumber + System.lineSeparator() +
                "customer: " + customer.toString() + System.lineSeparator() +
                "manager: " + manager.toString() + System.lineSeparator() +
                "admin: " + admin.toString() + System.lineSeparator() +
                "}";
    }

}
