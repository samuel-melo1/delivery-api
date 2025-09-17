package com.sameul.sistemarestauranteapi.produto.service;

import com.sameul.sistemarestauranteapi.produto.dto.request.ProdutoRequest;
import com.sameul.sistemarestauranteapi.produto.dto.response.ProdutoResponse;
import org.springframework.data.domain.Page;

public interface ProdutoService {
    ProdutoResponse salvar(ProdutoRequest request);
    ProdutoResponse buscarProdutoPorId(Integer id);

    Page<ProdutoResponse> listarProdutos(int page, int size); 
}
