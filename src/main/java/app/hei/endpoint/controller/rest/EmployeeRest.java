package app.hei.endpoint.controller.rest;

import lombok.*;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmployeeRest {
    private String name;
    private String firstName;
    private LocalDate birthDate;
}
