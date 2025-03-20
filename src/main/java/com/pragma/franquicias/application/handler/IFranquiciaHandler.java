package com.pragma.franquicias.application.handler;

import com.pragma.franquicias.application.dto.request.FranquiciaRequestDto;
import com.pragma.franquicias.application.dto.response.FranquiciaResponseDto;
import reactor.core.publisher.Mono;

public interface IFranquiciaHandler {

    Mono<FranquiciaResponseDto>  agregarFranquicia(FranquiciaRequestDto franquiciaRequestDto);

}