package com.example.franquicia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoMaxStockModelo {

    private Long id;
    private String nombre;
    private Integer stock;
    private Long sucursalId;
}
