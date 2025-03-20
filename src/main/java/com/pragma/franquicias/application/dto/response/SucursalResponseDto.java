package com.pragma.franquicias.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SucursalResponseDto {

    private Long id;
    private String nombre;
    private Long franquiciaId;
}
