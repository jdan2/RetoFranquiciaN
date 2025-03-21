package com.example.franquicia.domain.api;

import com.example.franquicia.domain.model.FranquiciaModelo;
import reactor.core.publisher.Mono;

public interface IFranquiciaServicePort {

    Mono<FranquiciaModelo>  agregarFranquicia(FranquiciaModelo franquiciaModelo);
    Mono<FranquiciaModelo>  actualizarFranquicia(FranquiciaModelo franquiciaModelo);


}
