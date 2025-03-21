package com.example.franquicia.infrastructure.adapters.persistenceadapter.mapper;

import com.example.franquicia.domain.model.FranquiciaModelo;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.entity.FranquiciaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface FranquiciaEntityMapper {


    FranquiciaModelo toModel(FranquiciaEntity franquiciaEntity);

    FranquiciaEntity toEntity(FranquiciaModelo franquiciaModelo);

}
