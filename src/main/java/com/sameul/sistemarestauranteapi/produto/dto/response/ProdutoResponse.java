package com.sameul.sistemarestauranteapi.produto.dto.response;


public class ProdutoResponse {

    private Integer id;
    private String descricao;
    private Float preco;

    public ProdutoResponse(){}
    public ProdutoResponse(String descricao, Float preco) {
        this.descricao = descricao;
        this.preco = preco;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Float getPreco() {
        return preco;
    }
    public void setPreco(Float preco) {
        this.preco = preco;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
