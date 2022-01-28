package com.insurance.Insurance_spring.request;

import com.insurance.Insurance_spring.entity.InsuranceType;
import lombok.Data;

@Data
public class InsuranceReadsRequest {
    private InsuranceType type; // 보험 유형
    private Long customerId; // 고객 아이디

} 
