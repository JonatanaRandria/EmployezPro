package com.hei.project2p1.repository;

import com.hei.project2p1.model.EmailEntity;
import com.hei.project2p1.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailEntity, Long> {
}
