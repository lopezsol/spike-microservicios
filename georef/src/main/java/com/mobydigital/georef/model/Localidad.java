package com.mobydigital.georef.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Localidad {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nombre")
    private String nombre;
}
