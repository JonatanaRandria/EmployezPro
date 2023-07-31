package com.hei.project2p1.repository.dao;

import com.hei.project2p1.model.EmployeeEntity;
import com.hei.project2p1.model.PhoneEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class EmployeeDao {
    private final EntityManager entityManager;


    public List<EmployeeEntity> findByCriteriaNative(String firstName, String lastName, String sex,
                                               String position, String code, LocalDate startedAt,
                                               LocalDate departedAt,
                                               String sortField, String sortOrder) {
        StringBuilder query = new StringBuilder(
                "SELECT DISTINCT e.* FROM Employee e LEFT JOIN Phone p ON e.id = p.employee_id WHERE 1=1 ");

        if (firstName != null && !firstName.isEmpty()) {
            query.append("AND (lower(e.first_name) LIKE :firstName OR e.first_name LIKE :firstName) ");
        }

        if (lastName != null && !lastName.isEmpty()) {
            query.append("AND (lower(e.last_name) LIKE :lastName OR e.last_name LIKE :lastName) ");
        }

        if (sex != null && !sex.isEmpty()) {
            query.append("AND e.sex = :sex ");
        }

        if (position != null && !position.isEmpty()) {
            query.append("AND (lower(e.job_function) LIKE :position OR e.job_function LIKE :position) ");
        }

        if (code != null && !code.isEmpty()) {
            query.append("AND p.phone_number LIKE CONCAT(:code,'%')");
        }

        if (startedAt != null && departedAt != null) {
            query.append(
                    "AND (e.hire_date BETWEEN :startedAt AND :departedAt OR e.departure_date BETWEEN :startedAt AND :departedAt) ");
        }

        if (sortField != null && !sortField.isEmpty() && sortOrder.equalsIgnoreCase("asc")) {
            query.append("ORDER BY ").append("e.").append(sortField)
                    .append(" ASC ");
        } else if (sortField != null && !sortField.isEmpty() && sortOrder.equalsIgnoreCase("desc")) {
            query.append("ORDER BY ").append("e.").append(sortField)
                    .append(" DESC ");
        } else {
            query.append("ORDER BY e.last_name ASC ");
        }

        Query nativeQuery = entityManager.createNativeQuery(query.toString(), EmployeeEntity.class);

        if (firstName != null && !firstName.isEmpty()) {
            nativeQuery.setParameter("firstName", "%" + firstName + "%");
        }

        if (lastName != null && !lastName.isEmpty()) {
            nativeQuery.setParameter("lastName", "%" + lastName + "%");
        }

        if (sex != null) {
            nativeQuery.setParameter("sex", sex);
        }

        if (position != null && !position.isEmpty()) {
            nativeQuery.setParameter("position", "%" + position + "%");
        }

        if (code != null && !code.isEmpty()) {
            nativeQuery.setParameter("code", code);
        }

        if (startedAt != null && departedAt != null) {
            nativeQuery.setParameter("startedAt", startedAt);
            nativeQuery.setParameter("departedAt", departedAt);
        }

        return nativeQuery.getResultList();
    }


}
