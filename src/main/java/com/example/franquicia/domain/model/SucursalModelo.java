package com.example.franquicia.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SucursalModelo {

    private Long id;
    private String nombre;
    private Long franquiciaId;
}
