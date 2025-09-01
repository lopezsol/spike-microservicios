package com.mobydigital.project.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerProject{

    // Configuracion del Producer de Kafka
    @Bean
    public Map<String, Object> producerProperties() {
         Map<String, Object> properties = new HashMap<>();

         properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Lista de brokers de Kafka en el clÃºster
         properties.put(ProducerConfig.RETRIES_CONFIG, 0); // Define la cantidad de intentos en caso de error.
         properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384); // Agruga los registros en batches, mejorando el performance (re chanta)
         properties.put(ProducerConfig.LINGER_MS_CONFIG, 1); // Defiene el tiempo en ms en el que se agrupan los batches
         properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432); // Define el espacio de memoria para colocar los mensajes que estan pendientes
         properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class); // Para Serializar la llave
         properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // Para Serializar el contenido del mensaje

    
         return properties;
    }

    // Configuracion para crear un Kafka Template
    @Bean
    public KafkaTemplate<Long, String> createTemplate(){
        Map<String, Object> senderProperties = producerProperties(); // Resivimos las propiedades del producer
        ProducerFactory<Long, String> producerFactory = new DefaultKafkaProducerFactory<Long, String>(senderProperties); // Creamos un Producer Factory con las propiedades que resivimos 
        KafkaTemplate<Long, String> template = new KafkaTemplate<>(producerFactory); // Creamos el Kafka Template con el Producer Factory
        return template;
    } 

}
