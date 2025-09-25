package com.sameul.sistemarestauranteapi.categoriaproduto.enums;

public enum CategoriaProdutoStatus {
    ATIVO("ATIVO"),
    INATIVO("INATIVO");

    private String status;
    CategoriaProdutoStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}
