package com.pragma.franquicias.domain.spi;

import com.pragma.franquicias.domain.model.FranquiciaModelo;
import com.pragma.franquicias.domain.model.ProductoModelo;
import reactor.core.publisher.Mono;

public interface IProductoPersistencePort {
    Mono<ProductoModelo> agregarProducto(ProductoModelo productoModelo);
}