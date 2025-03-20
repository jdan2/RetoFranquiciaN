package com.pragma.franquicias.infrastructure.out.jpa.adapter;

import com.pragma.franquicias.domain.model.ProductoModelo;
import com.pragma.franquicias.domain.model.SucursalModelo;
import com.pragma.franquicias.domain.spi.IProductoPersistencePort;
import com.pragma.franquicias.domain.spi.ISucursalPersistencePort;
import com.pragma.franquicias.infrastructure.out.jpa.mapper.IProductoEntityMapper;
import com.pragma.franquicias.infrastructure.out.jpa.mapper.ISucursalEntityMapper;
import com.pragma.franquicias.infrastructure.out.jpa.repository.IProductoRepository;
import com.pragma.franquicias.infrastructure.out.jpa.repository.ISucursalRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class ProductoAdapter implements IProductoPersistencePort {

    private final IProductoRepository productoRepository;
    private final IProductoEntityMapper productoEntityMapper;

    @Override
    public Mono<ProductoModelo> agregarProducto(ProductoModelo productoModelo) {
        return Mono.just(productoEntityMapper.toEntity(productoModelo))
                .flatMap(productoRepository::save)
                .map(productoEntityMapper::toModel);
    }

    @Override
    public Mono<ProductoModelo> buscarProductoPorId(Long productoId) {
        return productoRepository.findById(productoId)
                .map(productoEntityMapper::toModel);
    }

    @Override
    public Mono<Void> eliminarProducto(Long productoId) {
        return productoRepository.deleteById(productoId);
    }
}