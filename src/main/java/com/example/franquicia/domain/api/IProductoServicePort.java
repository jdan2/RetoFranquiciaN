package com.example.franquicia.domain.api;

import com.example.franquicia.domain.model.ProductoMaxStockModelo;
import com.example.franquicia.domain.model.ProductoModelo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductoServicePort {

    Mono<ProductoModelo>  agregarProducto(ProductoModelo productoModelo);
    Mono<Void>  eliminarProducto(Long productoId);
    Mono<ProductoModelo>  actualizarProducto(ProductoModelo productoModelo);
    Flux<ProductoMaxStockModelo> obtenerProductoMaxStockPorSucursal(Long franquiciaId);
    Mono<ProductoModelo>  actualizarNombreProducto(ProductoModelo productoModelo);



}
