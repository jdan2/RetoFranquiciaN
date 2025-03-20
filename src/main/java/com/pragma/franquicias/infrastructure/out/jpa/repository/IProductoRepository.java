package com.pragma.franquicias.infrastructure.out.jpa.repository;

import com.pragma.franquicias.infrastructure.out.jpa.entity.ProductoEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface IProductoRepository extends ReactiveCrudRepository<ProductoEntity, Long> {
    Flux<ProductoEntity> findBySucursalId (Long sucursalId);
}
