package com.pragma.franquicias.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table(name = "productos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductoEntity {

    @Id
    private Long id;

    private String nombre;
    private Integer stock;

    @Column("sucursal_id")
    private Long sucursalId;
}
