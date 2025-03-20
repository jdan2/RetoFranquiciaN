package com.pragma.franquicias.infrastructure.out.jpa.repository;

import com.pragma.franquicias.infrastructure.out.jpa.entity.FranquiciaEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFranquiciaRepository extends ReactiveCrudRepository<FranquiciaEntity, Long> {
}