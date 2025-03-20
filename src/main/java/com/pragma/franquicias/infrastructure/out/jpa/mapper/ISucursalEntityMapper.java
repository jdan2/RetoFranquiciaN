package com.pragma.franquicias.infrastructure.out.jpa.mapper;

import com.pragma.franquicias.domain.model.FranquiciaModelo;
import com.pragma.franquicias.domain.model.SucursalModelo;
import com.pragma.franquicias.infrastructure.out.jpa.entity.FranquiciaEntity;
import com.pragma.franquicias.infrastructure.out.jpa.entity.SucursalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ISucursalEntityMapper {

    SucursalEntity toEntity(SucursalModelo sucursalModelo);
    SucursalModelo toModel(SucursalEntity sucursalEntity);
}
