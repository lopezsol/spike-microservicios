package com.mobydigital.gestor_proyectos_usuarios.middleware;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.mobydigital.gestor_proyectos_usuarios.dto.Project;
import com.mobydigital.gestor_proyectos_usuarios.dto.ProjectDTO;
import com.mobydigital.gestor_proyectos_usuarios.dto.User;
import com.mobydigital.gestor_proyectos_usuarios.dto.UserDTO;
import com.mobydigital.gestor_proyectos_usuarios.service.ProjectAPI;
import com.mobydigital.gestor_proyectos_usuarios.service.UserAPI;

// Clase que actúa como consumidor de mensajes de Kafka
@Component
public class GestorProyectosUsuarios {

    @Autowired
    private UserAPI userAPI;

    @Autowired
    private ProjectAPI projectAPI;

    private static final Logger logger = LoggerFactory.getLogger(GestorProyectosUsuarios.class);

    @KafkaListener(topics = "mentoria-back-topic", groupId = "group")
    public void listen(String message) {
        if(message.startsWith("AUP")) {
            agregarUsuarioProyecto(message);
        } 
        logger.info("Mensaje recibido en el grupo 'group': " + message);
    }
    public void agregarUsuarioProyecto(String message) {
        // Lógica para procesar el mensaje recibido
        logger.info("Procesando mensaje: " + message);
        String[] parts = message.split(" ");
        Long userId = Long.parseLong(parts[2]);
        Long projectId = Long.parseLong(parts[4]);
        // Log para ver si se parseo correctamente
        logger.info(String.valueOf(userId) + "!!!!!!!!!!!!!!!!!!!!!!!");
        logger.info(String.valueOf(projectId) + "!!!!!!!!!!!!!!!!!!!!!!");
        UserDTO userDTO = userAPI.getUserById(userId);
        logger.info(userDTO.getFirstName());
        Project project = projectAPI.findProjectById(projectId);
        logger.info(project.getName());

        // Aquí iría la lógica para asignar el usuario al proyecto
        if(userDTO != null && project != null) {
            logger.info("Usuario con ID " + userId + " agregado al proyecto con ID " + projectId);
        }
        else {
            logger.warn("No se pudo encontrar el usuario o el proyecto. UserID: " + userId + ", ProjectID: " + projectId);
        }
    }
}