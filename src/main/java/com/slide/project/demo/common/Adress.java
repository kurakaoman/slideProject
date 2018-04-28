package com.slide.project.demo.common;

public class Adress {
    Long adressId;
    String country;
    String state;
    String city;
    //String postalCode;
    String street;
    int hause;
    int flat;

    public Adress(Long adressId, String country, String state, String city, String street, int hause) {
        this.adressId = adressId;
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.hause = hause;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHause() {
        return hause;
    }

    public void setHause(int hause) {
        this.hause = hause;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }
    //int coordinateX;
    //int coordinateY;

}
