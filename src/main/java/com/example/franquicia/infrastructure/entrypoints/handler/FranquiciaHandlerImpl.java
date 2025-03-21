package com.example.franquicia.infrastructure.entrypoints.handler;

import com.example.franquicia.domain.api.IFranquiciaServicePort;
import com.example.franquicia.infrastructure.entrypoints.dto.FranquiciaRequestDto;
import com.example.franquicia.infrastructure.entrypoints.dto.FranquiciaUpdateRequestDto;
import com.example.franquicia.infrastructure.entrypoints.mapper.FranquiciaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class FranquiciaHandlerImpl {

    private final IFranquiciaServicePort franquiciaServicePort;
    private final FranquiciaMapper franquiciaMapper;

    public Mono<ServerResponse> agregarFranquicia(ServerRequest request) {
        return request.bodyToMono(FranquiciaRequestDto.class)
                .flatMap(dto -> franquiciaServicePort.agregarFranquicia(franquiciaMapper.franquiciaDTOToFranquicia(dto))
                )
                .flatMap(response -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(response));
    }

    public Mono<ServerResponse> actualizarFranquicia(ServerRequest request) {
        Long franquiciaId = Long.parseLong(request.pathVariable("franquiciaId"));

        return request.bodyToMono(FranquiciaUpdateRequestDto.class)
                .flatMap(dto -> franquiciaServicePort.actualizarFranquicia(franquiciaMapper.franquiciaUpdateDTOToFranquicia(franquiciaId, dto) ))
                .flatMap(response -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(response));
    }

}
