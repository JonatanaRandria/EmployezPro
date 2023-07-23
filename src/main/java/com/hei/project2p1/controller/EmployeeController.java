package com.hei.project2p1.controller;

import java.io.IOException;

import java.time.LocalDate;

import java.util.Date;
import java.util.List;

import com.hei.project2p1.model.utils.Sex;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hei.project2p1.controller.mapper.EmployeeMapper;
import com.hei.project2p1.controller.model.EmployeeModel;
import com.hei.project2p1.controller.model.UserModel;
import com.hei.project2p1.model.EmployeeEntity;
import com.hei.project2p1.model.UserEntity;
import com.hei.project2p1.service.EmployeeService;
import com.hei.project2p1.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class EmployeeController extends AuthenticatedController {
    private final EmployeeService employeeService;
    private final EmployeeMapper  employeeMapper;
    private final UserService     userService;

    @PostMapping(value = "/login")
    public String Login(@ModelAttribute("employee") UserModel userModel, HttpSession response) {
        userService.authenticated(userModel.getUserName(), userModel.getPassword(), response);
        response.setAttribute("user", userModel.getUserName());

        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String LoginPage(Model model, HttpServletRequest request, HttpSession session) {
        model.addAttribute("employee", new UserEntity());

        return "register/login";
    }

    @GetMapping(value = "/employee/{id}/edit")
    public String UpdateEmployeeById(@PathVariable Long id, Model model) {
        EmployeeEntity employeeEntity = employeeService.getEmployeeById(id);

        model.addAttribute("employeeEntity", employeeEntity);

        return "employee/updateEmployee";
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

    @GetMapping({ "/employee", "/" })
    public String index(Model model,
        @RequestParam(value= "lastName", required = false) String lastName,
        @RequestParam(value= "firstName", required = false) String firstName,
        @RequestParam(value= "jobFunction", required = false) String jobFunction,
        @RequestParam(value= "sex", required = false) String sex,
        @RequestParam(value= "entrance", required = false) String entrance,
        @RequestParam(value= "departure", required = false) String departure) {

        LocalDate hire = (entrance != null && !entrance.isEmpty()) ? LocalDate.parse(entrance) : null;
        LocalDate fired = (departure != null && !departure.isEmpty()) ? LocalDate.parse(departure) : null;

        if(lastName !=null || firstName != null || jobFunction != null){
            List<EmployeeEntity> employeeEntities = employeeService.getFilteredEmployees(firstName,lastName,jobFunction,hire,fired,sex);
            model.addAttribute("employeeEntities", employeeEntities);
            return "index";
        }
        List<EmployeeEntity> employeeEntities = employeeService.getEmployees();
        model.addAttribute("employeeEntities", employeeEntities);
        model.addAttribute("firstName", null);
        model.addAttribute("lastName", null);

        // Autres attributs du modèle, si nécessaire
        model.addAttribute("sex", null);
        model.addAttribute("jobFunction", null);
        model.addAttribute("hireDate", null);
        model.addAttribute("departureDate", null);

        return "index";
    }

    @GetMapping(value = "/employee/{id}")
    public String getEmployeeById(@PathVariable Long id, Model model) {
        EmployeeEntity employeeEntity = employeeService.getEmployeeById(id);

        model.addAttribute("employeeEntity", employeeEntity);

        return "employee/employeeProfile";
    }

    @GetMapping(value = "/employee/details")
    public String getEmployeeDetails() {

        return "employee/employeeDetails";
    }
}



