package com.hei.project2p1.model;

import com.hei.project2p1.model.utils.SocialCategory;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "\"employee\"")
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity implements Serializable  {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String ref;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    @Lob
    private String profileImage;
    private String sex;

    @OneToMany
    @Column(name = "phone_numbers")
    private List<PhoneEntity> phoneNumbers;

    private String address;
    @Column(name = "work_mail")
    private String workMail;

    @Column(name = "personal_mail")
    private String personalMail;


    @OneToOne
    private IdentityCardEntity identityCard;

    private String jobFunction;
    private int numberOfChildren;

    private LocalDate hireDate;
    private LocalDate departureDate;


    private SocialCategory socioProfessionalCategory;
    private String cnapsNumber;

    @PrePersist
    public void generateCustomMatriculate() {
        if (ref == null) {
            ref = String.format("Employee-ref-%s", Instant.now().toEpochMilli());
        }
    }
}
