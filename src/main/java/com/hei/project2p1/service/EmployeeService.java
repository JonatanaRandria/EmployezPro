package com.hei.project2p1.service;

import com.hei.project2p1.controller.mapper.EmployeeMapper;
import com.hei.project2p1.controller.mapper.IdentityCardMapper;
import com.hei.project2p1.controller.mapper.PhoneMapper;
import com.hei.project2p1.controller.model.EmployeeModel;
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
        EmployeeEntity existingEmployee = getEmployeeById(id);

// Convert List<String> to List<Phone>

      PhoneEntity phoneEntity=  phoneService.save(phoneMapper.toDomain(updatedEmployee.getPhoneNumbers()));

        MultipartFile imageFile = updatedEmployee.getProfileImage();
            // Get the image file content as a byte array
            byte[] imageBytes = imageFile.getBytes();

            // Convert the byte array to a Base64 string
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        // Update the fields of the existing employee with the values from the updatedEmployee
        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setBirthDate(updatedEmployee.getBirthDate());
        existingEmployee.setProfileImage(base64Image);
        existingEmployee.setSex(String.valueOf(updatedEmployee.getSex()));
        existingEmployee.setPhoneNumbers(List.of(phoneEntity));
        existingEmployee.setAddress(updatedEmployee.getAddress());
        existingEmployee.setWorkMail(updatedEmployee.getWorkMail());
        existingEmployee.setPersonalMail(updatedEmployee.getPersonalMail());
        existingEmployee.setJobFunction(updatedEmployee.getJobFunction());
        existingEmployee.setNumberOfChildren(updatedEmployee.getNumberOfChildren());
        existingEmployee.setHireDate(updatedEmployee.getHireDate());
        existingEmployee.setDepartureDate(updatedEmployee.getDepartureDate());
        existingEmployee.setSocioProfessionalCategory(updatedEmployee.getSocioProfessionalCategory());
        existingEmployee.setCnapsNumber(updatedEmployee.getCnapsNumber());
        employeeRepository.save(existingEmployee);
    }
}
