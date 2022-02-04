package com.insurance.Insurance_spring.repository;

import com.insurance.Insurance_spring.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    Optional<Employee> findByIdAndPw(Long employeeId, Long pw);
}
