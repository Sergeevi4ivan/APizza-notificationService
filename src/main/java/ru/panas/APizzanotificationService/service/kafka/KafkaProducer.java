package ru.panas.APizzanotificationService.service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Kafka producer. Отправляет в кафка id для последующего получения
 * e-mail пользователя для отправки уведомления
 */

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String, UUID> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, UUID> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendIdOfUser(UUID id) {
        LOGGER.info(String.format("Message with ID sent: %s", id));
        kafkaTemplate.send("sendIdForGetEmail", id);
    }
}
