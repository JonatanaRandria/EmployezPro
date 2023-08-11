package td.example.prog4.employeedb.controller.validator.utils;

public class StringValidator {
    public static boolean isNotNullAndNotBlank(String s) {
        return s != null && !s.isBlank();
    }
}
