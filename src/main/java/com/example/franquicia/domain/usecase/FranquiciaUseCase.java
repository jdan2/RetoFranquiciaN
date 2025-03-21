package com.example.franquicia.domain.usecase;

import com.example.franquicia.domain.api.IFranquiciaServicePort;
import com.example.franquicia.domain.enums.TechnicalMessage;
import com.example.franquicia.domain.exceptions.BusinessException;
import com.example.franquicia.domain.model.FranquiciaModelo;
import com.example.franquicia.domain.spi.IFranquiciaPersistencePort;
import reactor.core.publisher.Mono;

public class FranquiciaUseCase implements IFranquiciaServicePort {


    private final IFranquiciaPersistencePort franquiciaPersistencePort;

    public FranquiciaUseCase(IFranquiciaPersistencePort franquiciaPersistencePort) {
        this.franquiciaPersistencePort = franquiciaPersistencePort;
    }

    @Override
    public Mono<FranquiciaModelo> actualizarFranquicia(FranquiciaModelo franquiciaModelo) {
        return franquiciaPersistencePort.buscarPorId(franquiciaModelo.getId())
                .switchIfEmpty(Mono.error(new BusinessException(TechnicalMessage.INVALID_FRANCHIES_ID)))
                .map(franquicia -> {
                    franquicia.setNombre(franquiciaModelo.getNombre());
                    return franquicia;
                })
                .flatMap(franquiciaPersistencePort::agregarFranquicia);
    }

    @Override
    public Mono<FranquiciaModelo> agregarFranquicia(FranquiciaModelo franquiciaModelo) {
        return  franquiciaPersistencePort.agregarFranquicia(franquiciaModelo);
    }

}
