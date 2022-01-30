package com.insurance.Insurance_spring.repository;

import com.insurance.Insurance_spring.entity.Insurance;
import com.insurance.Insurance_spring.entity.InsurancePermitted;

import java.util.List;

public interface InsuranceRepository extends JpaRepository<Insurance, Long>{
    List<Insurance> findByInsurancePermitted(InsurancePermitted insurancePermitted);
}
