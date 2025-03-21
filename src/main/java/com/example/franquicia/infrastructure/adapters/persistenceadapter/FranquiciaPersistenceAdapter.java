package com.example.franquicia.infrastructure.adapters.persistenceadapter;

import com.example.franquicia.domain.model.FranquiciaModelo;
import com.example.franquicia.domain.spi.IFranquiciaPersistencePort;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.mapper.FranquiciaEntityMapper;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.repository.IFranquiciaRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class FranquiciaPersistenceAdapter implements IFranquiciaPersistencePort {

    private final IFranquiciaRepository franquiciaRepository;
    private final FranquiciaEntityMapper franquiciaEntityMapper;


    @Override
    public Mono<FranquiciaModelo> agregarFranquicia(FranquiciaModelo franquiciaModelo) {
        return Mono.just(franquiciaEntityMapper.toEntity(franquiciaModelo))
                .flatMap(franquiciaRepository::save)
                .map(franquiciaEntityMapper::toModel);

    }

    @Override
    public Mono<FranquiciaModelo> buscarPorId(Long id) {
        return franquiciaRepository.findById(id)
                .map(franquiciaEntityMapper::toModel);
    }
}
