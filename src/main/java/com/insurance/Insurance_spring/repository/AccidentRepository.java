package com.insurance.Insurance_spring.repository;

import com.insurance.Insurance_spring.entity.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
}
