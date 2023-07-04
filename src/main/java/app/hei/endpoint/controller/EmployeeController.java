package app.hei.endpoint.controller;

import app.hei.endpoint.controller.mapper.EmployeeMapper;
import app.hei.endpoint.controller.rest.EmployeeRest;
import app.hei.endpoint.model.Employee;
import app.hei.endpoint.service.EmployeeService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
@AllArgsConstructor
public class EmployeeController {

    private  final EmployeeService service;
    private final EmployeeMapper  employeeMapper;

    @GetMapping({ "/"})
    public ModelAndView getAllEmployees(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("employeeList");
        mav.addObject("employees",service.getAllEmployee(request) );
        return mav;
    }

    @GetMapping({"/addEmployeeForm"})
    public  ModelAndView addNewEmployee (){

        ModelAndView mav = new ModelAndView("add-new-employee-form");

        EmployeeRest newEmployee = new EmployeeRest();
        mav.addObject("employee", newEmployee);
        return mav;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute EmployeeRest employee,HttpServletResponse response,HttpServletRequest request) {
        Employee newEmployeeList = employeeMapper.ToRest(employee);
        service.AddNewEmployee(request,response,newEmployeeList);
        return "redirect:/";
    }
}
