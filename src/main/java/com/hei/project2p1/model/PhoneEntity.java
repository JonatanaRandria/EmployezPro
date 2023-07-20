package com.hei.project2p1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "\"phone\"")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PhoneEntity {
    @Id
    private Long Id;
    private String phoneNumber;
}
