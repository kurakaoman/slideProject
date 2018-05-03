package com.slide.project.demo.icerink.additional;


import com.slide.project.demo.icerink.Icerink;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public enum Additional {
    RENTAL, CLOAKROOM, SHARPENING, BUFFET, CURLING, HOKEY;

//    @ManyToOne
//    @JoinColumn(name = "icerink_id")
//    private Icerink icerink;
//
//    public Icerink getIcerink() {
//        return icerink;
//    }
//
//    public void setIcerink(Icerink icerink) {
//        this.icerink = icerink;
//    }


}
