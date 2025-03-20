package com.pragma.franquicias.domain.usecase;

import com.pragma.franquicias.domain.api.IProductoServicePort;
import com.pragma.franquicias.domain.api.ISucursalServicePort;
import com.pragma.franquicias.domain.exception.DomainException;
import com.pragma.franquicias.domain.model.ProductoMaxStockModelo;
import com.pragma.franquicias.domain.model.ProductoModelo;
import com.pragma.franquicias.domain.model.SucursalModelo;
import com.pragma.franquicias.domain.spi.IProductoPersistencePort;
import com.pragma.franquicias.domain.spi.ISucursalPersistencePort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

public class ProductoUseCase implements IProductoServicePort {

    public static final String PRODUCTO_NO_ENCONTRADO = "Producto no encontrado";
    private final IProductoPersistencePort productoPersistencePort;
    private final ISucursalPersistencePort sucursalPersistencePort;

    public ProductoUseCase(IProductoPersistencePort productoPersistencePort, ISucursalPersistencePort sucursalPersistencePort) {
        this.productoPersistencePort = productoPersistencePort;
        this.sucursalPersistencePort = sucursalPersistencePort;
    }

    @Override
    public Mono<ProductoModelo> agregarProducto(ProductoModelo productoModelo) {
        return productoPersistencePort.agregarProducto(productoModelo);
    }

    @Override
    public Mono<ProductoModelo> actualizarProducto(ProductoModelo productoModelo) {
        return productoPersistencePort.buscarProductoPorId(productoModelo.getId())
                .switchIfEmpty(Mono.error(new DomainException(PRODUCTO_NO_ENCONTRADO)))

                .map(producto -> {
                    producto.setStock(productoModelo.getStock());
                    return producto;
                })
                .flatMap(productoPersistencePort::agregarProducto);


    }

    @Override
    public Flux<ProductoMaxStockModelo> obtenerProductoMaxStockPorSucursal(Long franquiciaId) {
        return sucursalPersistencePort.buscarPorFranquiciaId(franquiciaId)
                .flatMap(sucursalModelo -> productoPersistencePort.buscarPorSucursalId(sucursalModelo.getId())
                        .collectList()
                        .filter(productoModelos -> !productoModelos.isEmpty())
                        .map(productoModelos -> productoModelos.stream()
                                .max(Comparator.comparingInt(ProductoModelo::getStock))
                                .orElseThrow())
                        .map(productoMax -> new ProductoMaxStockModelo(
                                productoMax.getId(),
                                productoMax.getNombre(),
                                productoMax.getStock(),
                                sucursalModelo.getId()
                        )));
    }

    @Override
    public Mono<Void> eliminarProducto(Long productoId) {
        return productoPersistencePort.buscarProductoPorId(productoId)
                .switchIfEmpty(Mono.error(new DomainException(PRODUCTO_NO_ENCONTRADO)))
                .flatMap(producto -> productoPersistencePort.eliminarProducto(producto.getId()))
                .then(Mono.empty());
    }
}