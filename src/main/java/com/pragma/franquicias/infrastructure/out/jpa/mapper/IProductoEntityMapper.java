package com.pragma.franquicias.infrastructure.out.jpa.mapper;

import com.pragma.franquicias.domain.model.FranquiciaModelo;
import com.pragma.franquicias.domain.model.ProductoModelo;
import com.pragma.franquicias.infrastructure.out.jpa.entity.FranquiciaEntity;
import com.pragma.franquicias.infrastructure.out.jpa.entity.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IProductoEntityMapper {

    ProductoEntity toEntity(ProductoModelo productoModelo);
    ProductoModelo toModel(ProductoEntity productoEntity);
}
