package com.pragma.franquicias.domain.api;

import com.pragma.franquicias.domain.model.FranquiciaModelo;
import com.pragma.franquicias.domain.model.SucursalModelo;
import reactor.core.publisher.Mono;

public interface ISucursalServicePort {

    Mono<SucursalModelo>  agregarSucursal(SucursalModelo sucursalModelo);

}