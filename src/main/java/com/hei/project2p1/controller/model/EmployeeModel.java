package com.hei.project2p1.controller.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
    private String firstName;
    private String lastName;
    private String birthDate;
    private MultipartFile profileImage;
    private String sex;
    private List<String> phoneNumbers;
    private String address;
    private String personalEmail;
    private String workEmail;
    private String cinNumber;
    private LocalDate cinIssueDate;
    private String cinIssuePlace;
    private String jobFunction;
    private int numberOfChildren;
    private LocalDate hireDate;
    private LocalDate departureDate;
    private String socioProfessionalCategory;
    private String cnapsNumber;
}
