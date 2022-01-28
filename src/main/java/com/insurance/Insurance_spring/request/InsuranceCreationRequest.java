package com.insurance.Insurance_spring.request;

import com.insurance.Insurance_spring.entity.InsurancePermitted;
import com.insurance.Insurance_spring.entity.InsuranceType;
import lombok.Data;

@Data
public class InsuranceCreationRequest {
    private String name;
    private String content;
    private Long price;
    private Long due;
    private InsuranceType type;
    private Long employeeId;
}
