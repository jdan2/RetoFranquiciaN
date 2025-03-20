package com.pragma.franquicias.domain.spi;

import com.pragma.franquicias.domain.model.ProductoModelo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductoPersistencePort {
    Mono<ProductoModelo> agregarProducto(ProductoModelo productoModelo);
    Mono<ProductoModelo> buscarProductoPorId(Long productoId);
    Mono<Void> eliminarProducto(Long productoId);
    Flux<ProductoModelo> buscarPorSucursalId(Long sucursalId);
}