package com.sameul.sistemarestauranteapi.categoriaproduto.dto.request;

import jakarta.validation.constraints.NotBlank;
public class CategoriaProdutoRequest  {
    @NotBlank(message = "É necessário informar a descrição da categoria do produto")
    private String descricao;
    public String getDescricao() {
        return descricao;
    }

}
