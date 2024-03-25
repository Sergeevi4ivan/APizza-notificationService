package ru.panas.APizzanotificationService.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Tag(name = "Сущность пользователя")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Schema(description = "Идентификатор пользователя", example = "3422b448-2460-4fd2-9183-8000de6f8343")
    private UUID id;

    @Schema(description = "Имя пользователя", example = "Иванов Иван")
    private String name;

    @Schema(description = "e-mail пользователя", example = "ivanov@gmail.com")
    private String email;

    @Schema(description = "Дата рождения пользователя", example = "15.01.2000")
    private LocalDate dateOfBirth;

    @Schema(description = "Пол пользователя", example = "муж")
    private String male;
}
