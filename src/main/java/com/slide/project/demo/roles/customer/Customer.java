package com.slide.project.demo.roles.customer;

import com.slide.project.demo.common.Address;
import com.slide.project.demo.icerink.Icerink;
import com.slide.project.demo.icerink.slide.Slide;
import com.slide.project.demo.roles.admin.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
    @ManyToMany(fetch=FetchType.EAGER, mappedBy = "participants")
    private Set<Slide> slides; //ślizgawki na które się zapisał urzytkownik

    @ManyToMany(targetEntity=Icerink.class, fetch=FetchType.EAGER)
    private Set<Icerink> icerinkList;
    @ManyToMany(targetEntity=Icerink.class, fetch=FetchType.EAGER)
    private Set<Icerink> favoritesIcerink;
    private String password;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="adress_id", unique = true)
    private Address address;
    //    private Slide slide; //List<Slide> slides;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id",unique = true)
    private Admin admin;

    public Customer(){}

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

    public Set<Slide> getSlides() {
        return slides;
    }

    public void setSlides(Set<Slide> slides) {
        this.slides = slides;
    }

    public Set<Icerink> getIcerinkList() {return icerinkList;}//<<ODKOMENTUJ>>//

    public void setIcerinkList(Set<Icerink> icerinkList) {this.icerinkList = icerinkList;}//<<ODKOMENTUJ>>//

    public Set<Icerink> getFavoritesIcerink() {return favoritesIcerink;}//<<ODKOMENTUJ>>//

    public void setFavoritesIcerink(Set<Icerink> favoritesIcerink) {this.favoritesIcerink = favoritesIcerink;}//<<ODKOMENTUJ>>//



    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
//
//    public Slide getSlide() {
//        return slide;
//    }
//
//    public void setSlide(Slide slide) {
//        this.slide = slide;
//    }


    public Admin getAdmin() {
        return admin;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
