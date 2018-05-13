package com.slide.project.demo.common;

import com.slide.project.demo.icerink.Icerink;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MobileNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mobileNumber_id") // bez tego szedł mi błąd : contains physical column name [phone_number_id] referred to by multiple physical column names: [phoneNumber_id], [phoneNumberId]
    private long phoneNumberId;
    private String number;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "mobileNumber_icerink", joinColumns = {@JoinColumn(name = "mobileNumber_id")}, inverseJoinColumns = {@JoinColumn(name = "icerink_id")})
    private Set<Icerink> icerinks;
    public MobileNumber() {
    }

    public void setPhoneNumberId(long phoneNumberId) {
        this.phoneNumberId = phoneNumberId;
    }

    public Set<Icerink> getIcerinks() {
        return icerinks;
    }

    public void setIcerinks(Set<Icerink> icerinks) {
        this.icerinks = icerinks;
    }

    public long getPhoneNumberId() {
        return phoneNumberId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
