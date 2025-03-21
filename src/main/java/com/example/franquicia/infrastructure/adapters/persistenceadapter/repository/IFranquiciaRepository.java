package com.example.franquicia.infrastructure.adapters.persistenceadapter.repository;

import com.example.franquicia.infrastructure.adapters.persistenceadapter.entity.FranquiciaEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IFranquiciaRepository extends ReactiveCrudRepository<FranquiciaEntity, Long> {
}
