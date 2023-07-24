package com.hei.project2p1.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@ToString
@Table(name = "\"card\"")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdentityCardEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String cinNumber;
    private LocalDate cinIssueDate;
    private String cinIssuePlace;
}
