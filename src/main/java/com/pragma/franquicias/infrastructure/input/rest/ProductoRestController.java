package com.pragma.franquicias.infrastructure.input.rest;


import com.pragma.franquicias.application.dto.request.ProductoRequestDto;
import com.pragma.franquicias.application.dto.request.StockRequestDto;
import com.pragma.franquicias.application.dto.response.ProductoMaxStockResponseDto;
import com.pragma.franquicias.application.dto.response.ProductoResponseDto;
import com.pragma.franquicias.application.handler.IProductoHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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

    @Operation(
            summary = "Eliminar un producto",
            description = "Elimina un producto de una sucursal utilizando su ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Producto eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })

    @DeleteMapping("/{productoId}")
    public Mono<ResponseEntity<Void>> eliminarProducto(@PathVariable Long productoId) {
        return productoHandler.eliminarProducto(productoId)
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)));
    }

    @Operation(
            summary = "Modificar stock de un producto",
            description = "Permite actualizar la cantidad de stock de un producto existente."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Stock actualizado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PatchMapping("/{productoId}")
    public  Mono<ResponseEntity<ProductoResponseDto>> actualizarStock(
            @PathVariable Long productoId,
            @RequestBody StockRequestDto stockRequestDto) {
        return productoHandler.actualizarStock(productoId, stockRequestDto)
                .map(productoResponseDto -> ResponseEntity.status(HttpStatus.OK).body(productoResponseDto));
    }

    @Operation(
            summary = "Obtener productos con mayor stock por sucursal en una franquicia",
            description = "Devuelve una lista de productos con el mayor stock por sucursal para una franquicia específica."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos con mayor stock por sucursal"),
            @ApiResponse(responseCode = "400", description = "ID de franquicia inválido"),
            @ApiResponse(responseCode = "404", description = "Franquicia no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{franquiciaId}")
    public Flux<ProductoMaxStockResponseDto> obtenerProductosMaxStock(@PathVariable Long franquiciaId) {
        return productoHandler.obtenerProductoMaxStockPorSucursal(franquiciaId);
    }
}