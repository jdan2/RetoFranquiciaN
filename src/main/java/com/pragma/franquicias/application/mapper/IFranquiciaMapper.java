package com.pragma.franquicias.application.mapper;

import com.pragma.franquicias.application.dto.request.FranquiciaRequestDto;
import com.pragma.franquicias.application.dto.request.FranquiciaUpdateRequestDto;
import com.pragma.franquicias.application.dto.response.FranquiciaResponseDto;
import com.pragma.franquicias.domain.model.FranquiciaModelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import reactor.core.publisher.Mono;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IFranquiciaMapper {


    FranquiciaModelo toModel (FranquiciaRequestDto franquiciaRequestDto);
    FranquiciaResponseDto  toFranquiciaResponse(FranquiciaModelo franquiciaModelo);
    @Mapping(source = "franquiciaId", target = "id")
    FranquiciaModelo toUpdateModel (Long franquiciaId, FranquiciaUpdateRequestDto franquiciaUpdateRequestDto);
}
