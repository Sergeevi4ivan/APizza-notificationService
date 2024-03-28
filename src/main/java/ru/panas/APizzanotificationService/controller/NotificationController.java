package ru.panas.APizzanotificationService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.panas.APizzanotificationService.entity.Order;
import ru.panas.APizzanotificationService.entity.User;
import ru.panas.APizzanotificationService.service.EmailNotificationService;

import java.util.UUID;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final EmailNotificationService emailNotificationService;

    @Autowired
    public NotificationController(EmailNotificationService emailNotificationService) {
        this.emailNotificationService = emailNotificationService;
    }

    /**
     * Метод для отправки электронного письма. Сделан, для проверки и чтобы был.
     * @param email электронная почта, на которую будет отправлно письмо
     * @return
     */

    @GetMapping( value = "/send/{email}")
    public @ResponseBody ResponseEntity sendEmailForExample(@PathVariable("email") String email) {

        emailNotificationService.sendNotification(email, "Test of notification");

        return new  ResponseEntity<>("Check inbox", HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<HttpStatus> sendEmail(@RequestBody Order order) {
//        order.getId(); // использовать для запроса к сервису пользователей
//        String emailForSend = emailNotificationService.getEmailById(order.getId());
//        emailNotificationService.sendNotification(emailForSend, "Some body for user"); // вызвать метод отправки почты (почту взять из ответа от запроса выше)
//
//        return ResponseEntity.ok(HttpStatus.OK);
//    }


//    @ResponseStatus(HttpStatus.ACCEPTED)
//    @RequestMapping("/user/{id}")
//    public String getEmailById(@PathVariable UUID id) {
//        return emailNotificationService.getEmailById(id);
//    }




}
