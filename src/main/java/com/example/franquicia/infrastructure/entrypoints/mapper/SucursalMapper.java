package com.example.franquicia.infrastructure.entrypoints.mapper;

import com.example.franquicia.domain.model.SucursalModelo;
import com.example.franquicia.infrastructure.entrypoints.dto.SucursalNombreRequestDto;
import com.example.franquicia.infrastructure.entrypoints.dto.SucursalRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface SucursalMapper {

    @Mapping(source = "id", target = "id")
    SucursalModelo sucursalUpdateDTOToFranquicia(Long id, SucursalNombreRequestDto sucursalNombreRequestDto);
    SucursalModelo sucursalDTOToFranquicia(Long franquiciaId, SucursalRequestDto sucursalRequestDto);




}
