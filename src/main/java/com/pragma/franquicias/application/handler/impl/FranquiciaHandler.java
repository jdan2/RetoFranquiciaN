package com.pragma.franquicias.application.handler.impl;

import com.pragma.franquicias.application.dto.request.FranquiciaRequestDto;
import com.pragma.franquicias.application.dto.response.FranquiciaResponseDto;
import com.pragma.franquicias.application.handler.IFranquiciaHandler;
import com.pragma.franquicias.application.mapper.IFranquiciaMapper;
import com.pragma.franquicias.domain.api.IFranquiciaServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional
public class FranquiciaHandler implements IFranquiciaHandler {

    private final IFranquiciaServicePort franquiciaServicePort;
    private final IFranquiciaMapper franquiciaMapper;

    @Override
    public Mono<FranquiciaResponseDto> agregarFranquicia(FranquiciaRequestDto franquiciaRequestDto) {

        return   Mono.just(franquiciaMapper.toModel(franquiciaRequestDto))
                .flatMap(franquiciaServicePort::agregarFranquicia)
                .map(franquiciaMapper::toFranquiciaResponse);
    }
}