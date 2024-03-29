package com.insurance.Insurance_spring.mapper;

import com.insurance.Insurance_spring.domain.customer.Building;
import com.insurance.Insurance_spring.domain.customer.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CustomerMapper {
    List<Customer> retrieve();
    Customer retrieveByID( int customerID );
    Customer retrieveByInfo( String name, String customerNumber );
    int create( Customer customer );
    int createBuildingInfo(HashMap<String, Object> buildingInfos);
    void deleteBuildingInfo( int buildingID );
    int createCarInfo(HashMap<String, Object> carInfos);
    void deleteCarInfo( int carID );
    int createDriverInfo(HashMap<String, Object> driverInfos);
    void deleteDriverInfo( int driverID );
    void updateCustomerInfo( Customer customer );
}