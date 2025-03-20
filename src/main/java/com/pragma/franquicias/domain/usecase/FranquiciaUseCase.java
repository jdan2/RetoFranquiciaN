package com.pragma.franquicias.domain.usecase;

import com.pragma.franquicias.domain.api.IFranquiciaServicePort;
import com.pragma.franquicias.domain.exception.DomainException;
import com.pragma.franquicias.domain.model.FranquiciaModelo;
import com.pragma.franquicias.domain.spi.IFranquiciaPersistencePort;
import reactor.core.publisher.Mono;

public class FranquiciaUseCase implements IFranquiciaServicePort {

    private final IFranquiciaPersistencePort franquiciaPersistencePort;

    public FranquiciaUseCase(IFranquiciaPersistencePort franquiciaPersistencePort) {
        this.franquiciaPersistencePort = franquiciaPersistencePort;
    }


    @Override
    public Mono<FranquiciaModelo> agregarFranquicia(FranquiciaModelo franquiciaModelo) {
        return franquiciaPersistencePort.agregarFranquicia(franquiciaModelo);
    }
}