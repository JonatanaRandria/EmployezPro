package app.hei.endpoint.dao.utils;

import app.hei.endpoint.model.Employee;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class serialize {


    public static String serializeEmployeeList(List<Employee> employeeList) {
        return employeeList.stream()
                .map(employee -> employee.getName() + "|" + employee.getFirstName() + "|" + employee.getBirthDate().format(DateTimeFormatter.ISO_LOCAL_DATE))
                .collect(Collectors.joining(";"));
    }
    public static List<Employee> deserializeEmployeeList(String employeeData) {
        return Arrays.stream(employeeData.split(";"))
                .map(data -> {
                    String[] parts = data.split("\\|");
                    Employee employee = new Employee();
                    employee.setName(parts[0]);
                    employee.setFirstName(parts[1]);
                    employee.setBirthDate(LocalDate.parse(parts[2]));
                    return employee;
                })
                .collect(Collectors.toList());
    }
}
