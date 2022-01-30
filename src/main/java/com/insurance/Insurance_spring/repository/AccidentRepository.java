package com.insurance.Insurance_spring.repository;

import com.insurance.Insurance_spring.entity.Accident;
import com.insurance.Insurance_spring.entity.AccidentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
    List<Accident> findByAccidentStatus(AccidentStatus accidentStatus);
}
