package com.sameul.sistemarestauranteapi.restaurante.enums;

import com.sameul.sistemarestauranteapi.utils.IErrorCodeGlobal;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@AllArgsConstructor
public enum RestauranteErrorCode implements IErrorCodeGlobal {

    RESTAURANTE_JA_EXISTENTE("RST-001", "Restaurante já existe. É necessário a criação de outro!", CONFLICT),
    RESTAURANTE_NAO_ENCONTRADO("RST-002","Restaurante inválido ou não encontrado!", NOT_FOUND);

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

}
