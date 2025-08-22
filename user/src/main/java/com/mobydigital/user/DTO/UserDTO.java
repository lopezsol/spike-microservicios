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
    private String name;

    // private Long idProject;
    // private String nameProject;

    // Incluimos la lista de proyectos
    List<ProjectDTO> projects;
}
