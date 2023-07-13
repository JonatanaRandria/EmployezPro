package com.hei.project2p1.controller.mapper;

import com.hei.project2p1.controller.rest.model.RestEmployee;
import com.hei.project2p1.model.Employee;
import com.hei.project2p1.controller.mapper.utils.SaveImageUtils.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

@Component
@AllArgsConstructor
public class EmployeeMapper {

    public Employee toDomain(RestEmployee employee){
        Employee domainEmployee = Employee.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .birthDate(employee.getBirthDate())
                .build();
        try {
            MultipartFile imageFile = employee.getProfileImage();
            if (imageFile != null && !imageFile.isEmpty()) {
                // Get the image file content as a byte array
                byte[] imageBytes = imageFile.getBytes();

                // Convert the byte array to a Base64 string
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                domainEmployee.setProfileImage(base64Image);
            }
            return domainEmployee;
        }
        catch (Exception e){
            throw new RuntimeException("Bad Request");
        }
    }

}
