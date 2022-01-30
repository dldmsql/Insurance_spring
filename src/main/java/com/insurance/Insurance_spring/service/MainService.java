package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.entity.Employee;
import com.insurance.Insurance_spring.repository.EmployeeRepository;
import com.insurance.Insurance_spring.request.EmployeeCreationRequest;
import com.insurance.Insurance_spring.request.EmployeeLoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainService {
    private final EmployeeRepository employeeRepository;

    // 직원 회원가입
    public Employee createEmployee(EmployeeCreationRequest request){
        Employee employee = new Employee();
        BeanUtils.copyProperties(request, employee);
        return employeeRepository.save(employee);
    }
    // 로그인
    public String readEmployee(EmployeeLoginRequest request){
        Optional<Employee> employee = employeeRepository.findById(request.getEmployeeId());
        if(employee.get().getPw() == request.getPw() ){
            return "Success";
        }
        return "Failed";
    }
}
