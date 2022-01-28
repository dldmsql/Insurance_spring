package com.insurance.Insurance_spring.repository;

import com.insurance.Insurance_spring.entity.Customer;
import com.insurance.Insurance_spring.entity.CustomerJob;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    Optional<Customer> findByCustomerJob(CustomerJob customerJob);
}
