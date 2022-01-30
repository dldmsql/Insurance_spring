package com.insurance.Insurance_spring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {
    @GetMapping("hello")
    public List<String> hello(){
        return Arrays.asList("안녕하세요", "hello");

    }
}
