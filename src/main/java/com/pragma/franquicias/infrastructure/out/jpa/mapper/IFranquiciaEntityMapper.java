package com.pragma.franquicias.infrastructure.out.jpa.mapper;

import com.pragma.franquicias.domain.model.FranquiciaModelo;
import com.pragma.franquicias.infrastructure.out.jpa.entity.FranquiciaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import reactor.core.publisher.Mono;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IFranquiciaEntityMapper {

    FranquiciaEntity toEntity(FranquiciaModelo franquiciaModelo);
    FranquiciaModelo toModel(FranquiciaEntity franquiciaEntity);
}
