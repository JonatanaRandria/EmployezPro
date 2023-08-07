package com.hei.project2p1.controller.model;

import com.hei.project2p1.model.PhoneEntity;
import com.hei.project2p1.model.utils.SocialCategory;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Size;
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
    private LocalDate birthDate;
    private MultipartFile profileImage;

    @Column(name = "\"sex\"")
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private String ref;

    @Size(min = 13)

    private String phoneNumbers;

    private String address;
    private String personalMail;
    private String workMail;
    private IdentityCardModel cardModel;
    private String jobFunction;
    private int numberOfChildren;
    private LocalDate hireDate;
    private LocalDate departureDate;
    private String countryCode;
    private String code;

    @Enumerated(EnumType.STRING)
    private SocialCategory socioProfessionalCategory;
    private String cnapsNumber;

    public enum Sex {
       M,F
    }

    public enum Category{
        M1, M2, OS1, OS2, OS3, OP1
    }
}
