package com.mobydigital.georef.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
// Esta clase es para obtener la respuesta de la API de provincias
public class ProvinciaResponse {
    private List<Provincia> provincias;

    public List<Provincia> getProvincias() {
        return provincias;
    }
}
