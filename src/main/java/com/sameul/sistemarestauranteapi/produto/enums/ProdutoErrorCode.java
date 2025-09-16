package com.sameul.sistemarestauranteapi.produto.enums;

import com.sameul.sistemarestauranteapi.utils.IErrorCodeGlobal;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public enum ProdutoErrorCode implements IErrorCodeGlobal {

    PRODUTO_JA_EXISTENTE("PRD-001", "Produto já existe. É necessário a criação de outro!", CONFLICT),
    PRODUTO_NAO_ENCONTRADO("PRD-002","Produto inválido ou não encontrado!", NOT_FOUND);

    private final String code;
    private final String message;
    private final HttpStatus status;

    ProdutoErrorCode(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public HttpStatus getStatus() {
        return null;
    }
}
