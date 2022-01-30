package com.insurance.Insurance_spring.controller;

import com.insurance.Insurance_spring.service.DevelopService;
import com.insurance.Insurance_spring.entity.Insurance;
import com.insurance.Insurance_spring.request.InsuranceCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/develop")
@RequiredArgsConstructor
public class DevelopController {
    private final DevelopService developService;

    @PostMapping("/insurance")
    public ResponseEntity createInsurance(@RequestBody InsuranceCreationRequest request){
            return ResponseEntity.ok(developService.createInsurance(request));
    }
    @DeleteMapping("/insurance/{insuranceId}")
    public ResponseEntity<Void> deleteInsurance( @PathVariable Long insuranceId ){
        developService.deleteInsurance(insuranceId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/insurance/nonapprove")
    public ResponseEntity<List<Insurance>> readInsurances(){
        return ResponseEntity.ok(developService.readInsurances());
    }
    @PatchMapping("/insurance/{insuranceId}")
    public ResponseEntity updateInsurance(@PathVariable Long insuranceId){
        return ResponseEntity.ok(developService.updateInsurance(insuranceId));
    }
}
