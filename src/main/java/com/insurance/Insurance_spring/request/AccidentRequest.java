package com.insurance.Insurance_spring.request;

import com.insurance.Insurance_spring.entity.AccidentType;
import lombok.Data;

import java.time.Instant;

@Data
public class AccidentRequest {
    private Long customerId;
    private Instant accidentDate;
    private String accidentPlace;
    private AccidentType accidentType;
}
