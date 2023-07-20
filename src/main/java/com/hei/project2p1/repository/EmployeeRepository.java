package com.hei.project2p1.repository;

import com.hei.project2p1.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query(value = "")
    List<EmployeeEntity> getFilteredEmployee(String key,String order);
}
