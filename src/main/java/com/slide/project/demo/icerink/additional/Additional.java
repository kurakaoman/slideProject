package com.slide.project.demo.icerink.additional;


import com.slide.project.demo.icerink.Icerink;

import javax.persistence.*;

@Entity
public enum Additional {
    RENTAL(0), CLOAKROOM(1), SHARPENING(2), BUFFET(3), CURLING(3), HOKEY(4);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long additionalId;

    Additional() {
    }

    Additional(long additionalId) { this.additionalId = additionalId;}



}
