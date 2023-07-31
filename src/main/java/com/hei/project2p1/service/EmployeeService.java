package com.hei.project2p1.service;

import com.hei.project2p1.controller.mapper.EmployeeMapper;
import com.hei.project2p1.controller.mapper.IdentityCardMapper;
import com.hei.project2p1.controller.mapper.PhoneMapper;
import com.hei.project2p1.controller.model.EmployeeModel;
import com.hei.project2p1.controller.model.View.EmployeeView;
import com.hei.project2p1.model.EmployeeEntity;
import com.hei.project2p1.model.PhoneEntity;
import com.hei.project2p1.model.utils.Sex;
import com.hei.project2p1.repository.EmployeeRepository;
import com.hei.project2p1.repository.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    EmployeeRepository employeeRepository;
    PhoneRepository phoneRepository;
    IdentityCardMapper identityCardMapper;
    EmployeeMapper employeeMapper;
    PhoneMapper phoneMapper;
    PhoneService phoneService;
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
    public void updateEmployee(Long id, EmployeeModel updatedEmployee) throws IOException {
       EmployeeEntity employeeEntity= employeeMapper.toDomain(updatedEmployee);
       employeeEntity.setId(id);
       saveEmployee(employeeEntity);
    }
}
