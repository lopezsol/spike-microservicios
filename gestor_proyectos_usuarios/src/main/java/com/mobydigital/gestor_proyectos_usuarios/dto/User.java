package com.mobydigital.gestor_proyectos_usuarios.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String firstName;
    private String lastName;

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
    private List<Long> idsProject;
}
