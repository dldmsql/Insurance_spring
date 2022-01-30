package com.insurance.Insurance_spring.request;

import lombok.Data;

@Data
public class EmployeeLoginRequest {
    private Long employeeId;
    private Long pw;
}
