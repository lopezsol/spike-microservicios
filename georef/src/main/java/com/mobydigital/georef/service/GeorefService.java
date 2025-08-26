package com.mobydigital.georef.service;

import java.util.Arrays;
import java.util.List;

import com.mobydigital.georef.model.MunicipioResponse;
import com.mobydigital.georef.model.ProvinciaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mobydigital.georef.model.Municipio;
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
        ProvinciaResponse response = restTemplate.getForObject(url, ProvinciaResponse.class);
        return response.getProvincias();
    }

    public List<Municipio> getLocalidadesByProvinciaId(Long idProvincia) {
        String url = apiURL + "/municipios?provincia=" + idProvincia + "&max=5000";
        MunicipioResponse reponse =  restTemplate.getForObject(url, MunicipioResponse.class);
        return reponse.getMunicipios();
    }

    public List<Provincia> getProvinciaById(Long idProvincia) {
        String url = apiURL + "/provincias?id=" + idProvincia;
        Provincia[] provincias =  restTemplate.getForObject(url, Provincia[].class);
        return Arrays.asList(provincias);
    }


}
