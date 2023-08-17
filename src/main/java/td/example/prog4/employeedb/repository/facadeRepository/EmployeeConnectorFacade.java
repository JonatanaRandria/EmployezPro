package td.example.prog4.employeedb.repository.facadeRepository;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import td.example.prog4.CnapsEmployeedb.model.CnapsEmployee;
import td.example.prog4.CnapsEmployeedb.repository.CnapsEmployeeRepository;
import td.example.prog4.employeedb.controller.mapper.EmployeeMapper;
import td.example.prog4.employeedb.model.exception.NotFoundException;
import td.example.prog4.employeedb.repository.EmployeeRepository;
import td.example.prog4.employeedb.repository.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Primary
@AllArgsConstructor
public class EmployeeConnectorFacade implements UserConnectorRepository {
    private final EmployeeRepository employeeRepository;
    private final CnapsEmployeeRepository cnapsEmployeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public Employee findById(String id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found id=" + id));
        CnapsEmployee cnapsEmployee = cnapsEmployeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found id=" + id));
        return employeeMapper.toCnapsEmployeeRest(employee,cnapsEmployee);
    }



    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
        cnapsEmployeeRepository.save(employeeMapper.toCnapsEmployeeDomain(employee));
    }

}
