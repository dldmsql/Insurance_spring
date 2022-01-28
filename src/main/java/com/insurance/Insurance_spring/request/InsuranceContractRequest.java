package com.insurance.Insurance_spring.request;

import lombok.Data;

@Data
public class InsuranceContractRequest {
    private Long customerId;
    private Long due;
    private Long insuranceId;
    private Long employeeId;
}
