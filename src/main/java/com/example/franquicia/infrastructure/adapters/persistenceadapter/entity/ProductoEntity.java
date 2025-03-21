package com.example.franquicia.infrastructure.adapters.persistenceadapter.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "productos")
@Getter
@Setter
@RequiredArgsConstructor
public class ProductoEntity {

    @Id
    private Long id;

    private String nombre;

    private Integer stock;

    @Column("sucursal_id")
    private Long sucursalId;
}
