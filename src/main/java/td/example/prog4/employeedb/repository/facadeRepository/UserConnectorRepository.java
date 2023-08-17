package td.example.prog4.employeedb.repository.facadeRepository;

import td.example.prog4.employeedb.repository.entity.Employee;

import java.util.List;

public interface UserConnectorRepository {

        Employee findById(String id);

        void save(Employee employee);

    }

