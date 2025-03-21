package com.example.franquicia.infrastructure.adapters.persistenceadapter;

import com.example.franquicia.domain.model.SucursalModelo;
import com.example.franquicia.domain.spi.ISucursalPersistencePort;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.mapper.SucursalEntityMapper;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.repository.ISucursalRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class SucursalPersistenceAdapter implements ISucursalPersistencePort {

    private final ISucursalRepository sucursalRepository;
    private final SucursalEntityMapper sucursalEntityMapper;

    @Override
    public Mono<SucursalModelo> agregarSucursal(SucursalModelo sucursalModelo) {
        return Mono.just(sucursalEntityMapper.toEntity(sucursalModelo))
                .flatMap(sucursalRepository::save)
                .map(sucursalEntityMapper::toModel);
    }

    @Override
    public Flux<SucursalModelo> buscarPorFranquiciaId(Long franquiciaId) {
        return sucursalRepository.findByFranquiciaId(franquiciaId)
                .map(sucursalEntityMapper::toModel);
    }

    @Override
    public Mono<SucursalModelo> buscarPorId(Long sucursalId) {
        return sucursalRepository.findById(sucursalId)
                .map(sucursalEntityMapper::toModel);
    }
}
