package com.sameul.sistemarestauranteapi.produto.service.impl;

import com.sameul.sistemarestauranteapi.common.exceptions.ObjectNotFoundException;
import com.sameul.sistemarestauranteapi.produto.dto.request.ProdutoRequest;
import com.sameul.sistemarestauranteapi.produto.dto.response.ProdutoResponse;
import com.sameul.sistemarestauranteapi.produto.entity.Produto;
import com.sameul.sistemarestauranteapi.produto.enums.ProdutoErrorCode;
import com.sameul.sistemarestauranteapi.produto.enums.ProdutoStatus;
import com.sameul.sistemarestauranteapi.produto.mapper.ProdutoMapper;
import com.sameul.sistemarestauranteapi.produto.repository.ProdutoRepository;
import com.sameul.sistemarestauranteapi.produto.service.ProdutoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    @Override
    @Transactional
    public ProdutoResponse salvar(ProdutoRequest request) {
        log.info("Iniciando processo para salvar um novo produto.");
        Produto produto = mapper.requestToEntity(request);
        produto.setStatus(ProdutoStatus.ATIVO);

        Produto produtoSalvo = repository.save(produto);
        log.info("Produto salvo com sucesso com ID: {}", produtoSalvo.getId());
        return mapper.produtoToResponse(produtoSalvo);
    }
    @Override
    public ProdutoResponse buscarProdutoPorId(Integer id){
         Produto produto = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(ProdutoErrorCode.PRODUTO_NAO_ENCONTRADO));
         return mapper.produtoToResponse(produto);
    }

    @Override
    public Page<ProdutoResponse> listarProdutos(int page, int size) {
        return null;
    }
}
