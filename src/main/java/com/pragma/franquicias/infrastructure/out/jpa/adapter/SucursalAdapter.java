package com.pragma.franquicias.infrastructure.out.jpa.adapter;

import com.pragma.franquicias.domain.model.SucursalModelo;
import com.pragma.franquicias.domain.spi.ISucursalPersistencePort;
import com.pragma.franquicias.infrastructure.out.jpa.mapper.ISucursalEntityMapper;
import com.pragma.franquicias.infrastructure.out.jpa.repository.ISucursalRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class SucursalAdapter implements ISucursalPersistencePort {

    private final ISucursalRepository sucursalRepository;
    private final ISucursalEntityMapper sucursalEntityMapper;

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