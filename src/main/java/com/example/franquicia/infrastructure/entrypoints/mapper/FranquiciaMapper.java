package com.example.franquicia.infrastructure.entrypoints.mapper;


import com.example.franquicia.domain.model.FranquiciaModelo;
import com.example.franquicia.infrastructure.entrypoints.dto.FranquiciaRequestDto;
import com.example.franquicia.infrastructure.entrypoints.dto.FranquiciaUpdateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface FranquiciaMapper {

    FranquiciaModelo franquiciaDTOToFranquicia(FranquiciaRequestDto franquiciaRequestDto);
    @Mapping(source = "id", target = "id")
    FranquiciaModelo franquiciaUpdateDTOToFranquicia(Long id, FranquiciaUpdateRequestDto franquiciaUpdateRequestDto);

}
