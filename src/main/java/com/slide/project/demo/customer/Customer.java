package com.slide.project.demo.customer;

import com.slide.project.demo.icerink.Icerink;

import java.util.List;

public class Customer {
    Long customerId;
    String name;
    String surname;
    String emailAdress;
    int age;
    List<Icerink> icerinkList;
    List<Icerink> favorites;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
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

    public List<Icerink> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Icerink> favorites) {
        this.favorites = favorites;
    }

    public Customer(Long customerId,String name, String surname, String emailAdress, int age) {
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.emailAdress = emailAdress;
        this.age = age;
    }
}
