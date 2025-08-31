package com.mobydigital.georef.service;

import java.util.List;

import com.mobydigital.georef.model.LocalidadResponse;
import com.mobydigital.georef.model.ProvinciaResponse;
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
        String url = apiURL + "/provincias?orden=nombre";
        ProvinciaResponse response = restTemplate.getForObject(url, ProvinciaResponse.class);
        return response.getProvincias();
    }

    public List<Localidad> getLocalidadesByProvinciaId(Long idProvincia) {
        String url = apiURL + "/localidades?provincia=" + idProvincia + "&max=5000&orden=nombre";
        LocalidadResponse reponse =  restTemplate.getForObject(url, LocalidadResponse.class);
        return reponse.getLocalidades();
    }

    public Provincia getProvinciaById(Long idProvincia) {
        String url = apiURL + "/provincias?id=" + idProvincia;
        ProvinciaResponse response =  restTemplate.getForObject(url, ProvinciaResponse.class);
        return response.getProvincias().get(0);
    }

    public Localidad getLocalidadById(Long idLocalidad) {
        String url = apiURL + "/localidades?id=" + idLocalidad;
        LocalidadResponse response =  restTemplate.getForObject(url, LocalidadResponse.class);
        return response.getLocalidades().get(0);
    }
}
