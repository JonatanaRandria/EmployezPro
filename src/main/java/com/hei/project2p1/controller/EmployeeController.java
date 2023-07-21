package com.hei.project2p1.controller;

import com.hei.project2p1.controller.mapper.EmployeeMapper;
import com.hei.project2p1.controller.model.EmployeeModel;
import com.hei.project2p1.controller.model.UserModel;
import com.hei.project2p1.model.EmployeeEntity;
import com.hei.project2p1.service.EmployeeService;
import com.hei.project2p1.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
    public class EmployeeController extends AuthenticatedController {

     private final EmployeeService employeeService;
     private final EmployeeMapper employeeMapper;
     private final UserService userService;

    @GetMapping(value = "/")
    public String index(Model model) {

        List<EmployeeEntity> employeeEntities = employeeService.getEmployees();
        model.addAttribute("employeeEntities", employeeEntities);
        return "index";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("newEmployee") EmployeeModel employee) throws IOException {
        employeeService.saveEmployee(employeeMapper.toDomain(employee));
        return "redirect:/";
    }
    @GetMapping("/addEmployee")
    public String addEmployee(Model model) throws IOException {
        model.addAttribute("newEmployee", new EmployeeEntity());
        return "employee/addEmployee";
    }
    @GetMapping(value = "/employee/{id}")
    public String getEmployeeById(@PathVariable Long id,Model model) {
        EmployeeEntity employeeEntity = employeeService.getEmployeeById(id);
        model.addAttribute("employeeEntity", employeeEntity);
        return "employee/employeeProfile";
    }

    @GetMapping(value = "/employee/{id}/edit")
    public String UpdateEmployeeById(@PathVariable Long id,Model model) {
        EmployeeEntity employeeEntity = employeeService.getEmployeeById(id);
        model.addAttribute("employeeEntity", employeeEntity);
        return "employee/updateEmployee";
    }
    @GetMapping(value = "/login")
    public String LoginPage() {
        return "register/login";
    }

    @PostMapping(value = "/login")
    public String Login(@ModelAttribute("employee")UserModel userModel, HttpSession response) {
       boolean auth = userService.authenticated(userModel.getUserName(),userModel.getPassword(),response);
        if(auth){
            return "index";
        }
        return  "register/login";

    }



    }
