package com.insurance.Insurance_spring.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "reward")
public class Reward {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String reason;
    private Long price;
    private Instant date;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "accident_id")
    private Accident accident;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
}
