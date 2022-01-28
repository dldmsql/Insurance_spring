package com.insurance.Insurance_spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Getter
@NoArgsConstructor
@Entity
public class Accident {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant accidentDate; // 발생 날짜
    private Instant date; // 접수 날짜
    private String accidentPlace; // 사고 장소
    @Enumerated(EnumType.STRING)
    private AccidentType accidentType; // 사고 유형
    @Enumerated(EnumType.STRING)
    private AccidentStatus accidentStatus; // 처리 유형

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonManagedReference
    private Customer customer;

    @JsonBackReference
    @OneToOne(mappedBy = "accident", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Reward reward;
}
