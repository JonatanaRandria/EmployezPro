package app.hei.endpoint.dao;

import app.hei.endpoint.dao.utils.cookieUtils;
import app.hei.endpoint.model.Employee;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static app.hei.endpoint.dao.utils.cookieUtils.COOKIE_NAME;
import static app.hei.endpoint.dao.utils.serialize.deserializeEmployeeList;
import static app.hei.endpoint.dao.utils.serialize.serializeEmployeeList;


public class EmployeeDao {
    public static List<Employee> getEmployeeListFromCookies(HttpServletRequest request) {
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
            return  new ArrayList<>();
        }
        return new ArrayList<>();
    }

    public static void saveEmployeeListToCookies(HttpServletRequest request,HttpServletResponse response, Employee employee) {
        List<Employee> employeeListNow = getEmployeeListFromCookies(request);
        employeeListNow.add(employee);
        String employeeData = serializeEmployeeList(employeeListNow);
        Cookie nowCookies = Arrays.stream(request.getCookies()).filter((e)-> Objects.equals(e.getName(), COOKIE_NAME)).findFirst().orElse(null);
        assert nowCookies != null;
        nowCookies.setValue(employeeData);
        response.addCookie(nowCookies);
    }
}
