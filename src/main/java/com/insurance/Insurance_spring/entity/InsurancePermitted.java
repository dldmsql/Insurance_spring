package com.insurance.Insurance_spring.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public enum InsurancePermitted {
    nonapprove, approve;

    @JsonCreator
    public static InsurancePermitted create(String requestValue) {
        return Stream.of(values())
                .filter(v -> v.toString().equalsIgnoreCase(requestValue))
                .findFirst()
                .orElse(null);
    }
}
