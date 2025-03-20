package com.pragma.franquicias.application.handler;

import com.pragma.franquicias.application.dto.request.SucursalRequestDto;
import com.pragma.franquicias.application.dto.response.SucursalResponseDto;
import reactor.core.publisher.Mono;

public interface ISucursalHandler {

    Mono<SucursalResponseDto>  agregarSucursal(Long franquiciaId, SucursalRequestDto sucursalRequestDto);

}