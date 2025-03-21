package com.example.franquicia.infrastructure.entrypoints;
import com.example.franquicia.infrastructure.entrypoints.handler.FranquiciaHandlerImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PATCH;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FranquiciaRouter {

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/franquicias",
                    produces = "application/json",
                    method = RequestMethod.POST,
                    beanMethod = "agregarFranquicia",
                    operation = @Operation(
                            summary = "Agregar una nueva franquicia",
                            description = "Crea una nueva franquicia con el nombre proporcionado",
                            responses = {
                                    @ApiResponse(responseCode = "201", description = "Franquicia creada exitosamente"),
                                    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
                                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
                            }
                    )
            ),
            @RouterOperation(
                    path = "/franquicias/{franquiciaId}",
                    produces = "application/json",
                    method = RequestMethod.PATCH,
                    beanMethod = "actualizarFranquicia",
                    operation = @Operation(
                            summary = "Modificar el nombre de una franquicia",
                            description = "Permite actualizar el nombre de una franquicia existente",
                            responses = {
                                    @ApiResponse(responseCode = "200", description = "Nombre actualizado correctamente"),
                                    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
                                    @ApiResponse(responseCode = "404", description = "Franquicia no encontrada"),
                                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
                            }
                    )
            )
    })
    public RouterFunction<ServerResponse> franquiciaRoutes(FranquiciaHandlerImpl franquiciaHandler) {
        return route(POST("/franquicias"), franquiciaHandler::agregarFranquicia)
                .andRoute(PATCH("/franquicias/{franquiciaId}"), franquiciaHandler::actualizarFranquicia);
    }
}
