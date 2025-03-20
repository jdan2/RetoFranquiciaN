package com.pragma.franquicias.domain.usecase;

import com.pragma.franquicias.domain.api.IProductoServicePort;
import com.pragma.franquicias.domain.api.ISucursalServicePort;
import com.pragma.franquicias.domain.exception.DomainException;
import com.pragma.franquicias.domain.model.ProductoModelo;
import com.pragma.franquicias.domain.model.SucursalModelo;
import com.pragma.franquicias.domain.spi.IProductoPersistencePort;
import com.pragma.franquicias.domain.spi.ISucursalPersistencePort;
import reactor.core.publisher.Mono;

public class ProductoUseCase implements IProductoServicePort {

    public static final String PRODUCTO_NO_ENCONTRADO = "Producto no encontrado";
    private final IProductoPersistencePort productoPersistencePort;

    public ProductoUseCase(IProductoPersistencePort productoPersistencePort) {
        this.productoPersistencePort = productoPersistencePort;
    }

    @Override
    public Mono<ProductoModelo> agregarProducto(ProductoModelo productoModelo) {
        return productoPersistencePort.agregarProducto(productoModelo);
    }

    @Override
    public Mono<Void> eliminarProducto(Long productoId) {
        return productoPersistencePort.buscarProductoPorId(productoId)
                .switchIfEmpty(Mono.error(new DomainException(PRODUCTO_NO_ENCONTRADO)))
                .flatMap(producto -> productoPersistencePort.eliminarProducto(producto.getId()))
                .then(Mono.empty());
    }
}