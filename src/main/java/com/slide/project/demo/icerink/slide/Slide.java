package com.slide.project.demo.icerink.slide;

        import com.slide.project.demo.icerink.Icerink;
        import com.slide.project.demo.roles.customer.Customer;

        import javax.persistence.*;
        import java.util.Date;
        import java.util.List;
        import java.util.Set;

@Entity
public class Slide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slideId;
    @ManyToOne
    @JoinColumn(name="icerink_id", unique = true)
    private Icerink icerink;

    private Integer places;
    private Date hour;

    @ManyToMany(fetch=FetchType.EAGER)
//    @JoinTable(name = "slide_customer", joinColumns = {@JoinColumn(name = "slide_id")}, inverseJoinColumns = {@JoinColumn(name = "customer_id")})
    private Set<Customer> participants;

    public Slide(){

    }
    public Slide(Long slideId, Integer places, Date hour) {
        this.slideId = slideId;
        this.places = places;
//        this.participants = participants;//<<ODKOMENTUJ>>//
        this.hour = hour;
    }

    public Long getSlideId() {
        return slideId;
    }

//    public Icerink getIcerink() {
//        return icerink;
//    }

    public void setSlideId(Long slideId) {
        this.slideId = slideId;
    }

    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    public Set<Customer> getParticipants() {return participants;}

    public void setParticipants(Set<Customer> participants) { this.participants = participants;}

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }
}
