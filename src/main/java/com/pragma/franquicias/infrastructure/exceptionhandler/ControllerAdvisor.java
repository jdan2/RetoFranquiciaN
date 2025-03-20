package com.pragma.franquicias.infrastructure.exceptionhandler;

import com.pragma.franquicias.domain.exception.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "message";
    public static final String DUPLICATE_ENTRY = "Duplicate entry";
    public static final String DUPLICATE = "Ya existe un registro con el valor duplicado: ";
    public static final String ERROR_DATA_BASE = "Error en la base de datos: ";

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ExceptionResponse> handleDomainException(DomainException ex) {
        ExceptionResponse errorResponse = new ExceptionResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, String> error = new HashMap<>();
        error.put(MESSAGE, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {

        Map<String, String> error = new HashMap<>();
        String originalMessage = ex.getMessage();

        if (originalMessage.contains(DUPLICATE_ENTRY)) {
            error.put(MESSAGE, DUPLICATE + extractDuplicateValue(originalMessage));
        } else {
            error.put(MESSAGE, ERROR_DATA_BASE + originalMessage);
        }
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    private String extractDuplicateValue(String originalMessage) {
        int startIndex = originalMessage.indexOf("'") + 1;
        int endIndex = originalMessage.indexOf("'", startIndex);
        return originalMessage.substring(startIndex, endIndex);
    }
    
}