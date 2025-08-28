package com.mobydigital.gestor_proyectos_usuarios.middleware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

// Clase que actúa como consumidor de mensajes de Kafka
@Component
public class GestorProyectosUsuarios {

    private static final Logger logger = LoggerFactory.getLogger(GestorProyectosUsuarios.class);

    @KafkaListener(topics = "pizza-con-pala-topic", groupId = "group")
    public void listen(String message) {
        logger.info("Mensaje recivido en el grupo 'group': " + message);
    }
}
