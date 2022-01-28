package com.insurance.Insurance_spring.Service;

import com.insurance.Insurance_spring.entity.*;
import com.insurance.Insurance_spring.repository.*;
import com.insurance.Insurance_spring.request.InsuranceContractRequest;
import com.insurance.Insurance_spring.request.InsuranceReadsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SalesService {

    private final CustomerRepository customerRepository;
    private final InsuranceRepository insuranceRepository;
    private final EmployeeRepository employeeRepository;
    private final ContractRepository contractRepository;

    // 고객 상담 = 계약 체결
    /*시스템은 상담 대기 중인 고객 리스트를 화면에 보여준다.
    직원은 고객을 선택한다.
    시스템은 고객의 개인정보와 보험 유형 선택과 계약하기 버튼을 보여준다.
    직원은 보험 유형을 선택한 뒤, 계약하기 버튼을 누른다.
    시스템은 보험 유형에 맞는 보험 상품 리스트와 계약 기간 입력칸, 계약 완료 버튼을 보여준다.
    직원은 보험 상품을 선택하고, 계약 기간을 입력 후 계약 완료 버튼을 누른다.*/
    
    // 고객 리스트
    public List<Customer> readCustomers(){ 
        List<Customer> customerList = (List<Customer>) customerRepository.findAll();
        if(customerList.isEmpty()){
            throw new IndexOutOfBoundsException(
                    "Customer not present in the database"
            );
        }
        return customerList;
    }
    // 선택한 고객 개인정보
    public Customer readCustomer(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }
    // 보험 리스트 ( 보험 유형 )
    public List<Insurance> readInsurances (InsuranceReadsRequest request){
        List<Insurance> insuranceList = new ArrayList<>();
        for (Insurance insurance : insuranceRepository.findAll()) {
            if ( insurance.getInsuranceType() == request.getType() ){
                insuranceList.add(insurance);
            }
        }
        return insuranceList;
    }
    // 계약 체결
    public Contract createContract ( InsuranceContractRequest request ){
        Optional<Customer> customer = customerRepository.findById(request.getCustomerId());
        Optional<Insurance> insurance = insuranceRepository.findById(request.getInsuranceId());
        Optional<Employee> employee = employeeRepository.findById(request.getEmployeeId());

        Contract contract = new Contract();
        contract.setCustomer(customer.get());
        contract.setInsurance(insurance.get());
        contract.setEmployee(employee.get());

        contract.setStartOn(Instant.now());
        contract.setDueOn(Instant.now().plus(request.getDue(), ChronoUnit.YEARS));

        contractRepository.save(contract);

        return contract;
    }

    // 계약 관리
/*    시스템은 체결된 계약 리스트를 보여준다.
    직원은 연장 혹은 해지하고자 하는 계약을 선택한다.
    시스템은 연장 혹은 해지 버튼을 보여준다.
    직원이 연장 버튼을 누른 경우, 연장하고자 하는 기간 입력칸을 보여준다.
    직원이 해지 버튼을 누른 경우, 시스템은 해당 계약을 디비에서 삭제한다.*/
    
    // 만기 전, 계약 리스트 조회
    public List<Contract> readContracts(){
        List<Contract> contractList = new ArrayList<>();
        for(Contract contract : contractRepository.findAll()){
            if(contract.getDueOn().isAfter(Instant.now())){
                contractList.add(contract);
            }
        }
        return contractList;
    }

    // 연장 혹은 해지
    public void updateContract( Long id, Long due ){
        Optional<Contract> optionalContract = contractRepository.findById(id);
        if(!optionalContract.isPresent()){
            throw new EntityNotFoundException(
                    "Contract not present in the database"
            );
        }
        if( due == 0 ){
            contractRepository.deleteById(id);
        } else {
            Contract contract = optionalContract.get();
            contract.setDueOn(contract.getDueOn().plus(due, ChronoUnit.YEARS));
            contractRepository.save(contract);
        }
    }
}