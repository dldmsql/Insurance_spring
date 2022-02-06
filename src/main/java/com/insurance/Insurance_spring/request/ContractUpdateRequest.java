package com.insurance.Insurance_spring.request;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Data
public class ContractUpdateRequest {
    private Long due;
    private Long employeeId;
}
