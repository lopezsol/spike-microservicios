package com.mobydigital.georef.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
// La lista de municipios que proviene de la API
public class LocalidadResponse {
    @JsonProperty("localidades")
    private List<Localidad> localidades;

    public List<Localidad> getLocalidades() {
        return localidades;
    }
}

