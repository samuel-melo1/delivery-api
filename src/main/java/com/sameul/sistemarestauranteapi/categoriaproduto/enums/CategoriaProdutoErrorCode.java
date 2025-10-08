package com.sameul.sistemarestauranteapi.categoriaproduto.enums;

import com.sameul.sistemarestauranteapi.utils.IErrorCodeGlobal;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public enum CategoriaProdutoErrorCode implements IErrorCodeGlobal {

    CATEGORIA_PRODUTO_JA_EXISTE("CTPDT-001", "Categoria do produto já existe. É necessário a criação de outra!", CONFLICT),
    CATEGORIA_PRODUTO_NAO_ENCONTRADA("CTPDT-002","Categoria do Produto inválida ou não encontrada!", NOT_FOUND);

    private final String code;
    private final String message;
    private final HttpStatus status;

    CategoriaProdutoErrorCode(String code, String message, HttpStatus status) {
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