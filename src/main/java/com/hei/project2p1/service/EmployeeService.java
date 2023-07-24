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
    public void updateEmployee(Long id,EmployeeEntity updatedEmployee){
        EmployeeEntity existingEmployee = getEmployeeById(id);

        // Update the fields of the existing employee with the values from the updatedEmployee
        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setBirthDate(updatedEmployee.getBirthDate());
        existingEmployee.setProfileImage(updatedEmployee.getProfileImage());
        existingEmployee.setSex(updatedEmployee.getSex());
        existingEmployee.setPhoneNumbers(updatedEmployee.getPhoneNumbers());
        existingEmployee.setAddress(updatedEmployee.getAddress());
        existingEmployee.setWorkMail(updatedEmployee.getWorkMail());
        existingEmployee.setPersonalMail(updatedEmployee.getPersonalMail());
        existingEmployee.setIdentityCard(updatedEmployee.getIdentityCard());
        existingEmployee.setJobFunction(updatedEmployee.getJobFunction());
        existingEmployee.setNumberOfChildren(updatedEmployee.getNumberOfChildren());
        existingEmployee.setHireDate(updatedEmployee.getHireDate());
        existingEmployee.setDepartureDate(updatedEmployee.getDepartureDate());
        existingEmployee.setSocioProfessionalCategory(updatedEmployee.getSocioProfessionalCategory());
        existingEmployee.setCnapsNumber(updatedEmployee.getCnapsNumber());
        employeeRepository.save(existingEmployee);
    }
}
