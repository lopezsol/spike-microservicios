package com.mobydigital.georef.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobydigital.georef.model.Municipio;
import com.mobydigital.georef.model.Provincia;
import com.mobydigital.georef.service.GeorefService;



@RestController
@RequestMapping("/locations")
public class GeorefController {
    @Autowired
    private GeorefService georefService;

    @GetMapping("/provincias")
    public List<Provincia> getProvincias() {
        return georefService.getProvincias();
    }

    @GetMapping("/provincias/{id}")
    public Provincia getProvinciaById(@PathVariable("id") Long idProvincia) {
        return georefService.getProvinciaById(idProvincia).get(0);
    }

    @GetMapping("/provincias/{id}/localidades")
    public List<Municipio> getLocalidadesByProvinciaId(@PathVariable("id") Long idProvincia) {
        return georefService.getLocalidadesByProvinciaId(idProvincia);
    }
    
    

}
