package com.example.franquicia.infrastructure.entrypoints;

import com.example.franquicia.infrastructure.entrypoints.handler.SucursalHandlerImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PATCH;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SucursalRouter {

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/sucursales/{franquiciaId}",
                    produces = "application/json",
                    method = org.springframework.web.bind.annotation.RequestMethod.POST,
                    beanMethod = "agregarSucursal",
                    operation = @Operation(
                            summary = "Agregar una nueva sucursal",
                            description = "Crea una nueva sucursal dentro de una franquicia",
                            responses = {
                                    @ApiResponse(responseCode = "201", description = "Sucursal creada exitosamente"),
                                    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
                                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
                            }
                    )
            ),
            @RouterOperation(
                    path = "/sucursales/{sucursalId}",
                    produces = "application/json",
                    method = org.springframework.web.bind.annotation.RequestMethod.PATCH,
                    beanMethod = "actualizarSucursal",
                    operation = @Operation(
                            summary = "Modificar nombre de una sucursal",
                            description = "Permite actualizar el nombre de una sucursal existente",
                            responses = {
                                    @ApiResponse(responseCode = "200", description = "Nombre actualizado correctamente"),
                                    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
                                    @ApiResponse(responseCode = "404", description = "Sucursal no encontrada"),
                                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
                            }
                    )
            )
    })
    public RouterFunction<ServerResponse> sucursalRoutes(SucursalHandlerImpl sucursalHandler) {
        return route(POST("/sucursales/{franquiciaId}"), sucursalHandler::agregarSucursal)
                .andRoute(PATCH("/sucursales/{sucursalId}"), sucursalHandler::actualizarSucursal);
    }
}
