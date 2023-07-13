package com.hei.project2p1.service;

import com.hei.project2p1.model.Employee;
import com.hei.project2p1.repository.EmployeeRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    EmployeeRepository employeeRepository;
    public List<Employee> getEmployees() {
     return  employeeRepository.findAll();
    }

    public void  saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }
    public Employee getEmployeeById(Long id){
        return employeeRepository.getById(id);
    }
}
