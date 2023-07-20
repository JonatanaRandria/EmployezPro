package com.hei.project2p1.model;

import com.hei.project2p1.model.utils.SocialCategory;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "\"employee\"")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity extends UserEntity implements Serializable  {
    private String ref;
    private String firstName;
    private String lastName;
    private String birthDate;
    @Lob
    private String profileImage;
    private String sex;

    @OneToMany
    private List<PhoneEntity> phoneNumbers;

    private String address;
    private String personalEmail;
    private String workEmail;

    @OneToOne
    private IdentityCardEntity identityCard;

    private String jobFunction;
    private int numberOfChildren;

    private LocalDate hireDate;
    private LocalDate departureDate;

    private SocialCategory socioProfessionalCategory;
    private String cnapsNumber;

}
