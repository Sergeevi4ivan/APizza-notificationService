package ru.panas.APizzanotificationService.service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.panas.APizzanotificationService.entity.Order;
import ru.panas.APizzanotificationService.entity.User;
import ru.panas.APizzanotificationService.service.NotificationService;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    private static final String BODY_OF_MESSAGE = "Статус вашего заказа: ";
    private KafkaProducer kafkaProducer;
    private NotificationService notificationService;
    private static Order order;

    @KafkaListener(topics = "emailOfUser") // название топика надо уточнить у Оли. groupId если указали группу в yml файле
    public void comsume(User user) {
        LOGGER.info(String.format("Сообщение с e-mail из кафка получено. "));

        notificationService.sendNotification(user.getEmail(), BODY_OF_MESSAGE + order.getStatus().toString());
    }

    @KafkaListener(topics = "new-order-events")
    public void comsume(Order consumeOrder) {
        LOGGER.info(String.format("Сообщение с заказом из кафка получено. "));

        order = consumeOrder;
        kafkaProducer.sendIdOfUser(order.getId());

    }
}
