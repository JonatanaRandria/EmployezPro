package com.hei.project2p1.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "\"employee\"")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String matricule;
    private String firstName;
    private String lastName;
    private String birthDate;
    @Lob
    private String profileImage;
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
