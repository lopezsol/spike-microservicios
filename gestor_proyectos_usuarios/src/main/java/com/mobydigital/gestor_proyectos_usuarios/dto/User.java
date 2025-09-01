package com.mobydigital.gestor_proyectos_usuarios.dto;

import java.util.List;

// import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long id;
    private String firstName;
    private String lastName;

    // Location
    private Long province;
    private Long locality;

    // Tecnología actual
    private String currentTechnology;

    // Referente
    private String referent;
    
    // Talent partner
    private String talentPartner;

    // Lista de proyectos asociados al usuario
    List<Long> projects;

    public User(Long id, String firstName, String lastName, Long province, Long locality, String currentTechnology,
            String referent, String talentPartner, List<Long> projects) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.province = province;
        this.locality = locality;
        this.currentTechnology = currentTechnology;
        this.referent = referent;
        this.talentPartner = talentPartner;
        this.projects = projects;
    }

    
}
