package com.insurance.Insurance_spring.request;

import com.insurance.Insurance_spring.entity.AccidentType;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;

@Data
public class AccidentRequest {
    private Long customerId;
    private LocalDate accidentDate;
    private String accidentPlace;
    private AccidentType accidentType;
}
