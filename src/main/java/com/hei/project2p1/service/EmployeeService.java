package com.hei.project2p1.service;

import com.hei.project2p1.model.EmployeeEntity;
import com.hei.project2p1.model.utils.Sex;
import com.hei.project2p1.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    EmployeeRepository employeeRepository;
    public List<EmployeeEntity> getEmployees() {
     return  employeeRepository.findAll();
    }
    public List<EmployeeEntity> getFilteredEmployees(String firstName, String lastName, String jobFunction, LocalDate entrance, LocalDate departure, String sex,String sortBy,String sortOrder){
    return employeeRepository.findByAllFilters(firstName,lastName,sex,jobFunction,entrance,departure,sortBy,sortOrder);
    }
    public void  saveEmployee(EmployeeEntity employeeEntity){
        employeeRepository.save(employeeEntity);
    }
    public EmployeeEntity getEmployeeById(Long id){
        return employeeRepository.getById(id);
    }
}
