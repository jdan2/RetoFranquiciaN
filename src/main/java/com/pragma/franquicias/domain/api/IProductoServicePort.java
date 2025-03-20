package com.pragma.franquicias.domain.api;

import com.pragma.franquicias.domain.model.ProductoMaxStockModelo;
import com.pragma.franquicias.domain.model.ProductoModelo;
import com.pragma.franquicias.domain.model.SucursalModelo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductoServicePort {

    Mono<ProductoModelo>  agregarProducto(ProductoModelo productoModelo);
    Mono<Void>  eliminarProducto(Long productoId);
    Mono<ProductoModelo>  actualizarProducto(ProductoModelo productoModelo);
    Flux<ProductoMaxStockModelo> obtenerProductoMaxStockPorSucursal(Long franquiciaId);
    Mono<ProductoModelo>  actualizarNombreProducto(ProductoModelo productoModelo);


}