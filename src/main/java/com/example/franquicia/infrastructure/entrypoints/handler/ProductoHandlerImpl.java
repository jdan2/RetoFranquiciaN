package com.example.franquicia.infrastructure.entrypoints.handler;

import com.example.franquicia.domain.api.IProductoServicePort;
import com.example.franquicia.domain.model.ProductoMaxStockModelo;
import com.example.franquicia.infrastructure.entrypoints.dto.*;
import com.example.franquicia.infrastructure.entrypoints.mapper.ProductoMapper;
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
public class ProductoHandlerImpl {
    public static final String PRODUCTO_ID = "productoId";
    public static final String FRANQUICIA_ID = "franquiciaId";
    public static final String SUCURSAL_ID = "sucursalId";
    public static final String PRODUCTO_ELIMINADO = "Producto Eliminado";
    private final IProductoServicePort productoServicePort;
    private final ProductoMapper productoMapper;

    public Mono<ServerResponse> agregarProducto(ServerRequest request) {
        Long sucursalId = Long.parseLong(request.pathVariable(SUCURSAL_ID));

        return request.bodyToMono(ProductoRequestDto.class)
                .flatMap(dto -> productoServicePort.agregarProducto(productoMapper.toModel(sucursalId, dto))
                )
                .flatMap(response -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(response));
    }


    public Mono<ServerResponse> maxProducto(ServerRequest request) {
        Long franquiciaId = Long.parseLong(request.pathVariable(FRANQUICIA_ID));

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productoServicePort.obtenerProductoMaxStockPorSucursal(franquiciaId), ProductoMaxStockModelo.class);
    }

    public Mono<ServerResponse> actualizarStock(ServerRequest request) {
        Long productoId = Long.parseLong(request.pathVariable(PRODUCTO_ID));

        return request.bodyToMono(StockRequestDto.class)
                .flatMap(dto -> productoServicePort.actualizarProducto(productoMapper.toModelStack(productoId, dto)))
                .flatMap(response -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(response));
    }

    public Mono<ServerResponse> actualizarNombre(ServerRequest request) {

        Long productoId = Long.parseLong(request.pathVariable(PRODUCTO_ID));

        return request.bodyToMono(ProductoNombreRequestDto.class)
                .flatMap(dto -> productoServicePort.actualizarNombreProducto(productoMapper.toModelNombre(productoId, dto))
                )
                .flatMap(response -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(response));
    }

    public Mono<ServerResponse> eliminarProducto(ServerRequest request) {
        Long productoId = Long.parseLong(request.pathVariable(PRODUCTO_ID));

        return  productoServicePort.eliminarProducto(productoId)
                .flatMap(response -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(PRODUCTO_ELIMINADO));
    }


}
