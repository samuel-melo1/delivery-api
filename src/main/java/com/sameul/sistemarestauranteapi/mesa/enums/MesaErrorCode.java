package com.sameul.sistemarestauranteapi.mesa.enums;

import com.sameul.sistemarestauranteapi.utils.IErrorCodeGlobal;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public enum MesaErrorCode implements IErrorCodeGlobal {

    MESA_JA_EXISTE("MESA-001", "Mesa já existe. É necessário a criação de outra!", CONFLICT),
    MESA_NAO_ENCONTRADA("MESA-002","Mesa inválida ou não encontrada!", NOT_FOUND);

    private final String code;
    private final String message;
    private final HttpStatus status;

    MesaErrorCode(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public HttpStatus getStatus() {
        return this.status;
    }
}
