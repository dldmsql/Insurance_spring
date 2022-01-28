package com.insurance.Insurance_spring.request;

import com.insurance.Insurance_spring.entity.CustomerJob;
import lombok.Data;

@Data
public class CustomerCreationRequest {
    // 새로운 고객 등록 시, 받아오는 정보
    private Long customerId;
    private String firstName;
    private String lastName;
    private CustomerJob job;
    // 고객 가입 날짜를 기록할 것인가?
}