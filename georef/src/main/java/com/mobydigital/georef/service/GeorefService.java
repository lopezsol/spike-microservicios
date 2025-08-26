package com.mobydigital.georef.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mobydigital.georef.model.Localidad;
import com.mobydigital.georef.model.Provincia;

@Service
public class GeorefService {
    @Autowired
    private RestTemplate restTemplate;
    private String apiURL;

    public GeorefService() {
        this.restTemplate = new RestTemplate();
        this.apiURL = "https://apis.datos.gob.ar/georef/api";
    }

    public List<Provincia> getProvincias() {
        String url = apiURL + "/provincias";
        Provincia[] provincias =  restTemplate.getForObject(url, Provincia[].class);
        return Arrays.asList(provincias);
    }

    public List<Localidad> getLocalidadesByProvinciaId(Long idProvincia) {
        String url = apiURL + "/localidades?provincia=" + idProvincia;
        Localidad[] localidades =  restTemplate.getForObject(url, Localidad[].class);
        return Arrays.asList(localidades);
    }

    public List<Provincia> getProvinciaById(Long idProvincia) {
        String url = apiURL + "/provincias?id=" + idProvincia;
        Provincia[] provincias =  restTemplate.getForObject(url, Provincia[].class);
        return Arrays.asList(provincias);
    }


}
