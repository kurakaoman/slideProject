package com.slide.project.demo.icerink;

import com.slide.project.demo.common.Address;
import com.slide.project.demo.icerink.additional.Additional;
import com.slide.project.demo.icerink.slide.Slide;
import com.slide.project.demo.roles.customer.Customer;
import com.slide.project.demo.roles.manager.Manager;

import javax.persistence.*;
import java.util.List;

@Entity
public class Icerink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long icerinkId;
    private String name;
//    private List<String> phoneNumber;  //<<ODKOMENTUJ>>//
    private String website;
    private Address address;
//    @OneToMany(fetch = FetchType.EAGER) //mappedBy = "icerink" //<<ODKOMENTUJ>>//
//    private List<Slide> slides; //<<ODKOMENTUJ>>//
//    private List<Additional> additionals; //<<ODKOMENTUJ>>//
//    @OneToMany(fetch = FetchType.EAGER) //mappedBy = "icerink"
//    private Manager manager;
//    private Customer closeCustomer; //List<Customer>;
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

//    public List<String> getPhoneNumber() { return phoneNumber; }//<<ODKOMENTUJ>>//

//    public void setPhoneNumber(List<String> phoneNumber) {this.phoneNumber = phoneNumber;}//<<ODKOMENTUJ>>//

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

//    public List<Slide> getSlides() {return slides;}//<<ODKOMENTUJ>>//

//    public void setSlides(List<Slide> slides) {this.slides = slides;}//<<ODKOMENTUJ>>//

//    public List<Additional> getAdditionals() {return additionals;}//<<ODKOMENTUJ>>//

//    public void setAdditionals(List<Additional> additionals) {this.additionals = additionals;}//<<ODKOMENTUJ>>//



//    public Manager getManager() {
//        return manager;
//    }
//       public Customer getCloseCustomer() {
//        return closeCustomer;
//    }
//
//    public void setCloseCustomer(Customer closeCustomer) {
//        this.closeCustomer = closeCustomer;
//    }
//
//    public Customer getFun() {
//        return fun;
//    }
//
//    public void setFun(Customer fun) {
//        this.fun = fun;
//    }
}
