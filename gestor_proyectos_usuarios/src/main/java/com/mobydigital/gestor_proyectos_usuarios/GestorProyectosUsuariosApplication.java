package com.mobydigital.gestor_proyectos_usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GestorProyectosUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorProyectosUsuariosApplication.class, args);
	}

}