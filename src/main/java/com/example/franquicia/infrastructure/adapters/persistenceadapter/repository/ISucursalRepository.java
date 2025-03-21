package com.example.franquicia.infrastructure.adapters.persistenceadapter.repository;

import com.example.franquicia.infrastructure.adapters.persistenceadapter.entity.SucursalEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface ISucursalRepository extends ReactiveCrudRepository<SucursalEntity, Long> {
    Flux<SucursalEntity> findByFranquiciaId(Long franquiciaId);
}
