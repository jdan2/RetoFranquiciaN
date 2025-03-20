package com.pragma.franquicias.domain.spi;

import com.pragma.franquicias.domain.model.FranquiciaModelo;
import reactor.core.publisher.Mono;

public interface IFranquiciaPersistencePort {
    Mono<FranquiciaModelo> agregarFranquicia(FranquiciaModelo franquiciaModelo);
}