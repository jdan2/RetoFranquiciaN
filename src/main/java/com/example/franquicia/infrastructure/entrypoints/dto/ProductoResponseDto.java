package com.example.franquicia.infrastructure.entrypoints.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoResponseDto {

    private Long id;
    private String nombre;
    private Integer stock;
    private Long sucursalId;
}
