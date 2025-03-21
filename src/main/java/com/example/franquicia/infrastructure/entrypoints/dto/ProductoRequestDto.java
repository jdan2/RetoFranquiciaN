package com.example.franquicia.infrastructure.entrypoints.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequestDto {

    private String nombre;
    private Integer stock;

}
