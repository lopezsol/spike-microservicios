package com.mobydigital.user.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;

    // Location
    private ProvinciaDTO province;
    private LocalidadDTO locality;

    // Tecnología actual
    private String currentTechnology;

    // Referente
    private String referent;
    
    // Talent partner
    private String talentPartner;

    // Lista de proyectos asociados al usuario
    List<ProjectDTO> projects;
}
