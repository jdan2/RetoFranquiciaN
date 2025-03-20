package com.pragma.franquicias.infrastructure.out.jpa.repository;

import com.pragma.franquicias.infrastructure.out.jpa.entity.FranquiciaEntity;
import com.pragma.franquicias.infrastructure.out.jpa.entity.ProductoEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends ReactiveCrudRepository<ProductoEntity, Long> {
}
