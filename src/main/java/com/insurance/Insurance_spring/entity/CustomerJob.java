package com.insurance.Insurance_spring.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.stream.Stream;

public enum CustomerJob {
    STUDENT,
    OFFICER,
    DRIVER;

    @JsonCreator
    public static CustomerJob create(String requestValue) {
        return Stream.of(values())
                .filter(v -> v.toString().equalsIgnoreCase(requestValue))
                .findFirst()
                .orElse(null);
    }

}
