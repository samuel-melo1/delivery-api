package com.sameul.sistemarestauranteapi.categoriaproduto.dto.response;

import com.sameul.sistemarestauranteapi.categoriaproduto.enums.CategoriaProdutoStatus;

import java.io.Serializable;

public class CategoriaProdutoResponse implements Serializable {

    private Integer id;
    private CategoriaProdutoStatus status;
    private String descricao;
    public void setId(Integer id) {
        this.id = id;
    }
    public void setStatus(CategoriaProdutoStatus status) {
        this.status = status;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
