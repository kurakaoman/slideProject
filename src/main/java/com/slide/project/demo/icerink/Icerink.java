package com.slide.project.demo.icerink;

import com.slide.project.demo.common.Address;
import com.slide.project.demo.common.MobileNumber;
import com.slide.project.demo.icerink.additional.Additional;
import com.slide.project.demo.icerink.slide.Slide;
import com.slide.project.demo.roles.customer.Customer;
import com.slide.project.demo.roles.manager.Manager;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Icerink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long icerinkId;
    private String name;
    @ElementCollection(fetch = FetchType.EAGER) // Many to many?????
    //@PhoneNumbers
    private Set<String> phoneNumber = new HashSet<>();
    private String website;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adress_id", unique = true)
    private Address address;
//    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "mobileNumber_icerink")
//potem możesz to usunąć i zostawić tylko phoneNumber ten wyżej :-)))
    //private Set<MobileNumber> mobileNumber; //potem możesz to usunąć i zostawić tylko phoneNumber ten wyżej :-)))
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "icerink")
    private List<Slide> slides;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", unique = true, insertable = false, updatable = false)
    private Manager manager;
    @ElementCollection(fetch = FetchType.EAGER)
    @ManyToMany
    private Set<Additional> additionals;
    //    @OneToMany(fetch = FetchType.EAGER) //mappedBy = "icerink"
//    private Manager manager;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", unique = true)
    private Customer closeCustomer; //List<Customer>;
//    private Customer fun;//List<Customer>;
    //Map<Date,Slide> slides;?
    //Date timetable;?


    public Icerink() {
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

    public Set<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Set<String> phoneNumber) {
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

    public Set<Additional> getAdditionals() {
        return additionals;
    }

    public void setAdditionals(Set<Additional> additionals) {
        this.additionals = additionals;
    }


    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

}
