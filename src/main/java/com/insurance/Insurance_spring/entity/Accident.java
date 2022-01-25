package com.insurance.Insurance_spring.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Accident {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long accidentId;

    private String accidentDate, accidentPlace, accidentTime, accidentSize, date;
    private Long judged, completed, customerId;

    @Builder
    public Accident(String accidentDate, String accidentPlace, String accidentTime, String accidentSize, String date, Long judged, Long completed, Long customerId) {
        this.accidentDate = accidentDate;
        this.accidentPlace = accidentPlace;
        this.accidentTime = accidentTime;
        this.accidentSize = accidentSize;
        this.date = date;
        this.judged = judged;
        this.completed = completed;
        this.customerId = customerId;
    }
}
