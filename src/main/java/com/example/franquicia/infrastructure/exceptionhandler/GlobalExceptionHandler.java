package com.example.franquicia.infrastructure.exceptionhandler;

import com.example.franquicia.domain.exceptions.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Mono<ErrorResponse> handleBusinessException(BusinessException ex) {
        log.error("Error de negocio: {}", ex.getMessage());
        return Mono.just(new ErrorResponse("Error de negocio", ex.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(ResponseStatusException.class)
    public Mono<ErrorResponse> handleResponseStatusException(ResponseStatusException ex) {
        log.error("Error de estado HTTP: {}", ex.getMessage());
        return Mono.just(new ErrorResponse("Error HTTP", ex.getReason(), ex.getStatusCode().value()));
    }

    @ExceptionHandler(Exception.class)
    public Mono<ErrorResponse> handleGenericException(Exception ex) {
        log.error("Error inesperado: {}", ex.getMessage());
        return Mono.just(new ErrorResponse("Error interno", "Ocurrió un error inesperado", HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    // Clase para estructurar respuestas de error
    public record ErrorResponse(String error, String message, int status) {}
}
