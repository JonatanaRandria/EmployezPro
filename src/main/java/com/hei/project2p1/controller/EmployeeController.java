package com.hei.project2p1.controller;

import com.hei.project2p1.controller.mapper.EmployeeMapper;
import com.hei.project2p1.controller.rest.model.RestEmployee;
import com.hei.project2p1.model.Employee;
import com.hei.project2p1.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@AllArgsConstructor
    public class EmployeeController {

     private final EmployeeService employeeService;
     private final EmployeeMapper employeeMapper;

    @GetMapping(value = "/")
    public String index(Model model) {
        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees",employees);
        model.addAttribute("newEmployee", new Employee());
        return "index";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("newEmployee") RestEmployee employee) throws IOException {
        employeeService.saveEmployee(employeeMapper.toDomain(employee));
        return "redirect:/";
    }

    @GetMapping(value = "/employee/{id}")
    public String getEmployeeById(@PathVariable Long id,Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "employee/employeeProfile";
    }
    }
