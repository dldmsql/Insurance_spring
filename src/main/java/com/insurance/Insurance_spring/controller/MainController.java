package com.insurance.Insurance_spring.controller;

import com.insurance.Insurance_spring.entity.Employee;
import com.insurance.Insurance_spring.repository.EmployeeRepository;
import com.insurance.Insurance_spring.request.EmployeeCreationRequest;
import com.insurance.Insurance_spring.request.EmployeeLoginRequest;
import com.insurance.Insurance_spring.service.MainService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/main")
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;

    @GetMapping
    public ResponseEntity<List<Employee>> readEmployees() {
        return ResponseEntity.ok(mainService.readEmployees());
    }

    @PostMapping ("/signup")
    public ResponseEntity createEmployee(@RequestBody EmployeeCreationRequest request){
        return ResponseEntity.ok(mainService.createEmployee(request));
    }
    @PostMapping("/login")
    public ResponseEntity readEmployee(@RequestBody EmployeeLoginRequest request){
      return ResponseEntity.ok(mainService.readEmployee(request));
    }
}
