package app.hei.endpoint.model;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Employee {
    private String id;
    private String name;
    private String firstName;
    private LocalDate birthDate;
}