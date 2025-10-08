package com.sameul.sistemarestauranteapi.categoriaproduto.dto.response;

import com.sameul.sistemarestauranteapi.categoriaproduto.enums.CategoriaProdutoStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CategoriaProdutoResponse implements Serializable {
    private CategoriaProdutoStatus status;
    private String descricao;
}
