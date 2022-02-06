package com.insurance.Insurance_spring.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public enum InsuranceType {
    CAR, DRIVER, BUILDING;

    @JsonCreator
    public static InsuranceType create(String requestValue) {
        return Stream.of(values())
                .filter(v -> v.toString().equalsIgnoreCase(requestValue))
                .findFirst()
                .orElse(null);
    }
}
