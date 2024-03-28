package ru.panas.APizzanotificationService.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Collection;

@Tag(name = "Сущность заказа")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Schema(description = "Идентификатор заказа", example = "3422b448-2460-4fd2-9183-8000de6f8343")
    private UUID id;

    @Schema(description = "Идентификатор пользователя", example = "3422b448-2460-4fd2-9183-8000de6f8343")
    private UUID userId;

    @Schema(description = "Дата заказа", example = "12.05.2024")
    private LocalDateTime date;

    @Schema(description = "Цена заказа", example = "569,25")
    private Double price;

    @Schema(description = "Статус заказа", example = "PENDING")
    private OrderStatus status;

    @Schema(description = "Список заказов")
    private Collection<UUID> pizzas;

}
