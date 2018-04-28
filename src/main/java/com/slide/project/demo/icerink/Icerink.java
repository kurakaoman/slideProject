package com.slide.project.demo.icerink;

import com.slide.project.demo.common.Adress;
import com.slide.project.demo.customer.Customer;
import com.slide.project.demo.icerink.additional.Additional;
import com.slide.project.demo.icerink.slide.Slide;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Icerink {
    Long icerinkId;
    String name;
    List<String> phoneNumber;
    String website;
    Adress adress;
    Slide slide;
    List<Additional> additionals;
    //Map<Date,Slide> slides;?
    //Date timetable;?


    public Icerink(Long icerinkId, String name, List<String> phoneNumber, String website, Adress adress, Slide slide, List<Additional> additionals) {
        this.icerinkId = icerinkId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.adress = adress;
        this.slide = slide;
        this.additionals = additionals;
    }

    public Long getIcerinkId() {
        return icerinkId;
    }

    public void setIcerinkId(Long icerinkId) {
        this.icerinkId = icerinkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Slide getSlide() {
        return slide;
    }

    public void setSlide(Slide slide) {
        this.slide = slide;
    }

    public List<Additional> getAdditionals() {
        return additionals;
    }

    public void setAdditionals(List<Additional> additionals) {
        this.additionals = additionals;
    }
}
