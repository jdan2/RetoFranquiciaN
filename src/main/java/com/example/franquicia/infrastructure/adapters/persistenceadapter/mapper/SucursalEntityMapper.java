package com.example.franquicia.infrastructure.adapters.persistenceadapter.mapper;

import com.example.franquicia.domain.model.SucursalModelo;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.entity.SucursalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface SucursalEntityMapper {

    SucursalModelo toModel(SucursalEntity sucursalEntity);

    SucursalEntity toEntity(SucursalModelo sucursalModelo);



}
