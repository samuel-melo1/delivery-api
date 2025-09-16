package com.sameul.sistemarestauranteapi.produto.controller.request;

import jakarta.validation.constraints.NotBlank;

public class ProdutoRequest {

    @NotBlank(message = "É necessário informar o nome do produto")
    private String descricao;
    @NotBlank(message = "É necessário informar o preço do produto")
    private Float preco;

    public String getDescricao() {
        return descricao;
    }
    public Float getPreco() {
        return preco;
    }
}
