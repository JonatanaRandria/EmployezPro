package com.hei.project2p1.model.validator;

import com.hei.project2p1.controller.model.EmployeeModel;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import java.util.function.Consumer;

public class EmployeeValidator implements Consumer<EmployeeModel> {
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Override
    public void accept(EmployeeModel employeeModel) {
        Set<ConstraintViolation<EmployeeModel>> violations = validator.validate(employeeModel);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<EmployeeModel> violation : violations) {
                sb.append(violation.getPropertyPath())
                        .append(": ")
                        .append(violation.getMessage())
                        .append(", ");
            }
            throw new IllegalArgumentException(sb.toString());
        }
    }
}