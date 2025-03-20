package com.pragma.franquicias.domain.spi;

import com.pragma.franquicias.domain.model.FranquiciaModelo;
import com.pragma.franquicias.domain.model.SucursalModelo;
import reactor.core.publisher.Mono;

public interface ISucursalPersistencePort {
    Mono<SucursalModelo> agregarSucursal(SucursalModelo sucursalModelo);
}