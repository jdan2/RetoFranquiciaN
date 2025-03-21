package com.example.franquicia.infrastructure.adapters.persistenceadapter.mapper;

import com.example.franquicia.domain.model.ProductoModelo;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.entity.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ProductoEntityMapper {


    ProductoEntity toEntity(ProductoModelo productoModelo);

    ProductoModelo toModel(ProductoEntity productoEntity);

}
