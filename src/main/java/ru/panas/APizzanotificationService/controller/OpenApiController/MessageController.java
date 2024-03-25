package ru.panas.APizzanotificationService.controller.OpenApiController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import ru.panas.APizzanotificationService.entity.User;

import java.util.UUID;

@Tag(name = "Отправка сообщеня в Кафка")
public interface MessageController {

    @Operation(summary = "Отправка сообщений в Кафка",
                description = "Отправка сообщений в Кафка для последующего " +
                        "получения e-mail пользователя")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {@Content(schema = @Schema(implementation = User.class))}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "BAD REQUEST",
                    content = {@Content(schema = @Schema(implementation = IllegalArgumentException.class))}
            )
    }
    )
    ResponseEntity<String> sendId(@RequestParam("id") @Parameter(description = "Id пользователя") UUID id);
}
