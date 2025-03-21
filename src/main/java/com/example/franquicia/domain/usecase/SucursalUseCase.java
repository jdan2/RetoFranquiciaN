package com.example.franquicia.domain.usecase;

import com.example.franquicia.domain.api.ISucursalServicePort;
import com.example.franquicia.domain.enums.TechnicalMessage;
import com.example.franquicia.domain.exceptions.BusinessException;
import com.example.franquicia.domain.model.SucursalModelo;
import com.example.franquicia.domain.spi.ISucursalPersistencePort;
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
    public Mono<SucursalModelo> actualizarSucursal(SucursalModelo sucursalModelo) {
        return sucursalPersistencePort.buscarPorId(sucursalModelo.getId())
                .switchIfEmpty(Mono.error(new BusinessException(TechnicalMessage.INVALID_SUCURSAL_ID)))
                .map(sucursal -> {
                    sucursal.setNombre(sucursalModelo.getNombre());
                    return sucursal;
                })
                .flatMap(sucursalPersistencePort::agregarSucursal);
    }

}
