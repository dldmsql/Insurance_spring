package com.insurance.Insurance_spring.controller;

import com.insurance.Insurance_spring.Service.SalesService;
import com.insurance.Insurance_spring.entity.Insurance;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/library")
@RequiredArgsConstructor
public class SalesController {
    private final SalesService salesService;


}
