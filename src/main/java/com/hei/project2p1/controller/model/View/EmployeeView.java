package com.hei.project2p1.controller.model.View;

import com.hei.project2p1.controller.model.IdentityCardModel;
import com.hei.project2p1.model.utils.SocialCategory;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeView {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String profileImage;

    @Column(name = "\"sex\"")
    @Enumerated(EnumType.STRING)
    private com.hei.project2p1.controller.model.EmployeeModel.Sex sex;

    private String phoneNumbers;

    private String address;
    private String personalMail;
    private String workMail;
    private String cinNumber;
    private String cinPlace;
    private LocalDate cinDate;
    private String jobFunction;
    private int numberOfChildren;
    private LocalDate hireDate;
    private LocalDate departureDate;

    @Enumerated(EnumType.STRING)
    private SocialCategory socioProfessionalCategory;
    private String cnapsNumber;


}
