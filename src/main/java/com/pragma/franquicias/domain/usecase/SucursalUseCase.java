package com.pragma.franquicias.domain.usecase;

import com.pragma.franquicias.domain.api.IFranquiciaServicePort;
import com.pragma.franquicias.domain.api.ISucursalServicePort;
import com.pragma.franquicias.domain.exception.DomainException;
import com.pragma.franquicias.domain.model.FranquiciaModelo;
import com.pragma.franquicias.domain.model.SucursalModelo;
import com.pragma.franquicias.domain.spi.IFranquiciaPersistencePort;
import com.pragma.franquicias.domain.spi.ISucursalPersistencePort;
import reactor.core.publisher.Mono;

public class SucursalUseCase implements ISucursalServicePort {

    private final ISucursalPersistencePort sucursalPersistencePort;

    public SucursalUseCase(ISucursalPersistencePort sucursalPersistencePort) {
        this.sucursalPersistencePort = sucursalPersistencePort;
    }

    @Override
    public Mono<SucursalModelo> agregarSucursal(SucursalModelo sucursalModelo) {
        return sucursalPersistencePort.agregarSucursal(sucursalModelo);
    }

    @Override
    public Mono<SucursalModelo> actualizarFranquicia(SucursalModelo sucursalModelo) {
        return sucursalPersistencePort.buscarPorId(sucursalModelo.getId())
                .switchIfEmpty(Mono.error(new DomainException("No se encuentra sucursal")))
                .map(sucursal -> {
                    sucursal.setNombre(sucursalModelo.getNombre());
                    return sucursal;
                })
                .flatMap(sucursalPersistencePort::agregarSucursal);
    }
}