package com.hei.project2p1.controller.model;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdentityCardModel {
    private String cinNumber;
    private LocalDate cinIssueDate;
    private String cinIssuePlace;
}
