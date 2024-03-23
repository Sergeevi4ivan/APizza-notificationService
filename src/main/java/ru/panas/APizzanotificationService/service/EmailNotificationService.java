package ru.panas.APizzanotificationService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.panas.APizzanotificationService.entity.User;

import java.util.UUID;

@Service
public class EmailNotificationService implements NotificationService{

    private final WebClient webClient;
    private final String NOTIFICATION_FROM = "APizza";
    private final String NOTIFICATION_SUBJECT = "Notification";
    private final String BASE_URL = "http://localhost:8080/api";

    @Autowired
    private JavaMailSender mailSender;

    public EmailNotificationService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
    }

    @Override
    public void sendNotification(String address, String body) {


        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(NOTIFICATION_FROM);
        mailMessage.setTo(address);
        mailMessage.setSubject(NOTIFICATION_SUBJECT);
        mailMessage.setText(body);

        mailSender.send(mailMessage);

        System.out.println("Email sent successfully!");
    }

    // Этот метод нужен, если захотим запрашивать email сразу у сервиса, а не через кафка
//    public String getEmailById(UUID id) {
//
//        Mono<User> monoUser = webClient.get()
//                .uri("/notification/user/{id}", id)                         // uri надо уточнить
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .retrieve()
//                .bodyToMono(User.class);
//
//        return monoUser.map(User::getEmail).toString();
//    }
}
