package app.hei.endpoint.service;

import app.hei.endpoint.dao.EmployeeDao;
import app.hei.endpoint.model.Employee;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;


@Service
public class EmployeeService {
    EmployeeDao employeeDao = new EmployeeDao();
    public List<Employee> getAllEmployee (HttpServletRequest request){
        return employeeDao.getEmployeeListFromCookies(request);
    }
    public String AddNewEmployee (HttpServletRequest request,HttpServletResponse response, Employee employee){
        EmployeeDao.saveEmployeeListToCookies(request,response,employee);
        return "redirect:/employeeList";
    }


}

