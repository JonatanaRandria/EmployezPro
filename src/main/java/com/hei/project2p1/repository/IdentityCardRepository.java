package com.hei.project2p1.repository;

import com.hei.project2p1.model.EmployeeEntity;
import com.hei.project2p1.model.IdentityCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityCardRepository extends JpaRepository<IdentityCardEntity, Long> {
}
