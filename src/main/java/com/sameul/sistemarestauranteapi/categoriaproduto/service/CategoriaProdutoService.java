package com.sameul.sistemarestauranteapi.categoriaproduto.service;

import com.sameul.sistemarestauranteapi.categoriaproduto.dto.request.CategoriaProdutoRequest;
import com.sameul.sistemarestauranteapi.categoriaproduto.dto.response.CategoriaProdutoResponse;
import org.springframework.data.domain.Page;

public interface CategoriaProdutoService {

    CategoriaProdutoResponse salvar(CategoriaProdutoRequest request);
    CategoriaProdutoResponse buscarPorId(Integer id);
    Page<CategoriaProdutoResponse> listar(int page, int size);
    void deletar(Integer id);
}
