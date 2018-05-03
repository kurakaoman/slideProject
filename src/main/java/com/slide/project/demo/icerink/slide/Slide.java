package com.slide.project.demo.icerink.slide;

        import com.slide.project.demo.icerink.Icerink;
        import com.slide.project.demo.roles.customer.Customer;

        import javax.persistence.*;
        import java.util.Date;
        import java.util.List;

@Entity
public class Slide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slideId;
//   @ManyToOne
//    @JoinColumn(name="icerink_id")
//    private Icerink icerink;

    private Integer places;
    private Date hour;
//    @ManyToMany(fetch=FetchType.EAGER) //mappedBy=slide ?//<<ODKOMENTUJ>>//
//    private List<Customer> participants; //<<ODKOMENTUJ>>//

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

//    public List<Customer> getParticipants() {return participants;} //<<ODKOMENTUJ>>//

//    public void setParticipants(List<Customer> participants) { this.participants = participants;}//<<ODKOMENTUJ>>//

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }
}
