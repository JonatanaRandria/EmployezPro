package app.hei.endpoint.model;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private String nom;
    private String prenoms;
    private LocalDate dateNaissance;

    // Constructeurs, getters et setters
}