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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Provincia {
    private Long id;
    private String nombre;
}
