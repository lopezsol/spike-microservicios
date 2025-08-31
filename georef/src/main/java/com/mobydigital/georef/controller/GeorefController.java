package com.mobydigital.georef.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mobydigital.georef.model.Localidad;
import com.mobydigital.georef.model.Provincia;
import com.mobydigital.georef.service.GeorefService;



@RestController
@RequestMapping("/locations")
@CrossOrigin

public class GeorefController {
    @Autowired
    private GeorefService georefService;

    @GetMapping("/provincias")
    public List<Provincia> getProvincias() {
        return georefService.getProvincias();
    }

    @GetMapping("/provincias/{id}")
    public Provincia getProvinciaById(@PathVariable("id") Long idProvincia) {
        return georefService.getProvinciaById(idProvincia);
    }

    @GetMapping("/provincias/{id}/localidades")
    public List<Localidad> getLocalidadesByProvinciaId(@PathVariable("id") Long idProvincia) {
        return georefService.getLocalidadesByProvinciaId(idProvincia);
    }

    @GetMapping("/localidades/{id}")
    public Localidad getLocalidadById(@PathVariable("id") Long idLocalidad) {
        return georefService.getLocalidadById(idLocalidad);
    }

}
