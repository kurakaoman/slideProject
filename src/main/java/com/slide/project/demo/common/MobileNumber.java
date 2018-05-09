package com.slide.project.demo.common;

import com.slide.project.demo.icerink.Icerink;

import javax.persistence.*;

@Entity
public class MobileNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mobileNumber_id") // bez tego szedł mi błąd : contains physical column name [phone_number_id] referred to by multiple physical column names: [phoneNumber_id], [phoneNumberId]
    private long phoneNumberId;
    private String number;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="icerink_id", unique = true)
    private Icerink icerink;
    public MobileNumber() {
    }

    public Icerink getIcerink() {
        return icerink;
    }

    public void setIcerink(Icerink icerink) {
        this.icerink = icerink;
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
