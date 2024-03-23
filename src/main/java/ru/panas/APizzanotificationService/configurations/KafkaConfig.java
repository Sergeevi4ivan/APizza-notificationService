package ru.panas.APizzanotificationService.configurations;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Конфигурация для создания topic в Kafka
 */

@Configuration
@EnableKafka
public class KafkaConfig {

    @Bean
    public NewTopic kafkaTopicForNotification() {
        return TopicBuilder.name("sendIdForGetEmail")

                .build();
    }
}
