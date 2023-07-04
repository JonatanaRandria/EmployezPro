package app.hei.endpoint.controller.mapper;

import app.hei.endpoint.controller.rest.EmployeeRest;
import app.hei.endpoint.model.Employee;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmployeeMapper {
    public Employee ToRest (EmployeeRest employee){
        return  Employee.builder()
                .id(UUID.randomUUID().toString())
                .name(employee.getName())
                .firstName(employee.getFirstName())
                .birthDate(employee.getBirthDate())
                .build();
    }
}
