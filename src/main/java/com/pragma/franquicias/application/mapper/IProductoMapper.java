package com.pragma.franquicias.application.mapper;

import com.pragma.franquicias.application.dto.request.ProductoRequestDto;
import com.pragma.franquicias.application.dto.request.SucursalRequestDto;
import com.pragma.franquicias.application.dto.response.ProductoResponseDto;
import com.pragma.franquicias.application.dto.response.SucursalResponseDto;
import com.pragma.franquicias.domain.model.ProductoModelo;
import com.pragma.franquicias.domain.model.SucursalModelo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IProductoMapper {


    ProductoModelo toModel (Long sucursalId, ProductoRequestDto productoRequestDto);
    ProductoResponseDto toResponse(ProductoModelo productoModelo);
}
