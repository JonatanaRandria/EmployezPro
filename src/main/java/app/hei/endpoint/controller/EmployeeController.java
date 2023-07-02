package app.hei.endpoint.controller;

import app.hei.endpoint.model.Employee;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EmployeeController {
    private static final String COOKIE_NAME = "employeeData";

    @GetMapping("/")
    public String employeeList(Model model, HttpServletRequest request) {
        List<Employee> employeeList = getEmployeeListFromCookies(request);
        model.addAttribute("employees", employeeList);
        model.addAttribute("newEmployee", new Employee());
        return "employeeList";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("newEmployee") Employee employee,
                              HttpServletResponse response,
                              HttpServletRequest request) {
        List<Employee> employeeList = getEmployeeListFromCookies(request);
        employeeList.add(employee);
        saveEmployeeListToCookies(response, employeeList);
        return "redirect:/";
    }

    private List<Employee> getEmployeeListFromCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Cookie employeeDataCookie = Arrays.stream(cookies)
                    .filter(cookie -> cookie.getName().equals(COOKIE_NAME))
                    .findFirst()
                    .orElse(null);

            if (employeeDataCookie != null) {
                String employeeData = employeeDataCookie.getValue();
                return deserializeEmployeeList(employeeData);
            }
        }
        return new ArrayList<>();
    }

    private void saveEmployeeListToCookies(HttpServletResponse response, List<Employee> employeeList) {
        String employeeData = serializeEmployeeList(employeeList);
        Cookie employeeDataCookie = new Cookie(COOKIE_NAME, employeeData);
        employeeDataCookie.setMaxAge(30 * 24 * 60 * 60); // Cookie expires in 30 days
        response.addCookie(employeeDataCookie);
    }

    private String serializeEmployeeList(List<Employee> employeeList) {
        return employeeList.stream()
                .map(employee -> employee.getNom() + "|" + employee.getPrenoms() + "|" + employee.getDateNaissance().format(DateTimeFormatter.ISO_LOCAL_DATE))
                .collect(Collectors.joining(";"));
    }

    private List<Employee> deserializeEmployeeList(String employeeData) {
        return Arrays.stream(employeeData.split(";"))
                .map(data -> {
                    String[] parts = data.split("\\|");
                    Employee employee = new Employee();
                    employee.setNom(parts[0]);
                    employee.setPrenoms(parts[1]);
                    employee.setDateNaissance(LocalDate.parse(parts[2], DateTimeFormatter.ISO_LOCAL_DATE));
                    return employee;
                })
                .collect(Collectors.toList());
    }
}
