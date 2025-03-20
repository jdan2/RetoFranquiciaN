package com.pragma.franquicias.infrastructure.out.jpa.adapter;

import com.pragma.franquicias.domain.model.FranquiciaModelo;
import com.pragma.franquicias.domain.spi.IFranquiciaPersistencePort;
import com.pragma.franquicias.infrastructure.out.jpa.mapper.IFranquiciaEntityMapper;
import com.pragma.franquicias.infrastructure.out.jpa.repository.IFranquiciaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class FranquiciaJpaAdapter implements IFranquiciaPersistencePort {

    private final IFranquiciaRepository franquiciaRepository;
    private final IFranquiciaEntityMapper franquiciaEntityMapper;

    @Override
    public Mono<FranquiciaModelo> agregarFranquicia(FranquiciaModelo franquiciaModelo) {
        return Mono.just(franquiciaEntityMapper.toEntity(franquiciaModelo))
                .flatMap(franquiciaRepository::save)
                .map(franquiciaEntityMapper::toModel);

    }
}