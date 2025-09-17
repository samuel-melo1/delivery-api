package com.sameul.sistemarestauranteapi.restaurante.enums;

import com.sameul.sistemarestauranteapi.utils.IErrorCodeGlobal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;


public enum RestauranteErrorCode implements IErrorCodeGlobal {

    RESTAURANTE_JA_EXISTENTE("RST001", "Restaurante já existe. É necessário a criação de outro!", CONFLICT),
    RESTAURANTE_NAO_ENCONTRADO("RST002","Restaurante inválido ou não encontrado!", NOT_FOUND);

    private final String code;
    private final String message;
    private final HttpStatus status;
    @Override
    public String getMessage() {
        return message;
    }
    @Override
    public HttpStatus getStatus() {
        return status;
    }

    RestauranteErrorCode(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
