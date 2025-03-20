package com.pragma.franquicias.infrastructure.out.jpa.repository;


import com.pragma.franquicias.infrastructure.out.jpa.entity.SucursalEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ISucursalRepository extends ReactiveCrudRepository<SucursalEntity, Long> {
    Flux<SucursalEntity> findByFranquiciaId(Long franquiciaId);
}
