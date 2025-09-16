package com.sameul.sistemarestauranteapi.produto.service;

import com.sameul.sistemarestauranteapi.produto.controller.request.ProdutoRequest;
import com.sameul.sistemarestauranteapi.produto.service.response.ProdutoResponse;

public interface ProdutoService {
    ProdutoResponse salvar(ProdutoRequest request);
}
