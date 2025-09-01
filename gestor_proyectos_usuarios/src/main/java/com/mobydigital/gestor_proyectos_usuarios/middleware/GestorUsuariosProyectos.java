package com.mobydigital.gestor_proyectos_usuarios.middleware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.mobydigital.gestor_proyectos_usuarios.dto.Project;
import com.mobydigital.gestor_proyectos_usuarios.dto.User;
import com.mobydigital.gestor_proyectos_usuarios.service.ProjectAPI;
import com.mobydigital.gestor_proyectos_usuarios.service.UserAPI;

@Component
public class GestorUsuariosProyectos {

    @Autowired
    private UserAPI userService;

    @Autowired
    private ProjectAPI projectService;

    // Logger logger = LoggerFactory.getLogger(String.class);

    // @Autowired
    // private KafkaTemplate<Long, String> kafkaTemplate;

    @KafkaListener(topics = "mentoria-back-topic", groupId = "group")
    public void listen(String mensaje){
        if(mensaje.startsWith("AUP")){
            agregarUsuarioProyecto(mensaje);
        }
    }

    public void agregarUsuarioProyecto(String mensaje){
        // AUP UID 2 PID 4
        String[] partes = mensaje.split(" ");
        Long userId = Long.parseLong(partes[2]);
        Long projectId = Long.parseLong(partes[4]);

        User user = userService.getAllUsers().stream()
                    .filter(u -> u.getId().equals(userId))
                    .findFirst()
                    .orElse(null);
        Project project = projectService.findProjectById(projectId);

        if(user != null && project != null) {
            user.getIdsProject().add(projectId);
            userService.updateUser(userId, user);
            // System.out.println("El usuario ha sido actualizado correctamente.");
        }
    }


}
