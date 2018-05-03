package com.slide.project.demo.roles.customer;

import com.slide.project.demo.common.Address;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

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
//    @OneToMany(targetEntity=Icerink.class, fetch=FetchType.EAGER)//<<ODKOMENTUJ>>//
//    private List<Icerink> icerinkList;//<<ODKOMENTUJ>>//
//    @OneToMany(targetEntity=Icerink.class, fetch=FetchType.EAGER) //<<ODKOMENTUJ>>//
//    private List<Icerink> favoritesIcerink; //<<ODKOMENTUJ>>//
    private String password;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="adress_id", unique = true)
    private Address address;
//    private Slide slide; //List<Slide> slides;
//    @OneToMany(fetch = FetchType.EAGER) //mappedBy = "icerink"
//    private Admin admin;

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



//    public List<Icerink> getIcerinkList() {return icerinkList;}//<<ODKOMENTUJ>>//

//    public void setIcerinkList(List<Icerink> icerinkList) {this.icerinkList = icerinkList;}//<<ODKOMENTUJ>>//

//    public List<Icerink> getFavoritesIcerink() {return favoritesIcerink;}//<<ODKOMENTUJ>>//

//    public void setFavoritesIcerink(List<Icerink> favoritesIcerink) {this.favoritesIcerink = favoritesIcerink;}//<<ODKOMENTUJ>>//



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


//    public Admin getAdmin() {
//        return admin;
//    }

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
