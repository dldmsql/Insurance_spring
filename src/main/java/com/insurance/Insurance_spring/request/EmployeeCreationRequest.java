package com.insurance.Insurance_spring.request;

import com.insurance.Insurance_spring.entity.EmployeeDepart;
import lombok.Data;

@Data
public class EmployeeCreationRequest {
    private Long pw;
    private String firstName;
    private String lastName;
    private EmployeeDepart employeeDepart;
}
