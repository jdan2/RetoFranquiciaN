package com.pragma.franquicias.application.handler.impl;

import com.pragma.franquicias.application.dto.request.ProductoRequestDto;
import com.pragma.franquicias.application.dto.request.SucursalRequestDto;
import com.pragma.franquicias.application.dto.response.ProductoResponseDto;
import com.pragma.franquicias.application.dto.response.SucursalResponseDto;
import com.pragma.franquicias.application.handler.IProductoHandler;
import com.pragma.franquicias.application.handler.ISucursalHandler;
import com.pragma.franquicias.application.mapper.IProductoMapper;
import com.pragma.franquicias.application.mapper.ISucursalMapper;
import com.pragma.franquicias.domain.api.IProductoServicePort;
import com.pragma.franquicias.domain.api.ISucursalServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductoHandler implements IProductoHandler {

    private final IProductoServicePort productoServicePort;
    private final IProductoMapper productoMapper;


    @Override
    public Mono<ProductoResponseDto> agregarProducto(Long sucursalId, ProductoRequestDto productoRequestDto) {
        return Mono.just(productoMapper.toModel(sucursalId, productoRequestDto))
                .flatMap(productoServicePort::agregarProducto)
                .map(productoMapper::toResponse);
    }
}