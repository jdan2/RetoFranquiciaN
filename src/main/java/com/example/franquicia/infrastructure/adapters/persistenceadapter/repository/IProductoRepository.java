package com.example.franquicia.infrastructure.adapters.persistenceadapter.repository;

import com.example.franquicia.infrastructure.adapters.persistenceadapter.entity.ProductoEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface IProductoRepository extends ReactiveCrudRepository<ProductoEntity, Long> {
    Flux<ProductoEntity> findBySucursalId (Long sucursalId);
}
