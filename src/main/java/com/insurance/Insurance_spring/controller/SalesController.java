package com.insurance.Insurance_spring.controller;

import com.insurance.Insurance_spring.request.CustomerCreationRequest;
import com.insurance.Insurance_spring.service.SalesService;
import com.insurance.Insurance_spring.entity.Contract;
import com.insurance.Insurance_spring.entity.Customer;
import com.insurance.Insurance_spring.entity.Insurance;
import com.insurance.Insurance_spring.request.InsuranceContractRequest;
import com.insurance.Insurance_spring.request.InsuranceReadsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sale")
@RequiredArgsConstructor
public class SalesController {
    private final SalesService salesService;

    @GetMapping("/customer")
    public ResponseEntity readCustomers(){
        return ResponseEntity.ok(salesService.readCustomers());
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> readCustomer(@PathVariable Long id){
        return ResponseEntity.ok(salesService.readCustomer(id));
    }
    @PostMapping("/customer")
    public ResponseEntity createCustomer(@RequestBody  CustomerCreationRequest request){
        return ResponseEntity.ok(salesService.createCustomer(request));
    }
    @PostMapping("/insurance")
    public ResponseEntity<List<Insurance>> readInsurances(@RequestBody InsuranceReadsRequest request ){
        return ResponseEntity.ok(salesService.readInsurances(request));
    }
    @PostMapping("/contract")
    public ResponseEntity<Contract> createContract (@RequestBody InsuranceContractRequest request ){
        return ResponseEntity.ok(salesService.createContract(request));
    }
    @GetMapping("/contract/manage")
    public ResponseEntity<List<Contract>> readContracts(){
        return ResponseEntity.ok(salesService.readContracts());
    }
    @PatchMapping("/contract/manage/{contractId}")
    public ResponseEntity<Contract> updateContract (@RequestBody Long request, @PathVariable Long contractId) {
        return ResponseEntity.ok(salesService.updateContract(contractId, request));
    }
    @DeleteMapping("/contract/manage/{contractId}")
    public ResponseEntity<Void> deleteContract (@PathVariable Long contractId) {
        salesService.deleteContract(contractId);
        return ResponseEntity.ok().build();
    }
}
