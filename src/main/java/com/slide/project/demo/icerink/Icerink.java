package com.slide.project.demo.icerink;

import com.slide.project.demo.common.Address;
import com.slide.project.demo.icerink.additional.Additional;
import com.slide.project.demo.icerink.slide.Slide;

import javax.persistence.*;
import java.util.List;

@Entity
public class Icerink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long icerinkId;
    private String name;
    private List<String> phoneNumber;
    private String website;
    private Address address;
    @OneToMany(targetEntity = Slide.class, mappedBy = "icerink")
    private List<Slide> slides;
    private List<Additional> additionals;
    //Map<Date,Slide> slides;?
    //Date timetable;?


    public Icerink(Long icerinkId, String name, List<String> phoneNumber, String website, Address address, List<Slide> slides, List<Additional> additionals) {
        this.icerinkId = icerinkId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.address = address;
        this.slides = slides;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Slide> getSlides() {
        return slides;
    }

    public void setSlides(List<Slide> slides) {
        this.slides = slides;
    }

    public List<Additional> getAdditionals() {
        return additionals;
    }

    public void setAdditionals(List<Additional> additionals) {
        this.additionals = additionals;
    }
}
