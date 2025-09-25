package com.sameul.sistemarestauranteapi.categoriaproduto.dto.request;

import com.sameul.sistemarestauranteapi.categoriaproduto.enums.CategoriaProdutoStatus;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class CategoriaProdutoRequest  {
    @NotBlank(message = "É necessário informar a descrição da categoria do produto")
    private String descricao;
    public String getDescricao() {
        return descricao;
    }

}
