package com.example.franquicia.domain.spi;

import com.example.franquicia.domain.model.FranquiciaModelo;

import reactor.core.publisher.Mono;

public interface IFranquiciaPersistencePort {
    Mono<FranquiciaModelo> agregarFranquicia(FranquiciaModelo franquiciaModelo);
    Mono<FranquiciaModelo> buscarPorId(Long id);
}
