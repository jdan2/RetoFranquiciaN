package com.pragma.franquicias.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductoMaxStockResponseDto {

    private Long id;
    private String nombre;
    private Integer stock;
    private Long sucursalId;
}
