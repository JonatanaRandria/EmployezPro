package com.hei.project2p1.controller.mapper;

import com.hei.project2p1.model.PhoneEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PhoneMapper {
    public PhoneEntity toDomain(String phone){
        return PhoneEntity.builder()
                .phoneNumber(phone)
                .build();
    }
}
