package com.hei.project2p1.repository;

import com.hei.project2p1.model.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<PhoneEntity,Long> {
    PhoneEntity findByPhoneNumber(String phoneNumber);
}
