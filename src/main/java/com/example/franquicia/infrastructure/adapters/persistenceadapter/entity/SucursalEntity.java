package com.example.franquicia.infrastructure.adapters.persistenceadapter.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "sucursales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SucursalEntity {

    @Id
    private Long id;

    private String nombre;

    @Column("franquicia_id")
    private Long franquiciaId;
}
