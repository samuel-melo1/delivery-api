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
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;
    private static final Logger log = LoggerFactory.getLogger(ProdutoServiceImpl.class);
    public ProdutoServiceImpl(ProdutoRepository repository, ProdutoMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    @Transactional
    public ProdutoResponse salvar(ProdutoRequest request) {
        log.info("[ProdutoService] Iniciando processo para salvar produto: {}", request.getDescricao());
        Produto produto = mapper.requestToEntity(request);
        produto.setStatus(ProdutoStatus.ATIVO);

        Produto produtoSalvo = repository.save(produto);
        log.info("[ProdutoService] Produto salvo com sucesso com ID: {}", produtoSalvo.getId());
        return mapper.produtoToResponse(produtoSalvo);
    }
    @Override
    public ProdutoResponse buscarPorId(Integer id){
         Produto produto = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(ProdutoErrorCode.PRODUTO_NAO_ENCONTRADO));
         return mapper.produtoToResponse(produto);
    }

    @Override
    public Page<ProdutoResponse> listar(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("descricao").ascending());
        return repository.findAll(pageable)
                .map(mapper::produtoToResponse);
    }

    @Override
    @Transactional
    public void deletar(Integer id) {
        log.info("[ProdutoService] Buscando produto para deletar. ID: {}", id);
        Produto produto = repository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Produto não encontrado. ID: {}", id);
                    return new ObjectNotFoundException(ProdutoErrorCode.PRODUTO_NAO_ENCONTRADO);
                });
        repository.delete(produto);
        log.info("[ProdutoService] Produto deletado com sucesso. ID: {}", id);
    }
}
