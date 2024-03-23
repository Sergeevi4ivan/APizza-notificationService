package ru.panas.APizzanotificationService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private UUID id;
    private UUID userId;
    private LocalDateTime date;
    private Double price;
    private OrderStatus status;

    private Collection<Pizza> pizzas;

}
