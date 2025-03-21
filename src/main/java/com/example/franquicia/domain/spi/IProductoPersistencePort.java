package com.example.franquicia.domain.spi;

import com.example.franquicia.domain.model.ProductoModelo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductoPersistencePort {

    Mono<ProductoModelo> agregarProducto(ProductoModelo productoModelo);
    Mono<ProductoModelo> buscarProductoPorId(Long productoId);
    Mono<Void> eliminarProducto(Long productoId);
    Flux<ProductoModelo> buscarPorSucursalId(Long sucursalId);
}
