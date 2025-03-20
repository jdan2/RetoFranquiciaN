package com.pragma.franquicias.infrastructure.input.rest;


import com.pragma.franquicias.application.dto.request.ProductoRequestDto;
import com.pragma.franquicias.application.dto.request.SucursalRequestDto;
import com.pragma.franquicias.application.dto.response.ProductoResponseDto;
import com.pragma.franquicias.application.dto.response.SucursalResponseDto;
import com.pragma.franquicias.application.handler.IProductoHandler;
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
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoRestController {

    private final IProductoHandler productoHandler;

    @Operation(summary = "Agregar un nuevo producto", description = "Crea un nuevo producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto creado exitosamente", content = @Content),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })

    @PostMapping("/{sucursalId}")
    public Mono<ResponseEntity<ProductoResponseDto>> agregarProducto(@PathVariable Long sucursalId, @RequestBody ProductoRequestDto productoRequestDto) {
        return productoHandler.agregarProducto(sucursalId, productoRequestDto)
                .map(productoResponseDto -> ResponseEntity.status(HttpStatus.CREATED).body(productoResponseDto));
    }

}