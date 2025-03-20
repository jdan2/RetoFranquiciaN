package com.pragma.franquicias.infrastructure.input.rest;


import com.pragma.franquicias.application.dto.request.FranquiciaRequestDto;
import com.pragma.franquicias.application.dto.response.FranquiciaResponseDto;
import com.pragma.franquicias.application.handler.IFranquiciaHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/franquicias")
@RequiredArgsConstructor
public class FranquiciasRestController {

    private final IFranquiciaHandler franquiciaHandler;

    @Operation(summary = "Agregar una nueva franquicia", description = "Crea una nueva franquicia con el nombre proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Franquicia creada exitosamente", content = @Content),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<FranquiciaResponseDto> agregarFranquicia(@RequestBody FranquiciaRequestDto request) {
        return franquiciaHandler.agregarFranquicia(request);
    }


}