package com.sameul.sistemarestauranteapi.produto.enums;

public enum ProdutoStatus {

    ATIVO("ATIVO"),
    INATIVO("INATIVO");

    private String status;
    ProdutoStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}
