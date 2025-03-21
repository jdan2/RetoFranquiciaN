package com.example.franquicia.infrastructure.entrypoints;

import com.example.franquicia.infrastructure.entrypoints.handler.ProductoHandlerImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProductoRouter {

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/producto/{sucursalId}",
                    produces = "application/json",
                    method = RequestMethod.POST,
                    beanMethod = "agregarProducto",
                    operation = @Operation(
                            summary = "Agregar un nuevo producto",
                            description = "Crea un nuevo producto para una sucursal",
                            responses = {
                                    @ApiResponse(responseCode = "201", description = "Producto creado exitosamente"),
                                    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
                                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
                            }
                    )
            ),
            @RouterOperation(
                    path = "/producto/{productoId}",
                    produces = "application/json",
                    method = RequestMethod.DELETE,
                    beanMethod = "eliminarProducto",
                    operation = @Operation(
                            summary = "Eliminar un producto",
                            description = "Elimina un producto utilizando su ID",
                            responses = {
                                    @ApiResponse(responseCode = "204", description = "Producto eliminado exitosamente"),
                                    @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
                                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
                            }
                    )
            ),
            @RouterOperation(
                    path = "/producto/{productoId}",
                    produces = "application/json",
                    method = RequestMethod.PATCH,
                    beanMethod = "actualizarStock",
                    operation = @Operation(
                            summary = "Modificar stock de un producto",
                            description = "Permite actualizar la cantidad de stock de un producto existente",
                            responses = {
                                    @ApiResponse(responseCode = "200", description = "Stock actualizado correctamente"),
                                    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
                                    @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
                                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
                            }
                    )
            ),
            @RouterOperation(
                    path = "/producto/nombre/{productoId}",
                    produces = "application/json",
                    method = RequestMethod.PATCH,
                    beanMethod = "actualizarNombre",
                    operation = @Operation(
                            summary = "Modificar nombre de un producto",
                            description = "Permite actualizar el nombre de un producto existente",
                            responses = {
                                    @ApiResponse(responseCode = "200", description = "Nombre actualizado correctamente"),
                                    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
                                    @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
                                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
                            }
                    )
            )
    })
    public RouterFunction<ServerResponse> productoRoutes(ProductoHandlerImpl productoHandler) {
        return route(POST("/producto/{sucursalId}"), productoHandler::agregarProducto)
               .andRoute(DELETE("/producto/{productoId}"), productoHandler::eliminarProducto)
                .andRoute(GET("/producto/maxStock/{franquiciaId}"), productoHandler::maxProducto)
                .andRoute(PATCH("/producto/{productoId}"), productoHandler::actualizarStock)
                .andRoute(PATCH("/producto/nombre/{productoId}"), productoHandler::actualizarNombre);
    }
}
