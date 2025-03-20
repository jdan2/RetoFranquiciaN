package com.pragma.franquicias.domain.api;

import com.pragma.franquicias.domain.model.FranquiciaModelo;
import reactor.core.publisher.Mono;

public interface IFranquiciaServicePort {

    Mono<FranquiciaModelo>  agregarFranquicia(FranquiciaModelo franquiciaModelo);

}