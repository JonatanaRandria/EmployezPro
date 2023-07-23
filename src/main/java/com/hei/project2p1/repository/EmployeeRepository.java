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

    @Query("SELECT e FROM EmployeeEntity e " +
            "WHERE (:firstName IS NULL OR e.firstName LIKE %:firstName%) " +
            "AND (:lastName IS NULL OR e.lastName LIKE %:lastName%) " +
            "AND (:sex IS NULL OR e.sex = :sex) " +
            "AND (:jobFunction IS NULL OR e.jobFunction LIKE %:jobFunction%) " +
            "AND (:startDate IS NULL OR e.hireDate >= :startDate) " +
            "AND (:endDate IS NULL OR e.departureDate <= :endDate)"+
            "ORDER BY " +
            "CASE WHEN :sortBy = 'firstName' AND :sortOrder = 'asc' THEN e.firstName END ASC, " +
            "CASE WHEN :sortBy = 'firstName' AND :sortOrder = 'desc' THEN e.firstName END DESC, " +
            "CASE WHEN :sortBy = 'lastName' AND :sortOrder = 'asc' THEN e.lastName END ASC, " +
            "CASE WHEN :sortBy = 'lastName' AND :sortOrder = 'desc' THEN e.lastName END DESC, " +
            "CASE WHEN :sortBy = 'sex' AND :sortOrder = 'asc' THEN e.sex END ASC, " +
            "CASE WHEN :sortBy = 'sex' AND :sortOrder = 'desc' THEN e.sex END DESC, " +
            "CASE WHEN :sortBy = 'jobFunction' AND :sortOrder = 'asc' THEN e.jobFunction END ASC, " +
            "CASE WHEN :sortBy = 'jobFunction' AND :sortOrder = 'desc' THEN e.jobFunction END DESC")
    List<EmployeeEntity> findByAllFilters(String firstName, String lastName, String sex,
                                          String jobFunction,
                                          LocalDate startDate, LocalDate endDate,
                                          String sortBy,
                                          String sortOrder);
}
