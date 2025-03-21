package com.example.franquicia.domain.spi;

import com.example.franquicia.domain.model.SucursalModelo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ISucursalPersistencePort {

    Mono<SucursalModelo> agregarSucursal(SucursalModelo sucursalModelo);
    Flux<SucursalModelo> buscarPorFranquiciaId(Long franquiciaId);
    Mono<SucursalModelo> buscarPorId(Long sucursalId);
}
