package ru.panas.APizzanotificationService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.panas.APizzanotificationService.service.kafka.KafkaProducer;

import java.util.UUID;

/**
 * Контроллер для отправки id в kafka
 */

@RestController
@RequestMapping("/kafka")
public class KafkaMessageController {

    private KafkaProducer kafkaProducer;

    @Autowired
    public KafkaMessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("sendid")
    public ResponseEntity<String> sendId(@RequestParam("id") UUID id) {
        kafkaProducer.sendIdOfUser(id);

        return ResponseEntity.ok("ID sent to the topic");
    }
}
