package com.pragma.franquicias.application.handler;

import com.pragma.franquicias.application.dto.request.ProductoRequestDto;
import com.pragma.franquicias.application.dto.request.SucursalRequestDto;
import com.pragma.franquicias.application.dto.response.ProductoResponseDto;
import com.pragma.franquicias.application.dto.response.SucursalResponseDto;
import reactor.core.publisher.Mono;

public interface IProductoHandler {

    Mono<ProductoResponseDto>  agregarProducto(Long sucursalId, ProductoRequestDto productoRequestDto);

}