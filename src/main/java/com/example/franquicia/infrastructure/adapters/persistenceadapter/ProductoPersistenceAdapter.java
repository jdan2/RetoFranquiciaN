package com.example.franquicia.infrastructure.adapters.persistenceadapter;

import com.example.franquicia.domain.model.ProductoModelo;
import com.example.franquicia.domain.spi.IProductoPersistencePort;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.mapper.ProductoEntityMapper;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.repository.IProductoRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class ProductoPersistenceAdapter implements IProductoPersistencePort {

    private final IProductoRepository productoRepository;
    private final ProductoEntityMapper productoEntityMapper;

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

    @Override
    public Flux<ProductoModelo> buscarPorSucursalId(Long sucursalId) {
        return productoRepository.findBySucursalId(sucursalId)
                .map(productoEntityMapper::toModel);
    }
}
