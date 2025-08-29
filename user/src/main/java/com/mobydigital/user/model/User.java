package com.mobydigital.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    // El email por ahora no lo vamos a usar
    // private String email;

    // Location
    private Long idProvince;
    private Long idLocality;

    // Tecnología actual
    private String currentTechnology;

    // Referente
    private String referent;    

    // Talent partner
    private String talentPartner;

    // Un usuario puede tener varios proyectos
    @ElementCollection
    private List<Long> idsProject;
}
