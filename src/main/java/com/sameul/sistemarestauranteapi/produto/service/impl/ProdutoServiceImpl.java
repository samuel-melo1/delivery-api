package com.sameul.sistemarestauranteapi.produto.service.impl;

import com.sameul.sistemarestauranteapi.produto.controller.request.ProdutoRequest;
import com.sameul.sistemarestauranteapi.produto.service.ProdutoService;
import com.sameul.sistemarestauranteapi.produto.service.response.ProdutoResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl  implements ProdutoService {

    @Override
    @Transactional
    public ProdutoResponse salvar(ProdutoRequest request) {
        return null;
    }
}
