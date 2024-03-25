package ru.panas.APizzanotificationService.entity;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Статус заказа")
public enum OrderStatus {

    PENDING,
    CANCELED,
    COMPLETED
}
