package ru.panas.APizzanotificationService.service.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.panas.APizzanotificationService.entity.Order;
import ru.panas.APizzanotificationService.entity.User;
import ru.panas.APizzanotificationService.service.NotificationService;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    private static final String BODY_OF_MESSAGE = "Статус вашего заказа: ";
    private static Order order;

    private final KafkaProducer kafkaProducer;
    private final NotificationService notificationService;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "emailOfUser", groupId = "myGroupId") // название топика надо уточнить у Оли. groupId если указали группу в yml файле
    public void consumeEmail(String email) {
        LOGGER.info(String.format("Сообщение с e-mail из кафка получено. "));

        notificationService.sendNotification(email, BODY_OF_MESSAGE + order.getStatus().toString());
    }

    @KafkaListener(topics = {"new-order-events","update-order-events"}, groupId = "myGroupId")
    public void consumeOrder(String orderJson) throws JsonProcessingException {
        LOGGER.info(String.format("Сообщение с заказом из кафка получено. "));

        order = objectMapper.readValue(orderJson, Order.class);
        kafkaProducer.sendIdOfUser(order.getUserId());
    }
}
