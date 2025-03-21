package com.example.franquicia.infrastructure.entrypoints.handler;

import com.example.franquicia.domain.api.ISucursalServicePort;
import com.example.franquicia.infrastructure.entrypoints.dto.SucursalNombreRequestDto;
import com.example.franquicia.infrastructure.entrypoints.dto.SucursalRequestDto;
import com.example.franquicia.infrastructure.entrypoints.mapper.SucursalMapper;
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
public class SucursalHandlerImpl {

    private final ISucursalServicePort sucursalServicePort;
    private final SucursalMapper sucursalMapper;

    public Mono<ServerResponse> agregarSucursal(ServerRequest request) {
        Long franquiciaId = Long.parseLong(request.pathVariable("franquiciaId"));

        return request.bodyToMono(SucursalRequestDto.class)
                .flatMap(dto -> sucursalServicePort.agregarSucursal(sucursalMapper.sucursalDTOToFranquicia(franquiciaId, dto)))
                .flatMap(response -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(response));
    }

    public Mono<ServerResponse> actualizarSucursal(ServerRequest request) {
        Long sucursalId = Long.parseLong(request.pathVariable("sucursalId"));

        return request.bodyToMono(SucursalNombreRequestDto.class)
                .flatMap(dto -> sucursalServicePort.actualizarSucursal(sucursalMapper.sucursalUpdateDTOToFranquicia(sucursalId, dto) ))
                .flatMap(response -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(response));
    }


}
