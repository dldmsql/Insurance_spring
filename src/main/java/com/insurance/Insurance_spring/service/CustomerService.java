package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.customer.Building;
import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer> getCustomerList(){ return customerMapper.retrieve(); }
    public Customer getCustomer( int customerID ){ return customerMapper.retrieveByID( customerID ); }
    public Customer getCustomerByInfo( String name, String customerNumber ){ return customerMapper.retrieveByInfo( name, customerNumber ); }
    public int create(Customer customer) { return customerMapper.create( customer ); }

    public void createBuildingInfo(HashMap<String, Object> buildingInfos) { customerMapper.createBuildingInfo( buildingInfos ); }
    public void deleteBuildingInfo( int buildingID ) { customerMapper.deleteBuildingInfo( buildingID ); }
    public void createCarInfo(HashMap<String, Object> carInfos) { customerMapper.createCarInfo( carInfos ); }
    public void deleteCarInfo( int carID ) { customerMapper.deleteCarInfo( carID ); }
    public void createDriverInfo(HashMap<String, Object> driverInfos) { customerMapper.createDriverInfo( driverInfos ); }
    public void deleteDriverInfo( int driverID ) { customerMapper.deleteDriverInfo( driverID );}

    public void updateCustomerInfo(Customer customer) { customerMapper.updateCustomerInfo( customer ); }
}
