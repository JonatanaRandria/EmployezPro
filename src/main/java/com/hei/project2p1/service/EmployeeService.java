package com.hei.project2p1.service;

import com.hei.project2p1.model.EmployeeEntity;
import com.hei.project2p1.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    EmployeeRepository employeeRepository;
    public List<EmployeeEntity> getEmployees() {
     return  employeeRepository.findAll();
    }

    public void  saveEmployee(EmployeeEntity employeeEntity){
        employeeRepository.save(employeeEntity);
    }
    public EmployeeEntity getEmployeeById(Long id){
        return employeeRepository.getById(id);
    }
}
