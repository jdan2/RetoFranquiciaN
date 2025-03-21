package com.example.franquicia.domain.api;

import com.example.franquicia.domain.model.SucursalModelo;
import reactor.core.publisher.Mono;

public interface ISucursalServicePort {

    Mono<SucursalModelo>  agregarSucursal(SucursalModelo sucursalModelo);
    Mono<SucursalModelo>  actualizarSucursal(SucursalModelo franquiciaModelo);


}
