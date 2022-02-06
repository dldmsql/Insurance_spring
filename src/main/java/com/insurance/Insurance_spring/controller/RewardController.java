package com.insurance.Insurance_spring.controller;

import com.insurance.Insurance_spring.service.RewardService;
import com.insurance.Insurance_spring.entity.Accident;
import com.insurance.Insurance_spring.entity.Customer;
import com.insurance.Insurance_spring.entity.Reward;
import com.insurance.Insurance_spring.request.AccidentRequest;
import com.insurance.Insurance_spring.request.RewardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/reward")
@RequiredArgsConstructor
public class RewardController {
    private final RewardService rewardService;

    @PostMapping("/accident")
    public ResponseEntity createAccident(@RequestBody AccidentRequest request){
        return ResponseEntity.ok(rewardService.createAccident(request));
    }
    @DeleteMapping("/accident/{accidentId}")
    public ResponseEntity<Void> deleteAccident(@PathVariable Long accidentId){
        rewardService.deleteAccident(accidentId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/accident/manage")
    public ResponseEntity<List<Accident>> readAccidents(){
        return ResponseEntity.ok(rewardService.readAccidents());
    }
    @PostMapping("/customer/{customerId}")
    public ResponseEntity<Accident> readAccident(@PathVariable Long customerId){
        return ResponseEntity.ok(rewardService.readAccident(customerId));
    }
    @PostMapping("/reward")
    public ResponseEntity<Reward> createReward (@RequestBody RewardRequest request ){
        return ResponseEntity.ok(rewardService.createReward(request));
    }

}
