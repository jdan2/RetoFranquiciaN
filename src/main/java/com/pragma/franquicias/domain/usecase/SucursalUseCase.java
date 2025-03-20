package com.pragma.franquicias.domain.usecase;

import com.pragma.franquicias.domain.api.IFranquiciaServicePort;
import com.pragma.franquicias.domain.api.ISucursalServicePort;
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
}