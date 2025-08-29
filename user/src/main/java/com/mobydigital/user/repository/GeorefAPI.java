package com.mobydigital.user.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mobydigital.user.DTO.LocalidadDTO;
import com.mobydigital.user.DTO.ProvinciaDTO;

@FeignClient(name = "georef")
public interface GeorefAPI {

    @GetMapping("/locations/provincias")
    public List<ProvinciaDTO> getProvincias();

    @GetMapping("/locations/provincias/{id}")
    public ProvinciaDTO getProvinciaById(@PathVariable("id") Long id);

    @GetMapping("/locations/provincias/{id}/localidades")
    public List<LocalidadDTO> getLocalidadesByProvinciaId(@PathVariable("id") Long id);

    @GetMapping("/locations/localidades/{id}")
    public LocalidadDTO getLocalidadById(@PathVariable("id") Long id);
}
