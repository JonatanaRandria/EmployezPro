package td.example.prog4.CnapsEmployeedb.repository;

import td.example.prog4.CnapsEmployeedb.model.CnapsEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CnapsEmployeeRepository extends JpaRepository<CnapsEmployee, String> {
}
