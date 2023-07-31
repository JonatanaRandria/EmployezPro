package com.hei.project2p1.repository;

import com.hei.project2p1.model.EmployeeEntity;
import com.hei.project2p1.model.utils.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query(value = "SELECT * FROM employee " +
            "WHERE (:firstName IS NULL OR firstName LIKE CONCAT('%', :firstName, '%')) " +
            "AND (:lastName IS NULL OR lastName LIKE CONCAT('%', :lastName, '%'))",
            nativeQuery = true)
    List<EmployeeEntity> findByAllFilters(String firstName, String lastName);
}
