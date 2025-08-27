package com.mobydigital.georef.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
// La anotación @JsonIgnoreProperties se utiliza para ignorar propiedades desconocidas durante la deserialización JSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class Provincia {
    private Long id;
    private String nombre;
}
