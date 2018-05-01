package com.slide.project.demo.icerink.slide;

import com.slide.project.demo.icerink.Icerink;
import com.slide.project.demo.roles.customer.Customer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
public class Slide {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long slideId;
   @ManyToOne
   @JoinColumn(name="icerink_id")
    Icerink icerink;
    Integer places;
    //Integer freePlaces;
    Map<Date,List<Customer>> reservedPlaces;
    Date timetable;

    public Slide(Long slideId, Integer places, Map<Date, List<Customer>> reservedPlaces, Date timetable) {
        this.slideId = slideId;
        this.places = places;
        this.reservedPlaces = reservedPlaces;
        this.timetable = timetable;
    }

    public Long getSlideId() {
        return slideId;
    }

    public Icerink getIcerink() {
        return icerink;
    }

    public void setSlideId(Long slideId) {
        this.slideId = slideId;
    }

    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    public Map<Date, List<Customer>> getReservedPlaces() {
        return reservedPlaces;
    }

    public void setReservedPlaces(Map<Date, List<Customer>> reservedPlaces) {
        this.reservedPlaces = reservedPlaces;
    }

    public Date getTimetable() {
        return timetable;
    }

    public void setTimetable(Date timetable) {
        this.timetable = timetable;
    }
}
