package com.sameul.sistemarestauranteapi.produto.dto.request;


import com.sameul.sistemarestauranteapi.categoriaproduto.entity.CategoriaProduto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.mapstruct.Builder;

public class ProdutoRequest {

    @NotBlank(message = "É necessário informar o nome do produto")
    private String descricao;
    @NotNull(message = "É necessário informar o preço do produto")
    private Float preco;
    @NotNull(message = "É necessário informar a categoria do produto")
    private Integer categoriaId;
    public Integer getCategoriaId() {
        return categoriaId;
    }
    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }
    public String getDescricao() {
        return descricao;
    }
    public Float getPreco() {
        return preco;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setPreco(Float preco) {
        this.preco = preco;
    }
}
