package com.example.franquicia.infrastructure.entrypoints.mapper;

import com.example.franquicia.domain.model.ProductoModelo;
import com.example.franquicia.infrastructure.entrypoints.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProductoMapper {

    ProductoModelo toModel(Long sucursalId, ProductoRequestDto productoRequestDto);
    @Mapping(source = "productoId", target = "id")
    ProductoModelo toModelStack(Long productoId, StockRequestDto stockRequestDto);
    @Mapping(source = "productoId", target = "id")
    ProductoModelo toModelNombre(Long productoId, ProductoNombreRequestDto productoNombreRequestDto);

}
