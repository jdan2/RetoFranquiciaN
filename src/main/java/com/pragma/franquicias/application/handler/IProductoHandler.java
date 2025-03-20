package com.pragma.franquicias.application.handler;

import com.pragma.franquicias.application.dto.request.ProductoNombreRequestDto;
import com.pragma.franquicias.application.dto.request.ProductoRequestDto;
import com.pragma.franquicias.application.dto.request.StockRequestDto;
import com.pragma.franquicias.application.dto.response.ProductoMaxStockResponseDto;
import com.pragma.franquicias.application.dto.response.ProductoResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductoHandler {

    Mono<ProductoResponseDto>  agregarProducto(Long sucursalId, ProductoRequestDto productoRequestDto);
    Mono<Void>  eliminarProducto(Long productoId);
    Mono<ProductoResponseDto>  actualizarStock(Long productoId, StockRequestDto stockRequestDto );
    Flux<ProductoMaxStockResponseDto> obtenerProductoMaxStockPorSucursal(Long franquiciaId);
    Mono<ProductoResponseDto>  actualizarNombre(Long productoId, ProductoNombreRequestDto productoNombreRequestDto );


}