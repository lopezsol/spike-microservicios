package com.mobydigital.gestor_proyectos_usuarios.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
public class KafkaConsumerConfig {

    // Configuraciones del consumidor de Kafka
    @Bean
    public Map<String, Object> consumerProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Lista de brokers de Kafka en el clúster
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group"); // Identificador del grupo de consumidores
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true); // Está true :)
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100"); // Determina si se hará el commit de forma periódica a los offsets
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000"); // Tiempo de espera para detectar fallos en los consumidores
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class); // Para deserializar la llave
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class); // Para deserializar el contenido del mensaje
        return properties;
    }

    // Configuraciones del factory del consumer de Kafka
    @Bean
    public ConsumerFactory<Integer, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerProperties());
    }

    // Configuraciones del factory de listener de Kafka
    @Bean
    public ConcurrentKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
