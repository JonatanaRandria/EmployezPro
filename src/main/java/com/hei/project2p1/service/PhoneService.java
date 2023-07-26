package com.hei.project2p1.service;

import com.hei.project2p1.model.PhoneEntity;
import com.hei.project2p1.repository.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PhoneService {
    private final PhoneRepository phoneRepository;

    public PhoneEntity save (PhoneEntity phoneEntity){
        return phoneRepository.save(phoneEntity);
    }
}
