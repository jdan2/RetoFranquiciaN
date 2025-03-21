package com.example.franquicia.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoModelo {

    private Long id;
    private String nombre;
    private Integer stock;
    private Long sucursalId;
}
