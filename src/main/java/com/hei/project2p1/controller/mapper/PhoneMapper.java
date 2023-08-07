package com.hei.project2p1.controller.mapper;

import com.hei.project2p1.controller.model.PhoneModel;
import com.hei.project2p1.model.EmployeeEntity;
import com.hei.project2p1.model.PhoneEntity;
import com.hei.project2p1.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PhoneMapper {

    public PhoneEntity toDomain(String phone,String code){
        return PhoneEntity.builder()
                .phoneNumber(code+phone)
                .code(code)
                .build();
    }
    public String toView(PhoneEntity phoneEntity){
        String countryCode = phoneEntity.getCode();
        return phoneEntity.getPhoneNumber().replace(countryCode,"");
    }
}
