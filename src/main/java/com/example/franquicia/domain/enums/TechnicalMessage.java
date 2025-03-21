package com.example.franquicia.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TechnicalMessage {

    INVALID_PRODUCT_ID("404", "Invalid Product ID, please verify", "messageId"),
    INVALID_FRANCHIES_ID("404", "Invalid FRANCHIES ID, please verify", "messageId"),
    INVALID_SUCURSAL_ID("404", "Invalid Sucursal ID, please verify", "messageId");

    private final String code;
    private final String message;
    private final String param;
}