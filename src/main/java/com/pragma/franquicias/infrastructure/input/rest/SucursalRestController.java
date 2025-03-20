package com.pragma.franquicias.infrastructure.input.rest;


import com.pragma.franquicias.application.dto.request.SucursalNombreRequestDto;
import com.pragma.franquicias.application.dto.request.SucursalRequestDto;
import com.pragma.franquicias.application.dto.response.SucursalResponseDto;
import com.pragma.franquicias.application.handler.ISucursalHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/sucursal")
@RequiredArgsConstructor
public class SucursalRestController {

    private final ISucursalHandler sucursalHandler;

    @Operation(summary = "Agregar una nueva sucursal", description = "Crea una nueva sucursal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sucursal creada exitosamente", content = @Content),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })

    @PostMapping("/{franquiciaId}")
    public Mono<ResponseEntity<SucursalResponseDto>> agregarSucursal(
            @PathVariable Long franquiciaId,
            @RequestBody SucursalRequestDto sucursalRequestDto) {

        return sucursalHandler.agregarSucursal(franquiciaId, sucursalRequestDto)
                .map(sucursal -> ResponseEntity.status(HttpStatus.CREATED).body(sucursal));
    }


    @Operation(
            summary = "Modificar nombre de una sucursal",
            description = "Permite actualizar el nombre de una sucursal existente."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nombre actualizado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
            @ApiResponse(responseCode = "404", description = "Sucursal no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PatchMapping("/{sucursalId}")
    public  Mono<ResponseEntity<SucursalResponseDto>> actualizarNombre(
            @PathVariable Long sucursalId,
            @RequestBody SucursalNombreRequestDto sucursalNombreRequestDto) {
        return sucursalHandler.actualizarSucursal(sucursalId, sucursalNombreRequestDto)
                .map(productoResponseDto -> ResponseEntity.status(HttpStatus.OK).body(productoResponseDto));
    }

}