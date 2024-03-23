package ru.panas.APizzanotificationService.service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Kafka producer. Отправляет в кафка id для последующего получения
 * e-mail пользователя для отправки уведомления
 */

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, UUID> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, UUID> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendIdOfUser(UUID id) {
        LOGGER.info(String.format("Message with ID sent: %s", id));

        Message<UUID> uuidMessage = MessageBuilder
                .withPayload(id)
                .setHeader(KafkaHeaders.TOPIC, "sendIdForGetEmail")
                .build();

        kafkaTemplate.send(uuidMessage);
    }
}
