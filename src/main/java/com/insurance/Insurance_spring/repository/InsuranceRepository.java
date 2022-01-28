package com.insurance.Insurance_spring.repository;

import com.insurance.Insurance_spring.entity.Insurance;

import java.util.List;

public interface InsuranceRepository extends JpaRepository<Insurance, Long>{
    List<Insurance> findByInsurancePermitted_Nonapprove();
}
