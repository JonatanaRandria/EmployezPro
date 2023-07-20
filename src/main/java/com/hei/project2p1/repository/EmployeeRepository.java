package com.hei.project2p1.repository;

import com.hei.project2p1.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query(value = "SELECT c FROM EmployeeEntity c  WHERE :key = :x ORDER BY :y")
    List<EmployeeEntity> getFilteredEmployee(@Param("key") String key,
                                             @Param("x") String x,
                                             @Param("y") String y);
}
