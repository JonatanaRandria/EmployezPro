package com.hei.project2p1.controller.mapper;

import com.hei.project2p1.model.EmployeeEntity;
import com.hei.project2p1.model.PhoneEntity;
import com.hei.project2p1.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PhoneMapper {

    public PhoneEntity toDomain(String phone){
        String code = phone.substring(0,4);
        return PhoneEntity.builder()
                .phoneNumber(phone)
                .code(code)

                .build();
    }
}
