package com.mobydigital.user.repository;

import com.mobydigital.user.DTO.ProjectDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/* Esta clase es un cliente Feign para acceder a los servicios del microservicio de proyectos.
"project" es el nombre del servicio indicado en spike-microservicios/project/resources/application.properties. */
@FeignClient(name = "project")
public interface ProjectAPI {
    @GetMapping("projects/{id}")
    public ProjectDTO findProjectById(@PathVariable Long id);
}