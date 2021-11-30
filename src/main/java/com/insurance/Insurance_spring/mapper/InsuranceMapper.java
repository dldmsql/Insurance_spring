package com.insurance.Insurance_spring.mapper;

import com.insurance.Insurance_spring.domain.insurance.Approve;
import com.insurance.Insurance_spring.domain.insurance.Coverage;
import com.insurance.Insurance_spring.domain.insurance.Insurance;
import com.insurance.Insurance_spring.domain.pCustomer.PCustomer;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface InsuranceMapper {
    List<Insurance> retrieve();
    List<Insurance> retrieveNoApprove();
    int create( Insurance insurance );
    int createCoverage( Coverage coverage );
    int createApprove( Approve approve );
    Insurance retrieveByID( int insuranceID );
    Coverage retrieveCoverage(HashMap<String, Object> coverageInfo);
    int updateByID( Insurance insurance );
}