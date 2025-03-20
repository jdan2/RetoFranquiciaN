package com.pragma.franquicias.infrastructure.out.jpa.repository;

import com.pragma.franquicias.infrastructure.out.jpa.entity.FranquiciaEntity;
import com.pragma.franquicias.infrastructure.out.jpa.entity.SucursalEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISucursalRepository extends ReactiveCrudRepository<SucursalEntity, Long> {
}
